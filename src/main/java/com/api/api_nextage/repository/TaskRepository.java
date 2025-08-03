package com.api.api_nextage.repository;

import com.api.api_nextage.entity.Task;
import com.api.api_nextage.entity.enums.TaskEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTitle(String title);
    List<Task> findByCreatedAt(LocalDateTime createdAt);
    List<Task> findByStatus(TaskEnum status);
}
