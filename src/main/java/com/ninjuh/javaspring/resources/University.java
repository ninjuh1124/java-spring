package com.ninjuh.javaspring.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Entity
@Table(name = "UNIVERSITY")
public class University {
    @Id
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "university")
    // @JsonIgnore
    private List<User> users;

    @Column(name = "SEMESTER_COSTS")
    private int semesterCosts;

    public University(String name, int semesterCosts) {
        this.name = name;
        this.semesterCosts = semesterCosts;
    }

    public University(){}

    public String getName() {
        return name;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUsers() {
        List<String> names = new ArrayList<>();

        for (User user : users) {
            names.add(user.getName());
        }

        return names;
    }

    public int getSemesterCosts() {
        return semesterCosts;
    }

    public void setSemesterCosts(int semesterCosts) {
        this.semesterCosts = semesterCosts;
    }
}
