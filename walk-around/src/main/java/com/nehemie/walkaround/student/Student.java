package com.nehemie.walkaround.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nehemie.walkaround.school.School;
import com.nehemie.walkaround.studentprofile.StudentProfile;
import jakarta.persistence.*;

@Entity
@Table(name = "T_STUDENT")
public class Student {
    
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "c_fname", length = 20)
    private  String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private int age;
    
    @OneToOne(
           mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;
    
    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    // to avoid infinite loop (works with JsonManagedReference)
    // JsonBackReference for the child class in relation with the parent one
    // Means that this class doesn't have to serialize the parent class
    @JsonBackReference
    private School school;

    public Student() {
    }

    public Student(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
