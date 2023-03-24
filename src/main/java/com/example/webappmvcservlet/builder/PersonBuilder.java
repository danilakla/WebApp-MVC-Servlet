package com.example.webappmvcservlet.builder;

import com.example.webappmvcservlet.models.Person;
import com.example.webappmvcservlet.repository.dbconstants.PersonTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonBuilder implements Builder{
    @Override
    public Person build(ResultSet resultSet) throws Exception {
       try {
            int id = resultSet.getInt(PersonTableConstants.ID.getFieldName());
            String name = resultSet.getString(PersonTableConstants.NAME.getFieldName());
            String phone = resultSet.getString(PersonTableConstants.PHONE.getFieldName());
            String email = resultSet.getString(PersonTableConstants.EMAIL.getFieldName());
            return new Person(id, name, phone, email);
        } catch (SQLException exception) {
            throw new Exception();
        }    }
}
