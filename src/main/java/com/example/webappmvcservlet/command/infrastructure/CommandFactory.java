package com.example.webappmvcservlet.command.infrastructure;

import com.example.webappmvcservlet.command.*;

public class CommandFactory {

    public static Command create(String command) {
        command = command.toUpperCase();
        System.out.println(command);
        Command resultCommand;
        switch (command) {
            case "login": {
                resultCommand = new LoginCommand(); break;
            }
            case "new_user": {
                resultCommand = new RegisterNewUserCommand(); break;
            }
            case "sing_out": {
                resultCommand = new SingOutCommand(); break;
            }
            case "add_new_user":{
                resultCommand = new AddNewPersonCommand(); break;
            }
            case "login_page":{
                resultCommand = new LoginPageCommand(); break;
            }
            case "main_paeg":{
                resultCommand = new WelcomCommand(); break;
            }
            case "registration_page":{
                resultCommand = new RegisterPageCommand(); break;
            }
            default: {
                throw new IllegalArgumentException("Invalid command" + command);
            }
        }
        return resultCommand;
    }
}
