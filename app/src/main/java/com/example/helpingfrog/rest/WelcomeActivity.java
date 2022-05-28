package com.example.helpingfrog.rest;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.helpingfrog.R;

public class WelcomeActivity extends AppCompatActivity {

    private AppCompatButton btn_message_style;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btn_message_style = (AppCompatButton) findViewById(R.id.btn_message_style);

        btn_message_style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_message_style:
                        Intent i = new Intent(WelcomeActivity.this, AuthorizationActivity.class);
                        startActivity(i);
                }

            }
        });
    }
}
