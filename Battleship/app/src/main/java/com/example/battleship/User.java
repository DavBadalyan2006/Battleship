package com.example.battleship;

public class User {

    private String uid;
    private String email;
    private boolean online;

    public User(String uid, String email, boolean online) {
        this.uid = uid;
        this.email = email;
        this.online = online;
    }
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}


