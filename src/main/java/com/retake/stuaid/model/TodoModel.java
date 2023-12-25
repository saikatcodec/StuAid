package com.retake.stuaid.model;

public class TodoModel {
    private Long taskId;
    public String className;
    public String date;
    public String time;

    public TodoModel(String className, String date, String time, Long taskId) {
        this.className = className;
        this.date = date;
        this.time = time;
        this.taskId = taskId;
    }

    public Long getTaskId() {
        return taskId;
    }
}
