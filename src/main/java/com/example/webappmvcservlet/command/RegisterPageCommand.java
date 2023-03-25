package com.example.webappmvcservlet.command;

import com.example.webappmvcservlet.command.infrastructure.Command;
import com.example.webappmvcservlet.command.infrastructure.CommandResult;
import com.example.webappmvcservlet.util.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse
            response) throws Exception{
        System.out.println("REGISTER_PAGE");
        return new CommandResult(Page.REGISTER_PAGE.getPage(), false);
    }
}
