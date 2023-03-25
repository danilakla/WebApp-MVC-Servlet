package com.example.webappmvcservlet.command;

import com.example.webappmvcservlet.command.infrastructure.Command;
import com.example.webappmvcservlet.command.infrastructure.CommandResult;
import com.example.webappmvcservlet.command.infrastructure.Page;
import com.example.webappmvcservlet.models.Person;
import com.example.webappmvcservlet.services.PersonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Optional;


public class AddNewPersonCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        PersonService personService = new PersonService();
        Optional<String> newName = Optional.ofNullable(request.getParameter("name"));
        Optional<String> newPhone = request.getParameter("password").describeConstable();
        Optional<String> newEmail= request.getParameter("email").describeConstable();

            Person newperson = new Person(newName.get(), newPhone.get(), newEmail.get());
            personService.save(newperson);

        List<Person> clients = personService.findAll();
            request.setAttribute("group", clients);
        return new CommandResult(Page.WELCOME.getPage(), false);
    }
}
