package com.example.helpingfrog.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpingfrog.R;
import com.example.helpingfrog.domain.Task;
import com.example.helpingfrog.fragment.ChangeTaskFragment;
import com.example.helpingfrog.noDb.NoDb;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String TASK_KEY = "task";
    private final Context context;
    private final LayoutInflater inflater;
    private final List<Task> taskList;


    public TaskAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.taskList = taskList;
    }

    private class MyHolder extends RecyclerView.ViewHolder{

        private TextView
                tvName,
                tvAuthor,
                tvImportance;

        private LinearLayout ll_item;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            ll_item = itemView.findViewById(R.id.ll_item);
            tvName = itemView.findViewById(R.id.tv_task_name);
            tvAuthor = itemView.findViewById(R.id.tv_author_name);
            tvImportance = itemView.findViewById(R.id.tv_importance_name);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.task_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Task task = taskList.get(position);

        ((MyHolder)holder).tvName.setText(task.getName());
        ((MyHolder)holder).tvAuthor.setText(task.getAuthor().getName());
        ((MyHolder)holder).tvImportance.setText(task.getImportance().getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ChangeTaskFragment changeTaskFragment = new ChangeTaskFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable(TASK_KEY, task);
                changeTaskFragment.setArguments(bundle);

                ((AppCompatActivity)context).getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, changeTaskFragment)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {

        return NoDb.TASK_LIST.size();
    }

}
