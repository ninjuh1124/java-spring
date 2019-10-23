package com.ninjuh.javaspring.controllers;

import com.ninjuh.javaspring.resources.User;
import com.ninjuh.javaspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@RestController
public class UserController {
    private final String CONTEXT = "/api/v1/User";
    private final Logger LOGGER = Logger.getLogger(UserController.class.getName());
    private FileHandler fileHandler;

    public UserController() {
        try {
            fileHandler = new FileHandler("log.log", 1024*8, 1, true);
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.setLevel(Level.FINE);
            fileHandler.setLevel(Level.INFO);
        } catch(IOException io) {
            System.out.println("ERROR: Could not set logging handler to file");
        }
    }

    @Autowired      // creates one service to which other controllers can connect
    private UserService userService;

    @GetMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        LOGGER.info("Returning list of users");
        return userService.getUsers();
    }

    @PostMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        LOGGER.info("Adding user");
        userService.addUser(user);
    }
}
