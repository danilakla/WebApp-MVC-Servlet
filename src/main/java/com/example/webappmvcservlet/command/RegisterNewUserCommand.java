package com.example.webappmvcservlet.command;

import com.example.webappmvcservlet.command.infrastructure.Command;
import com.example.webappmvcservlet.command.infrastructure.CommandResult;
import com.example.webappmvcservlet.models.User;
import com.example.webappmvcservlet.services.UserService;
import com.example.webappmvcservlet.util.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Optional;

public class RegisterNewUserCommand implements Command {
    private CommandResult forwardToRegisterWithError(HttpServletRequest request, String ERROR, String ERROR_MESSAGE) {
        request.setAttribute(ERROR, ERROR_MESSAGE);
        return new CommandResult(Page.REGISTER_PAGE.getPage(), false);
    }
    private CommandResult forwardToLogin(HttpServletRequest request) {
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Optional<String> login = Optional.of(request.getParameter("login"));
        Optional<String> password = Optional.of(request.getParameter("password"));

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec("password".toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();


        User user = new User(login.get(), hash);
        UserService userService = new UserService();
        int userCount = userService.save(user);
        if (userCount != 0) {
            return forwardToLogin(request);
        } else {
            return forwardToRegisterWithError(request, "REGISTR_ERROR","IS EXIST");
        }
    }
}