package org.example.Exercicio4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio4_4Test {

    @Test
    void test_constructor() {
        new Exercicio4_4();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct(char[][] boardGame, ArrayList<Character> wordOne, ArrayList<Character> wordTwo, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_4.findWordProvided(boardGame, wordOne, wordTwo);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'C', 'X', 'X'}, {'S', 'A', 'N'}, {'X', 'X', 'T'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        new ArrayList<>(Arrays.asList('S', 'A', 'N')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'C', 'X', 'X'}, {'X', 'A', 'X'}, {'N', 'O', 'T'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        new ArrayList<>(Arrays.asList('N', 'O', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'C', 'A', 'T'}, {'S', 'A', 'N'}, {'X', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        new ArrayList<>(Arrays.asList('S', 'A', 'N')),
                        false
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'X'}, {'X', 'X', 'X'}, {'X', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        new ArrayList<>(Arrays.asList('S', 'A', 'N')),
                        false
                )
        );
    }
}