package org.example.Exercicio4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio4_2Test {

    @Test
    void test_constructor() {
        new Exercicio4_2();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider2")
    void should_return_correct_answers(char[][] boardGame, ArrayList<Character> wordToFind, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_2.wordSearchGame(boardGame, wordToFind);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider2() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'C', 'Z', 'T'}, {'C', 'A', 'T'}, {'T', 'G', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                )
        );
    }
}