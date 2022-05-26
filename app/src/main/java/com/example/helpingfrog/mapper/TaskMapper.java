package com.example.helpingfrog.mapper;

import com.example.helpingfrog.domain.Author;
import com.example.helpingfrog.domain.Importance;
import com.example.helpingfrog.domain.Task;

import org.json.JSONException;
import org.json.JSONObject;

public class TaskMapper {

    public static Task taskFromJson(JSONObject jsonObject, Author author, Importance importance) {

        Task task = null;

        try {
            task = new Task(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    author,
                    importance
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return task;
    }
}
