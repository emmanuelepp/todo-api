package com.emmanuelepp.todoapi.controller;

import com.emmanuelepp.todoapi.persistence.entity.Task;
import com.emmanuelepp.todoapi.persistence.entity.TaskStatus;
import com.emmanuelepp.todoapi.services.TaskService;
import com.emmanuelepp.todoapi.services.dto.TaskDTO;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable("status")TaskStatus status){
        return this.taskService.getTaskByState(status);
    }

    @PatchMapping("/updateAsCompleted/{id}")
    public ResponseEntity<Void>markTaskAsCompleted(@PathVariable("id") Long id){
        this.taskService.updateTaskToComplete(id);

        return ResponseEntity.noContent().build();
    }
}
