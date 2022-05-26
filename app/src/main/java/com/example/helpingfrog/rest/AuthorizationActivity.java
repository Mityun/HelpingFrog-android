package com.example.helpingfrog.rest;

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

public class AuthorizationActivity extends AppCompatActivity {

    private EditText auth_login;

    private EditText auth_password;

    private Button accept_auth_btn;

    private EditText register_login;

    private EditText register_password;

    private Button accept_register_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth_login = findViewById(R.id.auth_login);
        auth_password = findViewById(R.id.auth_password);
        accept_auth_btn = findViewById(R.id.btn_confirm_auth);
        register_login = findViewById(R.id.register_login);
        register_password = findViewById(R.id.register_password);
        accept_register_btn = findViewById(R.id.btn_confirm_register);

        accept_auth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (auth_login.getText().toString().trim().equals("") | auth_login.getText().toString().trim().equals("")){

                    Toast.makeText(AuthorizationActivity.this, R.string.auth, Toast.LENGTH_LONG).show();
                }
                else{


                }

            }
        });

    }
}
