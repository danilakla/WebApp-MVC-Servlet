package com.example.webappmvcservlet.models;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private  String login;
    private byte[] passw;

    public User(int id, String login,byte[] passw){
        this.id=id;
        this.login=login;
        this.passw=passw;
    }
    public User( String login,byte[] passw){
        this.id=id;
        this.login=login;
        this.passw=passw;
    }


    public byte[] getPassw() {
        return passw;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }
    @Override
    public  String toString(){
        return  login+" "+ passw.toString()+" ";
    }
}
