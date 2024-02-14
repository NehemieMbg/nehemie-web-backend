package com.nehemie.walkaround;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {
    
    private final StudentRepository repository;

    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student psot(@RequestBody Student student) {
        return repository.save(student);
    }
    
    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return repository.findAll();
    }
    
    @GetMapping("/students/{student-id}")
    public Student findStudentById(@PathVariable("student-id") Integer id) {
        return repository.findById(id)
                .orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByName(@PathVariable("student-name") String name) {
        return repository.findAllByFirstnameContaining(name);
    }
    
    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("student-id") int id) {
        repository.deleteById(id);
    }
}
