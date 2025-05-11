package com.moris.todolist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
        import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> taskList;
    private TaskAdapter adapter;
    private ListView taskListView;
    private Button addTaskBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskListView = findViewById(R.id.taskListView);
        addTaskBtn = findViewById(R.id.fab);

        taskList = new ArrayList<>();
        adapter = new TaskAdapter(this, taskList);
        taskListView.setAdapter(adapter);

        addTaskBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddEditTaskActivity .class);
            startActivityForResult(intent, 1);

        });

        taskListView.setOnItemLongClickListener((parent, view, position, id) -> {
            taskList.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
    }

    // Receive new tasks from AddEditTaskActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Task task = (Task) data.getSerializableExtra("task");
            taskList.add(task);
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
