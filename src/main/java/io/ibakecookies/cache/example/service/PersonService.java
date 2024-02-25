package io.ibakecookies.cache.example.service;

import io.ibakecookies.cache.example.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPersonList ();

    Person getPerson (String id);

}
