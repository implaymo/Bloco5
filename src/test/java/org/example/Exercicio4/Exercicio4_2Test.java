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
                        new char[][]{{'X', 'X'}, {'C', 'A'}, {'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'X'}, {'C', 'A', 'T'}, {'X', 'X', 'X'}},
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
                        new char[][]{{'X', 'X', 'X'}, {'X', 'X', 'X'}, {'T', 'A', 'C'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X'}, {'X', 'X'}, {'A', 'C'}},
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
                        new char[][]{{'X', 'X', 'C'}, {'X', 'X', 'A'}, {'X', 'X', 'T'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X'}, {'C', 'X'}, {'A', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A')),
                        true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider4")
    void should_return_correct_answers_if_Word_Vertical_Reversed(char[][] boardGame, ArrayList<Character> wordToFind, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_2.isWordVerticalReversed(boardGame, wordToFind);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider4() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'T', 'X', 'X'}, {'A', 'X', 'X'}, {'C', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X'}, {'X', 'A'}, {'X', 'C'}},
                        new ArrayList<>(Arrays.asList('C', 'A')),
                        true
                )
        );

    }
    @ParameterizedTest
    @MethodSource("arrayProvider5")
    void should_return_correct_answers_if_Word_Diagonal(char[][] boardGame, ArrayList<Character> wordToFind, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_2.isWordDiagonal(boardGame, wordToFind);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider5() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'C', 'X', 'X'}, {'X', 'A', 'X'}, {'X', 'X', 'T'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'C', 'X'}, {'X', 'A'}, {'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A')),
                        true
                )
        );
    }
}