package com.ninjuh.javaspring.services;

import com.ninjuh.javaspring.repositories.UniversityRepository;
import com.ninjuh.javaspring.resources.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public List<University> getUniversities() {
        List<University> universities = new ArrayList<>();
        universityRepository.findAll().forEach(universities::add);
        return universities;
    }
}
