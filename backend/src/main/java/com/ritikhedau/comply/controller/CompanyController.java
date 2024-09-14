package com.ritikhedau.comply.controller;

import com.ritikhedau.comply.entity.Company;
import com.ritikhedau.comply.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public ResponseEntity<List<Company>> list() {
        return ResponseEntity.ok(companyRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company company) {
        return ResponseEntity.ok(companyRepository.save(company));
    }
}