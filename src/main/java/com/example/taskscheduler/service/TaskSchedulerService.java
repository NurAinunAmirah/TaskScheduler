package com.example.taskscheduler.service;

import com.example.taskscheduler.model.TaskScheduler;
import com.example.taskscheduler.repository.TaskSchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskSchedulerService {

    @Autowired
    private TaskSchedulerRepository taskSchedulerRepository;

    public TaskScheduler addTask(TaskScheduler task){
        return taskSchedulerRepository.save(task);
    }

    public List<TaskScheduler> getAllTasks(){
        return taskSchedulerRepository.findAll();
    }
}
