package com.example.helpingfrog.rest;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.toolbox.Volley;
import com.example.helpingfrog.R;

public class AuthorizationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText auth_login;

    private EditText auth_password;

    private Button accept_auth_btn;

    private EditText register_login;

    private EditText register_password;

    private Button accept_register_btn;

    private TaskExchangeApiValley taskExchangeApiValley;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_authorization);

        auth_login = findViewById(R.id.auth_login);
        auth_password = findViewById(R.id.auth_password);
        accept_auth_btn = findViewById(R.id.btn_confirm_auth);
        register_login = findViewById(R.id.register_login);
        register_password = findViewById(R.id.register_password);
        accept_register_btn = findViewById(R.id.btn_confirm_register);

        accept_auth_btn.setOnClickListener(this);
        accept_register_btn.setOnClickListener(this);

        taskExchangeApiValley = new TaskExchangeApiValley(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm_auth:
                if (auth_login.getText().toString().trim().equals("") | auth_password.getText().toString().trim().equals("")) {
                    Toast.makeText(AuthorizationActivity.this, R.string.auth, Toast.LENGTH_SHORT).show();
                } else if(auth_login.getText().toString().trim().equals("Dsmrnv") & auth_password.getText().toString().trim().equals("pass")){
                    Toast.makeText(AuthorizationActivity.this, "Successful authorization!!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(AuthorizationActivity.this, ProfileActivity.class);
                    startActivity(i);
                    break;
                }else{

                    Toast.makeText(AuthorizationActivity.this, "can't find user!", Toast.LENGTH_LONG).show();
                }

            case R.id.btn_confirm_register:
                if (register_login.getText().toString().trim().equals("") | register_password.getText().toString().trim().equals("")) {

                    Toast.makeText(AuthorizationActivity.this, R.string.auth, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AuthorizationActivity.this, R.string.congrats, Toast.LENGTH_LONG).show();
                }

        }
    }

}
