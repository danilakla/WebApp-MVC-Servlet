package com.example.webappmvcservlet.command.infrastructure;
public enum Page {
    LOGIN("login"),
    SIGN_OUT("sign_out"),
    WELCOME("welcome"),
    REGISTER_NEW_USER("register_new_user"),
    ADD_NEW_PERSON ("add_new_person"),
    LOGIN_PAGE("login_page"),
    REGISTRATION_PAGE("registration_page");
    private String command;
    public  String getPage(){
        return this.command;
    }
    private Page(String command) {
        this.command = command;
    }
}
