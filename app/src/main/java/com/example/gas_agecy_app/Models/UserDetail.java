package com.example.gas_agecy_app.Models;

public class UserDetail {
    private String uid;
    private String name;
    public UserDetail(){

    }

    public UserDetail(String uid,String name){
        this.uid = uid;
        this.name=name;
    }

    public String getUid(){
        return uid;
    }
    public String getName(){
        return name;
    }

}


