package com.example.taskscheduler.controller;

import com.example.taskscheduler.model.TaskScheduler;
import com.example.taskscheduler.repository.TaskSchedulerRepository;
import com.example.taskscheduler.service.TaskSchedulerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskSchedulerController {
    @Autowired
    private TaskSchedulerService taskSchedulerService;

    @PostMapping("/add")
    public TaskScheduler addTask(@RequestParam String description, @RequestParam String dateTime){
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTime);
        TaskScheduler task = new TaskScheduler(description,parsedDateTime);
        return taskSchedulerService.addTask(task);
    }

    @GetMapping("/list")
    public List<TaskScheduler> listTasks(){
        return taskSchedulerService.getAllTasks();
    }
}
