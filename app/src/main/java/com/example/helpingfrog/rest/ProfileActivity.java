package com.example.helpingfrog.rest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpingfrog.MainActivity;
import com.example.helpingfrog.R;
import com.example.helpingfrog.adapter.StateAdapter;
import com.example.helpingfrog.domain.State;
import com.example.helpingfrog.noDb.NoDb;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView profile_pic;

    static final int GALLERY_REQUEST = 1;

    private RecyclerView rvNft;

    ArrayList<State> states = new ArrayList<State>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        rvNft = findViewById(R.id.rv_nft);

        // Инициализируем компонент
        TextView textView = findViewById(R.id.total_u_hours);
        textView.setText(String.format("Total hours: %s", NoDb.TOTAL_HOURS));

        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.rv_nft);
        // создаем адаптер
        StateAdapter adapter = new StateAdapter(this, states);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        Button button = findViewById(R.id.btn_set_user_pic);
        Button btn_to_tasks = findViewById(R.id.btnp_to_tasks);
        button.setOnClickListener(this);
        btn_to_tasks.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_set_user_pic:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
                break;
            case R.id.btnp_to_tasks:
                Intent i = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(i);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;
        ImageView imageView = (ImageView) findViewById(R.id.profile_pic);

        switch(requestCode) {
            case GALLERY_REQUEST:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageView.setImageBitmap(bitmap);
                }
        }
    }

    // сохранение состояния
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//
//        outState.putString(nameVariableKey, name);
//        super.onSaveInstanceState(outState);
//    }
//    // получение ранее сохраненного состояния
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        name = savedInstanceState.getString(nameVariableKey);
//        nameView.setText(name);
//    }

    private void setInitialData(){

        states.add(new State (R.drawable.frog_nft));
        states.add(new State (R.drawable.frog_nft));
        states.add(new State (R.drawable.frog_nft));
        states.add(new State (R.drawable.frog_nft));
        states.add(new State (R.drawable.frog_nft));
        states.add(new State (R.drawable.frog_nft));
        states.add(new State (R.drawable.frog_nft));
        states.add(new State (R.drawable.frog_nft));
        states.add(new State (R.drawable.frog_nft));
        states.add(new State (R.drawable.frog_nft));
        states.add(new State (R.drawable.frog_nft));
    }
}
