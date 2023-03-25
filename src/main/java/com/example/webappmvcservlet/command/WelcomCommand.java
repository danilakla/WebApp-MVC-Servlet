package com.example.webappmvcservlet.command;

import com.example.webappmvcservlet.command.infrastructure.Command;
import com.example.webappmvcservlet.command.infrastructure.CommandResult;
import com.example.webappmvcservlet.models.Person;
import com.example.webappmvcservlet.services.PersonService;
import com.example.webappmvcservlet.util.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;

public class WelcomCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        var personServices=new PersonService();
        var data=personServices.findAll();
        if(!data.isEmpty()) {
        request.setAttribute("group", data);
        }else{
            data=new ArrayList<>();
            data.add(new Person("DS","DS","CVXCV"));
            request.setAttribute("group", data);

        }
        return  new CommandResult(Page.WELCOME_PAGE.getPage());
    }
}
