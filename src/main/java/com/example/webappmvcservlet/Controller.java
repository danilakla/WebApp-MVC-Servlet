package com.example.webappmvcservlet;

import com.example.webappmvcservlet.command.infrastructure.Command;
import com.example.webappmvcservlet.command.infrastructure.CommandFactory;
import com.example.webappmvcservlet.command.infrastructure.CommandResult;
import com.example.webappmvcservlet.connectionpool.ConnectionPool;
import com.google.protobuf.ServiceException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Controller extends HttpServlet {
    private static final String COMMAND = "command";
    private static final String ERROR_MESSAGE = "error_message";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response); }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response); }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String command = request.getParameter(COMMAND);
        Command action = CommandFactory.create(command);
        CommandResult commandResult;
        try {
            commandResult = action.execute(request, response);
        } catch (Exception e) {
            request.setAttribute(ERROR_MESSAGE, e.getMessage());
            commandResult = new CommandResult("Error_pages", false);
        }
        String page = commandResult.getPage();
        if (commandResult.isRedirect()) {
            sendRedirect(response, page);
        } else {
            try {
                dispatch(request, response, page);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void sendRedirect(HttpServletResponse response, String page) {
        try {
            response.sendRedirect(page);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}