package io.ibakecookies.cache.example.controller;

import io.ibakecookies.cache.example.model.Person;
import io.ibakecookies.cache.example.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> persons (){
        return ResponseEntity.ok(personService.getPersonList());
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> person (@PathVariable String id ){
        return ResponseEntity.ok(personService.getPerson(id));
    }

}
