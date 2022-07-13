package com.example.junitplayground.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MathUtils should")
class MathUtilsTest {

    @DisplayName("compute the square of any number")
    @ParameterizedTest
    @MethodSource("pairStreamProvider")
    void computeSquareOfANumber(NumberSquarePair pair) {
        //  AAA: Arrange, Act, Assert
        //  Arrange
        MathUtils utils = new MathUtils();

        //  Act
        double square = utils.square(pair.getNumber());

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