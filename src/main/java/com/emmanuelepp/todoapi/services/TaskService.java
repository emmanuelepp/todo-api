package com.emmanuelepp.todoapi.services;

import com.emmanuelepp.todoapi.mapper.TaskDTOToTask;
import com.emmanuelepp.todoapi.persistence.entity.Task;
import com.emmanuelepp.todoapi.persistence.entity.TaskStatus;
import com.emmanuelepp.todoapi.persistence.repository.TaskRepository;
import com.emmanuelepp.todoapi.services.dto.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

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

    public List<Task> getTaskByState(TaskStatus status){
        return this.respository.findTaskByTaskStatus(status);
    }
    @Transactional
    public void updateTaskToComplete(Long id){
        this.respository.updateCompletedStatus(id);
    }
}
