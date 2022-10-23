package com.emmanuelepp.todoapi.persistence.repository;

import com.emmanuelepp.todoapi.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
