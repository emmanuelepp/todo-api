package com.emmanuelepp.todoapi.controller;

import com.emmanuelepp.todoapi.persistence.entity.Task;
import com.emmanuelepp.todoapi.services.TaskService;
import com.emmanuelepp.todoapi.services.dto.TaskDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
private  final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO){
        return this.taskService.createTask(taskDTO);
    }

    @GetMapping
    public List<Task> getTasks(){
        return this.taskService.getAllTasks();
    }
}
