package com.example.webappmvcservlet.services;

import com.example.webappmvcservlet.models.Person;
import com.example.webappmvcservlet.repository.PersonRepository;
import com.example.webappmvcservlet.repository.RepositoryCreator;

import java.util.List;

public class PersonService {
    public List<Person> findAll() throws Exception {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository = repositoryCreator.getPersonRepository();
            return personRepository.findAll();
        } catch (Exception e) {
            throw new Exception();
        }
    }
    public void save(Person person) throws Exception {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository = repositoryCreator.getPersonRepository();
            personRepository.save(person);
        } catch (Exception exception) {
            throw new Exception();
        }
    }
}
