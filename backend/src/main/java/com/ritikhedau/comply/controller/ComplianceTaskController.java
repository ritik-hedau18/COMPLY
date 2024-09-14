package com.ritikhedau.comply.controller;

import com.ritikhedau.comply.entity.ComplianceTask;
import com.ritikhedau.comply.repository.ComplianceTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class ComplianceTaskController {
    @Autowired
    private ComplianceTaskRepository taskRepository;

    @GetMapping
    public ResponseEntity<List<ComplianceTask>> list() {
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<ComplianceTask> create(@RequestBody ComplianceTask task) {
        return ResponseEntity.ok(taskRepository.save(task));
    }
}