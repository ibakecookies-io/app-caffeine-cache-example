package io.ibakecookies.cache.example.service;

import io.ibakecookies.cache.example.model.Person;
import io.ibakecookies.cache.example.repository.PersonRepository;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final CacheManager cacheManager;


    @Override
    public List<Person> getPersonList() {
        Cache cache = cacheManager.getCache("persons_cache"); // Получаем кэш, с name  "persons_cache"
        assert cache != null;
        return Optional.ofNullable(cache.get("personList", (Class<List<Person>>)(Class<?>)List.class))
                .orElseGet(() -> { // Если в кэше для ключа "personList" нет значения, то выполнить обращение в репозиторий
                    var result = personRepository.getPersons()
                            .stream()
                            .map(e -> new Person(e.getId(), e.getName(),e.getFirstName(), e.getLastName()))
                            .toList();
                    cache.put("personList", result); //Сохраняем в кэш полученный из репозитория результат
                    return result;
                }
        );
    }

    @Override
    public Person getPerson(String id) {
        Cache cache = cacheManager.getCache("person_cache"); // Получаем кэш, с name  "person_cache"
        assert cache != null;
        return Optional.ofNullable(cache.get(id, Person.class))
                .orElseGet(() -> { // Если в кэше для ключа "id" нет значения, то выполнить обращение в репозиторий
                    var personExt = personRepository.getPerson(id);
                    var result = new Person(personExt.getId(), personExt.getName(), personExt.getFirstName(), personExt.getLastName());
                    cache.put(id,result); //Сохраняем в кэш полученный из репозитория результат
                    return result;
                });
    }

}
