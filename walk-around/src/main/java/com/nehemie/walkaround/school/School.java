package com.nehemie.walkaround.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nehemie.walkaround.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class School {
    
    @Id
    @GeneratedValue
    private int id;
    private String name;
    
    // to stop infinite loop between relation classes
    // JsonManagedReference - for the parent class
    // So this class serialize the child class
    @OneToMany(
            mappedBy = "school"
    )
    @JsonManagedReference
    private List<Student> students;

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
