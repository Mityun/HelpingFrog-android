package com.example.helpingfrog.rest;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helpingfrog.R;

public class WelcomeActivity extends AppCompatActivity {

    private Button btn_message_style;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btn_message_style = findViewById(R.id.btn_message_style);

        btn_message_style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeActivity.this, AuthorizationActivity.class);
                startActivity(i);
            }
        });
    }
}
