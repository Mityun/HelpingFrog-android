package com.example.helpingfrog.noDb;

import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.helpingfrog.domain.Author;
import com.example.helpingfrog.domain.Importance;
import com.example.helpingfrog.domain.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiresApi(api = Build.VERSION_CODES.N)
public class NoDb {

    private NoDb(){}

    public static final List<Task> TASK_LIST = new ArrayList<Task>(Stream.of( new Task("1", new Author(1, "N"), new Importance(1, "S"))).collect(Collectors.toList()));
    public static final List<Author> AUTHOR_LIST = new ArrayList<Author>(Stream.of( new Author(1, "N")).collect(Collectors.toList()));
    public static final List<Importance> IMPORTANCE_LIST = new ArrayList<Importance>(Stream.of( new Importance(1, "S")).collect(Collectors.toList()));

}