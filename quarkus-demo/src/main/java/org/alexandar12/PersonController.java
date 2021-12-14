package org.alexandar12;

import io.quarkus.panache.common.Sort;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping
    @Transactional
    public void addPerson(Person person) {
        Person.persist(person);
    }

    @GetMapping
    public List<Person> getPeople() {
        return Person.listAll(Sort.by("firstName").ascending());
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") long id) {
        return Person.findById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePerson(@PathVariable("id") long id) {
        Person.delete("id", id);
    }

    @GetMapping("/name/{firstName}")
    public List<Person> getPersonByFirstName(@PathVariable("firstName") String firstName) {
        return Person.getByFirstName(firstName);
    }

    @GetMapping("/name/{firstName}/{lastName}")
    public List<Person> getPersonByFirstAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return Person.getByFirstAndLastNames(firstName, lastName);
    }
}
