package com.emmanuelepp.todoapi.mapper;

import com.emmanuelepp.todoapi.persistence.entity.Task;
import com.emmanuelepp.todoapi.persistence.entity.TaskStatus;
import com.emmanuelepp.todoapi.services.dto.TaskDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskDTOToTask implements IMapper<TaskDTO, Task> {

    @Override
    public Task map(TaskDTO in) {
        Task task = new Task();
        task.setTittle(in.getTittle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setCompleted(false);
        task.setTaskStatus(TaskStatus.ON_TIME);

        return task;
    }
}
