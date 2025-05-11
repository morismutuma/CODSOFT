package com.moris.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

        import androidx.appcompat.app.AppCompatActivity;

public class AddEditTaskActivity extends AppCompatActivity {

    EditText title, desc, dueDate, priority;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_task);

        title = findViewById(R.id.taskTitle);
        desc = findViewById(R.id.taskDesc);
        dueDate = findViewById(R.id.taskDueDate);
        priority = findViewById(R.id.taskPriority);
        saveBtn = findViewById(R.id.saveTask);

        saveBtn.setOnClickListener(v -> {
            Task task = new Task(
                    title.getText().toString(),
                    desc.getText().toString(),
                    priority.getText().toString(),
                    dueDate.getText().toString(),
                    false
            );
            Intent resultIntent = new Intent();
            resultIntent.putExtra("task", task);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });
    }
}
