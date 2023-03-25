package com.example.webappmvcservlet.command;

import com.example.webappmvcservlet.command.infrastructure.Command;
import com.example.webappmvcservlet.command.infrastructure.CommandResult;
import com.example.webappmvcservlet.models.User;
import com.example.webappmvcservlet.services.UserService;
import com.example.webappmvcservlet.util.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.text.html.Option;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Optional;

public class LoginCommand implements Command {

    private void setAttributesToSession(String name, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("NAME", name);
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        boolean isUserFind = false;
        Optional<String> login =Optional.of(request.getParameter("login"));
        Optional<String> password = Optional.of(request.getParameter("password"));

        //
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.get().toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        //
        isUserFind = initializeUserIfExist(login.get(), hash, request);
            return new CommandResult("/controller?command=welcome", false);

    }

    public boolean initializeUserIfExist(String login, byte[] password, HttpServletRequest request) throws Exception {
        UserService userService = new UserService();
        Optional<User> user = userService.login(login, password);
        boolean userExist = false;
        if (user.isPresent()) {
            setAttributesToSession(user.get().getLogin(), request);
            userExist = true;
        }
        return userExist;
    }
}