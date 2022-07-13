package com.example.junitplayground.services;

import com.example.junitplayground.models.Person;

public class PersonService {
    public Person getPerson(long id) {
        if (id > 0) {
            return new Person(id, "Default", "Default");
        }

        throw new RuntimeException("Invalid id");
    }
}
