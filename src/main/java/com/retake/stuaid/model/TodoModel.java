package com.retake.stuaid.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoModel {
    private final Long taskId;
    public String className;
    public String date;
    public String time;

    public TodoModel(String className, String date, String time, Long taskId) {
        this.className = className;
        this.date = date;
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        try {
            Date timeParse = timeFormat.parse(time);
            SimpleDateFormat time12Hour = new SimpleDateFormat("hh:mm a");
            this.time = time12Hour.format(timeParse);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        this.taskId = taskId;
    }

    public Long getTaskId() {
        return taskId;
    }
}
