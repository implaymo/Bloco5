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
    @MethodSource("valid_tests_for_every_direction")
    void valid_tests_for_every_direction(char[][] boardGame, ArrayList<Character> wordToFind,int rowBeginWord,
                                         int columnBeginWord, int rowEndWord, int columnEndWord, boolean expected) {
        // arrange

        // act
        boolean result = Exercicio4_3.findWordProvided(boardGame, wordToFind, rowBeginWord, columnBeginWord, rowEndWord, columnEndWord);

        // assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> valid_tests_for_every_direction() {
        return Stream.of(
                Arguments.of((Object) new char[][]
                        {
                                {'a', 'b', 'c'},
                                {'d', 'e', 'f'},
                                {'g', 'h', 'i'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')), 0, 0, 0, 2, true),
                Arguments.of((Object) new char[][]
                        {
                                {'a', 'b', 'c'},
                                {'d', 'e', 'f'},
                                {'g', 'h', 'i'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'd', 'c')), 0, 1, 0, 0, false)
        );
    }
}