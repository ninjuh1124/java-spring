package com.ninjuh.javaspring.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UNIVERSITY")
public class University {
    @Id
    @Column(name = "NAME")
    private String name;

    @Column(name = "NUMBER_OF_STUDENTS")
    private int numberOfStudents;

    @Column(name = "SEMESTER_COSTS")
    @JsonIgnore     // value will be ignored when converting object into json, ie won't be sent to user
    private int semesterCosts;

    public University(String name, int numberOfStudents, int semesterCosts) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.semesterCosts = semesterCosts;
    }

    public University(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getSemesterCosts() {
        return semesterCosts;
    }

    public void setSemesterCosts(int semesterCosts) {
        this.semesterCosts = semesterCosts;
    }
}
