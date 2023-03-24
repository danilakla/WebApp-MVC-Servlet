package com.example.webappmvcservlet.services;

import com.example.webappmvcservlet.models.User;
import com.example.webappmvcservlet.repository.RepositoryCreator;
import com.example.webappmvcservlet.repository.UserRepository;
import com.example.webappmvcservlet.repository.dbconstants.SQLHelper;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserService {
    public Optional<User> login(String login, byte[] password) throws Exception {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            List<Object> params = new ArrayList<Object>();

            params.add(login) ;
            params.add(password);
            return userRepository.queryForSingleData(SQLHelper.SQL_GET_USER, params);
        } catch (Exception e) {
            throw new Exception();
        }
    }
    public Integer save(User user) throws Exception {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            List<Object> param = new ArrayList<Object>();
param.add(user.getLogin());
            if (!userRepository.queryForSingleData(SQLHelper.SQL_CHECK_LOGIN, param).isPresent()) {
                return userRepository.save(user);
            } else {
                return 0;
            }
        } catch (Exception exception) {
            throw new Exception();
        }
    }


}