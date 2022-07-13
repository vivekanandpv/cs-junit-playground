package com.example.junitplayground.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsShould {

    @Test
    void computeSquareOfANumber() {
        //  AAA: Arrange, Act, Assert
        //  Arrange
        MathUtils utils = new MathUtils();

        //  Act
        double square = utils.square(9);

        //  Assert
        assertEquals(81.0, square);
    }

    @Test
    void computeSquareOfANegativeNumber() {
        MathUtils utils = new MathUtils();

        //  Act
        double square = utils.square(-9);

        //  Assert
        assertEquals(81.0, square);
    }
}