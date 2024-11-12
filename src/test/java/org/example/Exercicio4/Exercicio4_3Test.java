package org.example.Exercicio4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio4_3Test {

    @Test
    void test_constructor() {
        new Exercicio4_3();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct(char[][] boardGame, ArrayList<Character> wordToFind, int rowFirstChar,
                               int columnFirstChar, int rowLastChar,
                               int columnLastChar , boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_3.findWordProvided(boardGame, wordToFind,
                rowFirstChar,columnFirstChar, rowLastChar, columnLastChar);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'C', 'X', 'X'}, {'X', 'A', 'X'}, {'X', 'X', 'T'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        0, 0, 2, 2,
                        true
                )
        );
    }
}