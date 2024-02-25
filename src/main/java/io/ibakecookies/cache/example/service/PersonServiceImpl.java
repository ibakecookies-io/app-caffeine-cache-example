package io.ibakecookies.cache.example.service;

import io.ibakecookies.cache.example.model.Person;
import io.ibakecookies.cache.example.repository.PersonRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;


    @Cacheable(cacheNames = "persons_cache")
    @Override
    public List<Person> getPersonList() {
        return personRepository.getPersons()
                .stream()
                .map(e -> new Person(e.getId(), e.getName(),e.getFirstName(), e.getLastName()))
                .toList();
    }

    @Override
    @Cacheable(cacheNames = "person_cache", key = "#id")
    public Person getPerson(String id) {
        var personExt = personRepository.getPerson(id);
        return new Person(personExt.getId(), personExt.getName(), personExt.getFirstName(), personExt.getLastName());
    }

}
