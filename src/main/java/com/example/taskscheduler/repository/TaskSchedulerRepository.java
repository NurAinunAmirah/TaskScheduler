package com.example.taskscheduler.repository;

import com.example.taskscheduler.model.TaskScheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSchedulerRepository extends JpaRepository<TaskScheduler,Long> {
}
