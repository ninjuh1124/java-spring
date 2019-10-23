package com.ninjuh.javaspring.repositories;

import com.ninjuh.javaspring.resources.University;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UniversityRepository extends CrudRepository<University, String> {
    List<University> findByName(String name);
}
