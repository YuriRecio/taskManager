package com.raphael.taskmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raphael.taskmanager.models.task;
import com.raphael.taskmanager.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<task> getAll() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public task create(@RequestBody task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public task update(@PathVariable Long id, @RequestBody task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
