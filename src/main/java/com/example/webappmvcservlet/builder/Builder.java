package com.example.webappmvcservlet.builder;

import java.sql.ResultSet;

public interface Builder<T> {
T build(ResultSet resultSet) throws  Exception;
}
