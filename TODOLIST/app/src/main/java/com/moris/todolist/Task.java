package com.moris.todolist;

import java.io.Serializable;

public class Task implements Serializable {
    private String title;
    private String description;
    private boolean isCompleted;
    private String priority;
    private String dueDate;

    public Task(String title, String description, String priority, String dueDate, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public String getDueDate() { return dueDate; }
    public boolean isCompleted() { return isCompleted; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public void setCompleted(boolean completed) { isCompleted = completed; }
}
