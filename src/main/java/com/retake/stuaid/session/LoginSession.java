package com.retake.stuaid.session;

public final class LoginSession {
    private static LoginSession instance;
    private String email;
    private String name;
    private Character userType;

    private LoginSession(String email, String name, char userType) {
        this.email = email;
        this.name = name;
        this.userType = userType;
    }

    public static LoginSession getLoginSession(String email, String name, char userType) {
        if (instance == null) {
            instance = new LoginSession(email, name, userType);
        }

        return instance;
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

    public void cleanLoginSession() {
        this.email = null;
        this.name = null;
        this.userType = null;
        LoginSession.instance = null;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Email: " + this.email + ", UserType: " + this.userType;
    }
}
