package com.example.junitplayground.services;

import com.example.junitplayground.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private List<Person> personList = new ArrayList<>();
    public Person getPerson(long id) {
        if (id > 0) {
            return new Person(id, "Default", "Default");
        }

        throw new RuntimeException("Invalid id");
    }

    public void addPerson(Person person) {
        //...
        personList.add(person);
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
