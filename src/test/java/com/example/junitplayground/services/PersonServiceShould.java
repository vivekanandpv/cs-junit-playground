package com.example.junitplayground.services;

import com.example.junitplayground.models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceShould {
    private PersonService service;

    @BeforeEach
    void setUp() {
        service = new PersonService();
    }

    @Test
    @DisplayName("return a person object for id > 0")
    void getPersonForIdGreaterThanZero() {
        Person person = service.getPerson(123);

        assertEquals(123, person.getId());

        //  Also possible
//        assertEquals(123, person.getId(), "We did not get the correct id");
//        assertEquals(123, person.getId(), () -> "We did not get the correct id");
    }

    @Test
    @DisplayName("throws RuntimeException for id <= 0")
    void throwsRuntimeExceptionForIdLessThanOrEqualToZero() {
//        assertAll(
//                () -> assertThrows(RuntimeException.class, () -> service.getPerson(0)),
//                () -> assertThrows(RuntimeException.class, () -> service.getPerson(-12)),
//                () -> assertThrows(RuntimeException.class, () -> service.getPerson(-234))
//        );

        assertThrows(RuntimeException.class, () -> service.getPerson(0));
    }
}