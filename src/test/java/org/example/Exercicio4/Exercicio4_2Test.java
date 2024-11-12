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
    @MethodSource("arrayProvider0")
    void should_return_correct_answers_if_Word_In_Board_Game(char[][] boardGame, ArrayList<Character> wordToFind, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio4_2.wordSearchGame(boardGame, wordToFind);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider0() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'X', 'X', 'X'}, {'C', 'A', 'T'}, {'X', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'X'}, {'X', 'X', 'X'}, {'T', 'A', 'C'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'C'}, {'X', 'X', 'A'}, {'X', 'X', 'T'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'T', 'X', 'X'}, {'A', 'X', 'X'}, {'C', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'C', 'X', 'X'}, {'X', 'A', 'X'}, {'X', 'X', 'T'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'T'}, {'X', 'A', 'X'}, {'C', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'C'}, {'X', 'A', 'X'}, {'T', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'T', 'X', 'X'}, {'X', 'A', 'X'}, {'T', 'X', 'C'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'C', 'A', 'T'}, {'X', 'X', 'X'}, {'X', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'T', 'A', 'C'}, {'X', 'X', 'X'}, {'X', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'X'}, {'C', 'A', 'T'}, {'X', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'X'}, {'T', 'A', 'C'}, {'X', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'X'}, {'X', 'X', 'X'}, {'C', 'A', 'T'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'X'}, {'X', 'X', 'X'}, {'T', 'A', 'C'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'C', 'X', 'X'}, {'A', 'X', 'X'}, {'T', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'T', 'X', 'X'}, {'A', 'X', 'X'}, {'C', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'C', 'X'}, {'X', 'A', 'X'}, {'X', 'T', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'T', 'X'}, {'X', 'A', 'X'}, {'X', 'C', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'C'}, {'X', 'X', 'A'}, {'X', 'X', 'T'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'T'}, {'X', 'X', 'A'}, {'X', 'X', 'C'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'C', 'X', 'X'}, {'X', 'A', 'X'}, {'X', 'X', 'T'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'T', 'X', 'X'}, {'X', 'A', 'X'}, {'X', 'X', 'C'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'C'}, {'X', 'A', 'X'}, {'T', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'X', 'X', 'T'}, {'X', 'A', 'X'}, {'C', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        true
                ),
                Arguments.of(
                        new char[][]{{'C', 'X', 'X'}, {'X', 'A', 'X'}, {'T', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        false
                ),
                Arguments.of(
                        new char[][]{{'T', 'X', 'X'}, {'X', 'A', 'X'}, {'C', 'X', 'X'}},
                        new ArrayList<>(Arrays.asList('C', 'A', 'T')),
                        false
                )
        );
    }
}