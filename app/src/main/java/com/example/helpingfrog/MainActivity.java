package com.example.helpingfrog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.helpingfrog.rest.TaskExchangeApiValley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new TaskExchangeApiValley(this).fillTask();
    }
}