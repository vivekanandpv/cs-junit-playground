package com.example.junitplayground.services;

import com.example.junitplayground.models.Person;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    private PersonService service;

    public PersonServiceTest() {
        this.service = new PersonService();
    }

    @AfterEach
    void tearDown() {
        service.getPersonList().clear();
    }

    @Test
    @DisplayName("return a person object for id > 0")
    void getPersonForIdGreaterThanZero() {
        Person person = service.getPerson(123);

        assertEquals(123, person.getId());
    }

    @Test
    @DisplayName("throws RuntimeException for id <= 0")
    void throwsRuntimeExceptionForIdLessThanOrEqualToZero() {
        assertThrows(RuntimeException.class, () -> service.getPerson(0));
    }

    @Test
    @DisplayName("able to add a new person")
    void ableToAddANewPerson() {
        service.addPerson(new Person(12, "Isaac", "Newton"));
        assertEquals(1, service.getPersonList().size());
    }
}