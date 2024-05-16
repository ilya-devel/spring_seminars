package ru.gb.homework.sem10_homework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.gb.homework.sem10_homework.models.Person;
import ru.gb.homework.sem10_homework.service.PersonService;
/**
 * Controller for microservice of Person data
 */
@RestController
@RequestMapping("/")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity<Iterable<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person;
        try {
            person = personService.getPersonById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        try {
            Person newPerson = personService.addPerson(person);
            return new ResponseEntity<>(newPerson, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
        Person person;
        try {
            person = personService.deletePerson(id);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(
        @PathVariable Long id,
        @RequestBody Person updPerson
    ) {
        try {
            Person person = personService.updatePerson(id, updPerson);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
