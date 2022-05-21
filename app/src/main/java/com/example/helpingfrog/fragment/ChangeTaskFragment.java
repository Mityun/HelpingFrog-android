package com.example.helpingfrog.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.helpingfrog.R;
import com.example.helpingfrog.adapter.TaskAdapter;
import com.example.helpingfrog.domain.Task;

public class ChangeTaskFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change_task, container, false);

        Task task = (Task)getArguments().getSerializable(TaskAdapter.TASK_KEY);

        Toast.makeText(getContext(), task.toString(), Toast.LENGTH_LONG).show();

        return view;
    }
}