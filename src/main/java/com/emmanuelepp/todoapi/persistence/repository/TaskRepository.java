package com.emmanuelepp.todoapi.persistence.repository;

import com.emmanuelepp.todoapi.persistence.entity.Task;
import com.emmanuelepp.todoapi.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
   public List<Task> findTaskByTaskStatus(TaskStatus status);

   @Modifying
   @Query(value = "UPDATE TASK SET COMPLETED=true WHERE ID = :id",nativeQuery = true)
   public void updateCompletedStatus(@Param("id") Long id);
}
