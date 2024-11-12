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
    @MethodSource("arrayProvider1")
    void should_return_correct_answers_if_Word_Horizontal(char[][] boardGame, ArrayList<Character> wordToFind, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_2.isWordHorizontal(boardGame, wordToFind);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider1() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'X', 'A'}, {'C', 'A'}, {'T', 'G'}},
                        new ArrayList<>(Arrays.asList('C', 'A')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'A', 'C'}, {'C', 'A', 'T'}, {'T', 'G', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider2")
    void should_return_correct_answers_if_Word_Horizontal_Reversed(char[][] boardGame, ArrayList<Character> wordToFind, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_2.isWordHorizontalReversed(boardGame, wordToFind);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider2() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'X', 'A', 'C'}, {'T', 'Z', 'C'}, {'T', 'A', 'C'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'A'}, {'A', 'W'}, {'A', 'C'}},
                        new ArrayList<>(Arrays.asList('C', 'A')),
                        true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider3")
    void should_return_correct_answers_if_Word_Vertical(char[][] boardGame, ArrayList<Character> wordToFind, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_2.isWordVertical(boardGame, wordToFind);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider3() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'C', 'C', 'C'}, {'A', 'A', 'C'}, {'B', 'T', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'C', 'S'}, {'C', 'T'}, {'A', 'G'}},
                        new ArrayList<>(Arrays.asList('C', 'A')),
                        true
                )
        );
    }
}