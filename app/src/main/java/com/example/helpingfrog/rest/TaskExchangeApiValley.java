package com.example.helpingfrog.rest;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.helpingfrog.MainActivity;
import com.example.helpingfrog.domain.Author;
import com.example.helpingfrog.domain.Importance;
import com.example.helpingfrog.domain.Task;
import com.example.helpingfrog.mapper.AuthorMapper;
import com.example.helpingfrog.mapper.ImportanceMapper;
import com.example.helpingfrog.mapper.TaskMapper;
import com.example.helpingfrog.noDb.NoDb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskExchangeApiValley implements TaskExchangeApi{

    public static final String API_TEST = "API_TEST";
    private final Context context;
    public static final String BASE_URL = "https://helping-frog.herokuapp.com/";
    private  Response.ErrorListener errorListener;


    public TaskExchangeApiValley(Context context) {
        this.context = context;
        errorListener = error -> Log.d(API_TEST, error.toString());
    }

    @Override
    public void fillTask() {

        for (int i = 0; i < 5; i++) {

            NoDb.TASK_LIST.add(new Task(String.format("%s", i), new Author(i, "AuthorName"), new Importance(i + 1, "ImportanceName")));

        }

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "task";

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

                                Importance importance = new ImportanceMapper().importanceFromTaskJson(jsonObject);

                                Author author = new AuthorMapper().authorFromTaskJson(jsonObject);

                                Task task = new TaskMapper().taskFromJson(jsonObject, author, importance);
                                NoDb.TASK_LIST.add(task);
                                NoDb.TASK_LIST.add(task);
                            }

                            ((MainActivity)context).updateAdapter();

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

        for (int i = 0; i < 5; i++) {

            NoDb.AUTHOR_LIST.add(new Author(i, "AuthorName"));

        }

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "author";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        NoDb.AUTHOR_LIST.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);
                                Author author = AuthorMapper.authorFromJson(jsonObject);
                                NoDb.AUTHOR_LIST.add(author);
                            }

                            Log.d(API_TEST, NoDb.AUTHOR_LIST.toString());
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
    public void fillImportance() {

        for (int i = 0; i < 5; i++) {

            NoDb.IMPORTANCE_LIST.add(new Importance(i, "ImportanceName"));

        }

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "importance";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        NoDb.IMPORTANCE_LIST.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);
                                Importance importance = ImportanceMapper.importanceFromJson(jsonObject);
                                NoDb.IMPORTANCE_LIST.add(importance);
                            }

                            Log.d(API_TEST, NoDb.IMPORTANCE_LIST.toString());
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
    public void addTask(Task task) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "task";

        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillTask();
                        Log.d(API_TEST, response);
                    }
                },
                errorListener
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map <String, String> params = new HashMap<>();

                params.put("name", task.getName());
                params.put("authorId", task.getAuthor().getName());
                params.put("importanceId", task.getImportance().getName());
                return params;
            }
        };

        requestQueue.add(request);

    }

    @Override
    public void updateTask(int id, String newTaskName, String newAuthorName, String newImportanceName) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "task/" + id;

        StringRequest request = new StringRequest(
                Request.Method.PUT,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillTask();
                        Log.d(API_TEST, response);
                    }
                },
                errorListener
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map <String, String> params = new HashMap<>();

                params.put("taskName", newTaskName);
                params.put("nameAuthor", newAuthorName);
                params.put("nameImportance", newImportanceName);
                return params;
            }
        };

        requestQueue.add(request);

    }

    @Override
    public void deleteTask(int id) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "task/" + id;

        StringRequest request = new StringRequest(
                Request.Method.DELETE,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillTask();
                        Log.d(API_TEST, response);
                    }
                },
                errorListener
        );

        requestQueue.add(request);

    }
}

