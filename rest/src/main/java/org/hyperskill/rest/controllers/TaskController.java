package org.hyperskill.rest.controllers;

import org.hyperskill.rest.tasks.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final List<Task> taskList = List.of(
            new Task(1, "task1", "A first test task", false),
            new Task(2, "task2", "A second test task", true)
    );
    
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskList;
    }   
    
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable int id) {
        return new ResponseEntity<>(taskList.get(id -1), HttpStatus.ACCEPTED);
    }
}
