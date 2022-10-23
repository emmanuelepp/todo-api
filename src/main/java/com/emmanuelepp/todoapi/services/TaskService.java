package com.emmanuelepp.todoapi.services;

import com.emmanuelepp.todoapi.mapper.TaskDTOToTask;
import com.emmanuelepp.todoapi.persistence.entity.Task;
import com.emmanuelepp.todoapi.persistence.repository.TaskRepository;
import com.emmanuelepp.todoapi.services.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository respository;
    private final TaskDTOToTask mapper;

    public TaskService(TaskRepository respository, TaskDTOToTask mapper) {
        this.respository = respository;
        this.mapper = mapper;
    }

    public Task createTask(TaskDTO taskDTO){
          Task task = mapper.map(taskDTO);
          return this.respository.save(task);
    }

    public List<Task> getAllTasks(){
        return this.respository.findAll();
    }
}
