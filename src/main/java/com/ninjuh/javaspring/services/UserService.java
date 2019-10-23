package com.ninjuh.javaspring.services;

import com.ninjuh.javaspring.repositories.UserRepository;
import com.ninjuh.javaspring.resources.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired      // generates one repository from which other services can connect to
    private UserRepository userRepository;

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Transactional  // locks the repo until connection is closed
    public void addUser(User user) { userRepository.save(user); }

    @Transactional
    public void addUsers(List<User> users) {
        for (User user : users) userRepository.save(user);
    }
}
