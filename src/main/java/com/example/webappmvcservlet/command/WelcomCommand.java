package com.example.webappmvcservlet.command;

import com.example.webappmvcservlet.command.infrastructure.Command;
import com.example.webappmvcservlet.command.infrastructure.CommandResult;
import com.example.webappmvcservlet.command.infrastructure.Page;
import com.example.webappmvcservlet.services.PersonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        var personServices=new PersonService();
        var data=personServices.findAll();
        if(!data.isEmpty()) {
        request.setAttribute("group", data);
        }
        return  new CommandResult(Page.WELCOME.getPage());
    }
}
