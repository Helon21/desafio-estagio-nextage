package com.api.api_nextage.service;

import com.api.api_nextage.entity.Task;
import com.api.api_nextage.entity.enums.TaskEnum;
import com.api.api_nextage.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setStatus(TaskEnum.IN_PROGRESS);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    public List<Task> findByCreatedAt(LocalDateTime createdAt) {
        return taskRepository.findByCreatedAt(createdAt);
    }

    public List<Task> findByStatus(TaskEnum status) {
        return taskRepository.findByStatus(status);
    }

    public Task updateTask(Task task, Long id) {
        Task taskToUpdate = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found")
        );
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        return taskRepository.save(taskToUpdate);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
