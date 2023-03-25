package com.example.webappmvcservlet.repository;

import com.example.webappmvcservlet.builder.PersonBuilder;
import com.example.webappmvcservlet.models.Person;
import com.example.webappmvcservlet.repository.AbstractRepository;
import com.example.webappmvcservlet.repository.dbconstants.PersonTableConstants;
import com.example.webappmvcservlet.repository.dbconstants.SQLHelper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonRepository extends AbstractRepository<Person> {
    public PersonRepository(Connection connection){
        super(connection);
    }
    @Override
    protected String getTableName() {
        return SQLHelper.PERSON_TABLE ;
    }
    @Override
    public List<Person> query(String sqlString, List<Object> paramater) throws Exception {
        List<Person> persons = executeQuery(sqlString,new PersonBuilder(), paramater);
        return persons;
    }
    @Override
    public Optional<Person> queryForSingleData(String sqlString, List<Object> parameter) throws Exception {
        List<Person> person = query(sqlString, parameter);
        return person.size() == 1 ?
                Optional.of(person.get(0)) :
                Optional.empty();
    }


    public Map<String,Object> getFields(Person person) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(PersonTableConstants.NAME.getFieldName(), person.getName());
        fields.put(PersonTableConstants.PHONE.getFieldName(), person.getPhone());
        fields.put(PersonTableConstants.EMAIL.getFieldName(), person.getEmail());
        return fields;
    }
}