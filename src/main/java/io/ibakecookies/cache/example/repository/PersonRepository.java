package io.ibakecookies.cache.example.repository;

import java.util.List;

public interface PersonRepository {

    List<PersonEntity> getPersons ();

    PersonEntity getPerson (String id);

}
