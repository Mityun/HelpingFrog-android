package com.example.helpingfrog.noDb;

import com.example.helpingfrog.domain.Author;
import com.example.helpingfrog.domain.Importance;
import com.example.helpingfrog.domain.Task;

import java.util.ArrayList;
import java.util.List;

public class NoDb {

    private NoDb(){}

    public static final List<Task> TASK_LIST = new ArrayList<>();
    public static final List<Author> AUTHOR_LIST = new ArrayList<>();
    public static final List<Importance> IMPORTANCE_LIST = new ArrayList<>();


}
