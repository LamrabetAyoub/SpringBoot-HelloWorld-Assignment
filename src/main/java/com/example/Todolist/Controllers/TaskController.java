package com.example.Todolist.Controllers;

import com.example.Todolist.Models.Task;
import com.example.Todolist.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }


    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }


    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }


    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        return taskService.deleteTaskById(id);
    }
}
