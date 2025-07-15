package com.raphael.taskmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.taskmanager.models.task;
import com.raphael.taskmanager.repositories.TaskRepository;

@Service
public class TaskService {

	 @Autowired
	    private TaskRepository taskRepository;

	    public List<task> getAllTasks() {
	        return taskRepository.findAll();
	    }

	    public Optional<task> getTaskById(Long id) {
	        return taskRepository.findById(id);
	    }

	    public task createTask(task task) {
	        return taskRepository.save(task);
	    }

	    public void deleteTask(Long id) {
	        taskRepository.deleteById(id);
	    }

	    public task updateTask(Long id, task newTask) {
	        return taskRepository.findById(id).map(task -> {
	            task.setTitle(newTask.getTitle());
	            task.setDescription(newTask.getDescription());
	            task.setCompleted(newTask.isCompleted());
	            return taskRepository.save(task);
	        }).orElse(null);
	    }
	
}
