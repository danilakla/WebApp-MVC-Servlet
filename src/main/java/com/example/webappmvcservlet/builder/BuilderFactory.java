package com.example.webappmvcservlet.builder;

public class BuilderFactory {
    private static final String USER = "Users";
    private static final String PERSON = "Persons";
    private static final String MESSAGE= "Unknown Builder name!";
    public static Builder create(String builderName) {
        switch (builderName) {
            case USER: {
                return new UserBuilder();
            }
            case PERSON: {
                return new PersonBuilder();
            }
            default:
                throw new IllegalArgumentException(MESSAGE);
        }
    }
}
