package com.example.webappmvcservlet.models;

import java.io.Serializable;

public class Person implements Serializable {
    public  Person(int id,String name, String phone, String email){
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.email=email;
    }
    private  int id;
    private String name;
    private String phone;
    private String email;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    public String getName(){
     return  name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }
}

