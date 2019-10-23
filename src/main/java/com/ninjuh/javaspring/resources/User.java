package com.ninjuh.javaspring.resources;

import javax.persistence.*;

@Entity
public class User {
    @Column(unique = true)
    private String name;

    @Id
    @GeneratedValue
    private long Id;

    @ManyToOne
    private University university;

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
