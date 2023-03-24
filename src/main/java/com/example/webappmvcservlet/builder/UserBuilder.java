package com.example.webappmvcservlet.builder;

import com.example.webappmvcservlet.models.User;
import com.example.webappmvcservlet.repository.dbconstants.UserTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements Builder{
    @Override
    public User build(ResultSet resultSet) throws Exception {
        try {
            int id = resultSet.getInt(UserTableConstants.ID.getFieldName());
            String login = resultSet.getString(UserTableConstants.LOGIN.getFieldName());
            byte[] password = resultSet.getBytes(UserTableConstants.PASSW.getFieldName());
            return new User(id, login, password);
        }
        catch (SQLException exception) {
            throw new Exception();
        }
    }

}
