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
import com.example.helpingfrog.adapter.TaskAdapter;
import com.example.helpingfrog.domain.Author;
import com.example.helpingfrog.domain.Importance;
import com.example.helpingfrog.domain.Task;
import com.example.helpingfrog.noDb.NoDb;
import com.example.helpingfrog.rest.TaskExchangeApiValley;

public class ChangeTaskFragment extends Fragment {

    private final int SERVER_STATE = 1;

    private AppCompatSpinner spAuthor, spImportance;
    private AuthorSpinnerAdapter authorSpinnerAdapter;
    private ImportanceSpinnerAdapter importanceSpinnerAdapter;
    private EditText etTaskNAme;
    private AppCompatButton btnChange;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change_task, container, false);

        Task task = (Task)getArguments().getSerializable(TaskAdapter.TASK_KEY);

        spAuthor = view.findViewById(R.id.sp_author);
        spImportance = view.findViewById(R.id.sp_importance);
        btnChange = view.findViewById(R.id.btn_add);
        etTaskNAme = view.findViewById(R.id.et_taskName);

        etTaskNAme.setText(task.getName());

        authorSpinnerAdapter = new AuthorSpinnerAdapter(getContext(), NoDb.AUTHOR_LIST);
        importanceSpinnerAdapter = new ImportanceSpinnerAdapter(getContext(), NoDb.IMPORTANCE_LIST);
        spAuthor.setAdapter(authorSpinnerAdapter);
        spImportance.setAdapter(importanceSpinnerAdapter);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SERVER_STATE == 1){

                    int id = task.getId();

                    NoDb.TASK_LIST.remove(id);

                    NoDb.TASK_LIST.add(
                            new Task(id,
                                    etTaskNAme.getText().toString(),
                                    (Author)spAuthor.getSelectedItem(),
                            (Importance)spImportance.getSelectedItem())
                    );


                }else {

                    new TaskExchangeApiValley(getContext()).updateTask(
                            task.getId(),
                            etTaskNAme.getText().toString(),
                            ((Author) spAuthor.getSelectedItem()).getName(),
                            ((Importance) spImportance.getSelectedItem()).getName()
                    );
                }

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(ChangeTaskFragment.this)
                        .commit();
            }
        });






        return view;
    }
}