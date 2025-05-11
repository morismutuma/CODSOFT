package com.moris.todolist;

import android.content.Context;
import android.view.*;
        import android.widget.*;
        import java.util.*;

public class TaskAdapter extends ArrayAdapter<Task> {
    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_item, parent, false);

        CheckBox checkBox = convertView.findViewById(R.id.checkBox);
        TextView descText = convertView.findViewById(R.id.descText);

        checkBox.setText(task.getTitle());
        checkBox.setChecked(task.isCompleted());
        descText.setText(task.getDescription() + "\nDue: " + task.getDueDate() + " | Priority: " + task.getPriority());

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.setCompleted(isChecked);
            // You can add save logic here
        });

        return convertView;
    }
}
