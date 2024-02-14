package com.nehemie.walkaround;

import jakarta.persistence.*;

@Entity
public class StudentProfile {
    
    @Id
    @GeneratedValue
    private int id;
    private String bio;
    
    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    public StudentProfile() {
    }

    public StudentProfile(int id, String bio) {
        this.id = id;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
