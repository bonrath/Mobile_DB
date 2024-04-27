package com.example.user_profile_db;

public class User {
    private String id,name, pass;

    public User(String id, String name, String pass ){
        this.id =id;
        this.name=name;
        this.pass=pass;
    }
    //


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
