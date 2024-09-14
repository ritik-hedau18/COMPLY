package com.ritikhedau.comply.service;
import org.springframework.stereotype.Service;

@Service
public class ComplianceTaskService {
    public String performAction(String action) {
        return "Action '" + action + "' processed successfully in ComplianceTaskService.";
    }
}