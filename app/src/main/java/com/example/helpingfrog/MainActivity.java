package com.example.helpingfrog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helpingfrog.adapter.TaskAdapter;
import com.example.helpingfrog.domain.Author;
import com.example.helpingfrog.domain.Importance;
import com.example.helpingfrog.domain.Task;
import com.example.helpingfrog.noDb.NoDb;
import com.example.helpingfrog.rest.TaskExchangeApiValley;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTask;
    private TaskAdapter taskAdapter;
    private TaskExchangeApiValley taskExchangeApiValley;

    private ItemTouchHelper.SimpleCallback simpleCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new TaskExchangeApiValley(this).fillTask();

        rvTask = findViewById(R.id.rv_task);

        taskAdapter = new TaskAdapter(this, NoDb.TASK_LIST);
        rvTask.setAdapter(taskAdapter);

        simpleCallback = new ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT // ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT (TODO: обработка принятия таски свайпом вправо)
        ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                Task task = NoDb.TASK_LIST.get(viewHolder.getAdapterPosition());

                if (direction == ItemTouchHelper.LEFT) {
                    taskExchangeApiValley.deleteTask(task.getId());
                }

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper((simpleCallback));

    }

    public void updateAdapter(){

        taskAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {

        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();

        int size = fragmentList.size();

        if (size > 0){
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragmentList.get(size - 1))
                    .commit();
        } else {
            finish();
        }
    }
}