package com.example.webappmvcservlet;

import java.io.*;
import java.nio.file.attribute.UserPrincipal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.webappmvcservlet.connectionpool.ConnectionPool;
import com.example.webappmvcservlet.models.Person;
import com.example.webappmvcservlet.models.User;
import com.example.webappmvcservlet.services.PersonService;
import com.example.webappmvcservlet.services.UserService;
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


        response.setContentType("text/html");
        var v= new Person();
        v.setEmail("email");
        v.setName("danila");
        v.setPhone("+3213213213");
        var vu= new User("login danula","logind sa".getBytes());


        try {
  var data2=new UserService().login(vu.getLogin(),vu.getPassw());
//request.setAttribute("LISTdat",data);
            request.setAttribute("dtalogin",data2);
            request.setAttribute("test",data2);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
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