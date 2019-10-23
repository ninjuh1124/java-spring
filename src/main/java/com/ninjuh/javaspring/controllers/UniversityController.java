package com.ninjuh.javaspring.controllers;

import com.ninjuh.javaspring.resources.University;
import com.ninjuh.javaspring.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UniversityController {
    private final String CONTEXT = "/api/v1/University";

    @Autowired
    private UniversityService universityService;

    @GetMapping(value = CONTEXT)
    public List<University> getUniversities() { return universityService.getUniversities(); }
}
