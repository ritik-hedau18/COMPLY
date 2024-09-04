package com.ritikhedau.comply.batch;

import com.ritikhedau.comply.entity.ComplianceTask;
import com.ritikhedau.comply.repository.ComplianceTaskRepository;
import com.ritikhedau.comply.service.NotificationService;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class ComplianceBatchConfig {

    @Autowired
    private ComplianceTaskRepository taskRepository;

    @Autowired
    private NotificationService notificationService;

    @Bean
    public ListItemReader<ComplianceTask> reader() {
        // Query tasks that are PENDING and close to deadline (next 5 days) or OVERDUE
        List<ComplianceTask> overdueTasks = taskRepository.findByStatusAndDueDateBefore("PENDING", LocalDate.now().plusDays(5));
        return new ListItemReader<>(overdueTasks);
    }

    @Bean
    public ItemProcessor<ComplianceTask, ComplianceTask> processor() {
        return task -> {
            // Mock penalty recalculations before alerts
            if (LocalDate.now().isAfter(task.getDueDate())) {
                task.setEstimatedPenalty(500.0); // Standard flat penalty bump in alert batches
            }
            return task;
        };
    }

    @Bean
    public ItemWriter<ComplianceTask> writer() {
        return tasks -> {
            for (ComplianceTask task : tasks) {
                taskRepository.save(task);
                // Dispatch alert
                notificationService.sendComplianceAlert(
                        task.getCompanyId(),
                        task.getId(),
                        "WHATSAPP",
                        "admin@company.com",
                        "Urgent: Regulatory task '" + task.getTitle() + "' is approaching deadline/overdue. Est. Penalty: Rs. " + task.getEstimatedPenalty()
                );
            }
        };
    }

    @Bean
    public Step complianceStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("complianceStep", jobRepository)
                .<ComplianceTask, ComplianceTask>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job complianceAlertJob(JobRepository jobRepository, Step complianceStep) {
        return new JobBuilder("complianceAlertJob", jobRepository)
                .start(complianceStep)
                .build();
    }
}
