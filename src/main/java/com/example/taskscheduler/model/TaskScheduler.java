package com.example.taskscheduler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TaskScheduler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDateTime dateTime;

    public TaskScheduler(){}

    public TaskScheduler(String description, LocalDateTime dateTime){
        this.description=description;
        this.dateTime=dateTime;

    }
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setDateTime(){
        this.dateTime=dateTime;
    }

}
