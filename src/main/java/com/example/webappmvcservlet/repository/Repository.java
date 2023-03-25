package com.example.webappmvcservlet.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> query(String sqlString, List<Object> parametrs) throws  Exception;
Optional <T> queryForSingleData(String sqlString, List<Object> parametrs) throws  Exception;
List<T> findAll() throws  Exception;
Integer save(T object) throws  Exception;
}
