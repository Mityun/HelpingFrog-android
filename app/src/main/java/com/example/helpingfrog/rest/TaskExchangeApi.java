package com.example.helpingfrog.rest;

import com.example.helpingfrog.domain.Task;

public interface TaskExchangeApi {

    void fillTask();

    void fillAuthor();

    void fillImportance();

    void addTask(Task task);

    void updateTask(
            int id,
            String newTaskName,
            String newAuthorName,
            String newImportanceName
    );

    void deleteTask(int id);




}
