package com.ninjuh.javaspring.repositories;

import com.ninjuh.javaspring.resources.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
    List<User> findByUniversityName(String name);
}
