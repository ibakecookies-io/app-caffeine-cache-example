package io.ibakecookies.cache.example.repository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonRepositoryImpl implements PersonRepository {

    private final List<PersonEntity> repository = List.of(
            new PersonEntity("123456", "Василий", "Петров", "Петрович"),
            new PersonEntity("321233", "Петр", "Иванов", "Петрович"),
            new PersonEntity("123112", "Павел", "Грибоедов", "Алексеевич")
    );
    @Override
    public List<PersonEntity> getPersons() {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e){
        e.fillInStackTrace();
    }
    return this.repository;
    }

    @Override
    public PersonEntity getPerson(String id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.fillInStackTrace();
        }
        return repository.stream().filter(e ->
                e.getId().equals(id))
                .findAny()
                .orElse(new PersonEntity());
    }
}
