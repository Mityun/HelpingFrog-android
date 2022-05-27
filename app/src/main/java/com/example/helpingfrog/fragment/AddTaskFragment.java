package com.example.helpingfrog.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.helpingfrog.R;
import com.example.helpingfrog.adapter.AuthorSpinnerAdapter;
import com.example.helpingfrog.adapter.ImportanceSpinnerAdapter;
import com.example.helpingfrog.domain.Author;
import com.example.helpingfrog.domain.Importance;
import com.example.helpingfrog.domain.Task;
import com.example.helpingfrog.noDb.NoDb;
import com.example.helpingfrog.rest.TaskExchangeApiValley;

import java.util.zip.Inflater;


public class AddTaskFragment extends Fragment {

    public final int SERVER_STATE = 1;

    private AppCompatSpinner spAuthor, spImportance;
    private AuthorSpinnerAdapter authorSpinnerAdapter;
    private ImportanceSpinnerAdapter importanceSpinnerAdapter;
    private EditText etTaskNAme;
    private AppCompatButton btnAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);

        spAuthor = view.findViewById(R.id.sp_author);
        spImportance = view.findViewById(R.id.sp_importance);
        btnAdd = view.findViewById(R.id.btn_add);
        etTaskNAme = view.findViewById(R.id.et_taskName);

        authorSpinnerAdapter = new AuthorSpinnerAdapter(getContext(), NoDb.AUTHOR_LIST);
        importanceSpinnerAdapter = new ImportanceSpinnerAdapter(getContext(), NoDb.IMPORTANCE_LIST);
        spAuthor.setAdapter(authorSpinnerAdapter);
        spImportance.setAdapter(importanceSpinnerAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SERVER_STATE == 1){

                    NoDb.TASK_LIST.add(new Task(
                            etTaskNAme.getText().toString(),
                            ((Author)spAuthor.getSelectedItem()),
                            ((Importance)spImportance.getSelectedItem())
                    ));

                }else {

                    new TaskExchangeApiValley(getContext()).addTask(
                            new Task(
                                    etTaskNAme.getText().toString(),
                                    ((Author) spAuthor.getSelectedItem()),
                                    ((Importance) spImportance.getSelectedItem())
                            )
                    );
                }

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(AddTaskFragment.this)
                        .commit();
            }
        });



        return view;
    }
}
