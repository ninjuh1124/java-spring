package com.ninjuh.javaspring.resources;

import javax.persistence.*;

@Entity
public class User {
    @Column(unique = true, name = "NAME")
    private String name;

    @Id
    @GeneratedValue
    private long Id;

    @ManyToOne
    @JoinColumn
    private University university;

    public User() {}

    public User(String name, University university) {
        this.name = name;
        this.university = university;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university.getName();
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
