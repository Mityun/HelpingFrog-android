package com.example.helpingfrog.rest;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.helpingfrog.domain.Task;
import com.example.helpingfrog.mapper.TaskMapper;
import com.example.helpingfrog.noDb.NoDb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TaskExchangeApiValley implements TaskExchangeApi{

    public static final String API_TEST = "API_TEST";
    private final Context context;
    public static final String BASE_URL = "http://192.168.1.2:8081";
    private  Response.ErrorListener errorListener;


    public TaskExchangeApiValley(Context context) {
        this.context = context;
        errorListener = error -> Log.d(API_TEST, error.toString());
    }

    @Override
    public void fillTask() {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/task";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        NoDb.TASK_LIST.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);
                                Task task = TaskMapper.taskFromJson(jsonObject);
                                NoDb.TASK_LIST.add(task);
                            }

                            Log.d(API_TEST, NoDb.TASK_LIST.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                errorListener
        );

        requestQueue.add(arrayRequest);
    }

    @Override
    public void fillAuthor() {

    }

    @Override
    public void fillImportance() {

    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void updateTask(int id, String newTaskName, String newAuthorName, String newImportanceName) {

    }
}
