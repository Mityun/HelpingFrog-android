package com.example.helpingfrog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helpingfrog.adapter.TaskAdapter;
import com.example.helpingfrog.domain.Author;
import com.example.helpingfrog.domain.Importance;
import com.example.helpingfrog.domain.Task;
import com.example.helpingfrog.noDb.NoDb;
import com.example.helpingfrog.rest.TaskExchangeApiValley;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTask;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new TaskExchangeApiValley(this).fillTask();

        rvTask = findViewById(R.id.rv_task);

        taskAdapter = new TaskAdapter(this, NoDb.TASK_LIST);
        rvTask.setAdapter(taskAdapter);

    }

    public void updateAdapter(){

        taskAdapter.notifyDataSetChanged();
    }
}