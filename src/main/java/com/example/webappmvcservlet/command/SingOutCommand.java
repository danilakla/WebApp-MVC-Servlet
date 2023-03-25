package com.example.webappmvcservlet.command;

import com.example.webappmvcservlet.command.infrastructure.Command;
import com.example.webappmvcservlet.command.infrastructure.CommandResult;
import com.example.webappmvcservlet.util.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SingOutCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("NAME");
        session.removeAttribute("NAME");
        return new CommandResult(Page.LOGIN_PAGE.getPage(),false);
    }
}