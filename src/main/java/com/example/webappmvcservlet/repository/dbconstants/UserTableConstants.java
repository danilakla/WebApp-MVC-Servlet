package com.example.webappmvcservlet.repository.dbconstants;

public enum UserTableConstants {
    ID("id"),
    LOGIN("login"),
    PASSW("passw");
    private String fieldName;

    UserTableConstants(String fieldName) {
        this.fieldName=fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
