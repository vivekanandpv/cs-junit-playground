package com.example.junitplayground.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MathUtils should")
class MathUtilsTest {
    private MathUtils mathUtils;

    @BeforeAll
    static void setUpTheSuite() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void tearDownTheSuite() {
        System.out.println("AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach");
    }

    @DisplayName("compute the square of any number")
    @ParameterizedTest
    @MethodSource("pairStreamProvider")
    void computeSquareOfANumber(NumberSquarePair pair) {
        double square = mathUtils.square(pair.getNumber());

        //  Assert
        assertEquals(pair.getSquare(), square);
    }

    static List<NumberSquarePair> pairStreamProvider() {
        return List.of(
                new NumberSquarePair(9, 81),
                new NumberSquarePair(-9, 81),
                new NumberSquarePair(4, 16),
                new NumberSquarePair(0, 0)
        );
    }
}

class NumberSquarePair {
    private double number;
    private double square;

    public NumberSquarePair(double number, double square) {
        this.number = number;
        this.square = square;
    }

    public double getNumber() {
        return number;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return "NumberSquarePair{" +
                "number=" + number +
                ", square=" + square +
                '}';
    }
}