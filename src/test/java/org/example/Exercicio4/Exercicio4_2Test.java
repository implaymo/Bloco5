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
                )
        );

    }
    @ParameterizedTest
    @MethodSource("arrayProvider5")
    void should_return_correct_answers_if_Word_Diagonal_Top_Left(char[][] boardGame, ArrayList<Character> wordToFind, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_2.isWordDiagonalTopLeft(boardGame, wordToFind);
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
                        new char[][]{{'X', 'X', 'X'}, {'C', 'X', 'X'}, {'X', 'A', 'X'}, {'X', 'X', 'T'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider6")
    void should_return_correct_answers_if_Word_Diagonal_Bottom_Left(char[][] boardGame, ArrayList<Character> wordToFind, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_2.isWordDiagonalBottomLeft(boardGame, wordToFind);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider6() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'X', 'X', 'T'}, {'X', 'A', 'X'}, {'C', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                )
//                Arguments.of(
//                        new char[][]{{'X', 'X', 'X'}, {'C', 'X', 'X'}, {'X', 'A', 'X'}, {'X', 'X', 'T'}},
//                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
//                        true
//                )
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider7")
    void should_return_correct_answers_if_Word_Diagonal_Top_Right(char[][] boardGame, ArrayList<Character> wordToFind, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_2.isWordDiagonalTopRight(boardGame, wordToFind);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider7() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'X', 'X', 'C'}, {'X', 'A', 'X'}, {'T', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider8")
    void should_return_correct_answers_if_Word_Diagonal_Bottom_Right(char[][] boardGame, ArrayList<Character> wordToFind, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_2.isWordDiagonalBottomRight(boardGame, wordToFind);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider8() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'T', 'X', 'X'}, {'X', 'A', 'X'}, {'T', 'X', 'C'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                )
        );
    }
}