package com.raphael.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.raphael.taskmanager.models.task;

public interface TaskRepository extends JpaRepository<task, Long> {
   
}