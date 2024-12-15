package com.example.Todolist.Services;

import com.example.Todolist.Models.Task;
import com.example.Todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }


    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public String deleteTaskById(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return "Task with ID " + id + " deleted successfully!";
        } else {
            return "Task with ID " + id + " not found!";
        }
    }
}
