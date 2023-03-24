package com.example.webappmvcservlet;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.webappmvcservlet.connectionpool.ConnectionPool;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.print.DocFlavor;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        var connectionPool=ConnectionPool.getInstance();
       var d= connectionPool.getConnection();
       List<Integer> testS=new ArrayList<Integer>();
        try {
            var state=d.createStatement();
            var rsult=state.executeQuery("SELECT  * FROM Persons;");
            while (rsult.next()){
                testS.add(rsult.getInt(4));
            }
            request.setAttribute("test", testS.get(0));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        try {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}