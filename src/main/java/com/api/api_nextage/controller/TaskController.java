package com.api.api_nextage.controller;

import com.api.api_nextage.entity.Task;
import com.api.api_nextage.entity.enums.TaskEnum;
import com.api.api_nextage.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));
    }

    @GetMapping("/title")
    public ResponseEntity<List<Task>> findByTitle(@RequestParam String title) {
        return ResponseEntity.ok(taskService.findByTitle(title));
    }

    @GetMapping("/find-by-createdAt")
    public ResponseEntity<List<Task>> findByCreatedAt(@RequestParam LocalDateTime createdAt) {
        return ResponseEntity.ok(taskService.findByCreatedAt(createdAt));
    }

    @GetMapping("/status")
    public ResponseEntity<List<Task>> findByStatus(@RequestParam TaskEnum status) {
        return ResponseEntity.ok(taskService.findByStatus(status));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable Long id) {
        return ResponseEntity.ok(taskService.updateTask(task, id));
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
