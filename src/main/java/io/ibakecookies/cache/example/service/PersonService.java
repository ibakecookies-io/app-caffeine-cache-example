package io.ibakecookies.cache.example.service;

import io.ibakecookies.cache.example.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> getPersonList ();

    Person getPerson (String id);

}
