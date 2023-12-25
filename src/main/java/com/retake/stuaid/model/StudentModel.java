package com.retake.stuaid.model;

public class StudentModel {
    private String email;
    private String name;
    private char userType;

    public StudentModel(String email, String name, char userType) {
        this.email = email;
        this.name = name;
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public char getUserType() {
        return userType;
    }
}
