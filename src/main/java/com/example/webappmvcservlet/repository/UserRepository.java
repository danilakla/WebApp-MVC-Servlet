package com.example.webappmvcservlet.repository;

import com.example.webappmvcservlet.builder.UserBuilder;
import com.example.webappmvcservlet.models.User;
import com.example.webappmvcservlet.repository.dbconstants.SQLHelper;
import com.example.webappmvcservlet.repository.dbconstants.UserTableConstants;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepository extends AbstractRepository <User>{
    public UserRepository(Connection connection){
        super(connection);
    }
    @Override
    protected String getTableName() {
        return SQLHelper.USER_TABLE;
    }
    @Override
    public List<User> query(String sqlString, List <Object> paramater) throws Exception {
        List<User> users = executeQuery(sqlString,new UserBuilder(), paramater);
        return users;
    }
    @Override
    public Optional<User> queryForSingleData(String sqlString, List<Object> parameter) throws Exception {
        List<User> user = query(sqlString, parameter);
        return user.size() == 1 ?
                Optional.of(user.get(0)) :
                Optional.empty();
    }


    public Map<String,Object> getFields(User user) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(UserTableConstants.LOGIN.getFieldName(), user.getLogin());
        fields.put(UserTableConstants.PASSW.getFieldName(), user.getPassw());
        return fields;
    }
}