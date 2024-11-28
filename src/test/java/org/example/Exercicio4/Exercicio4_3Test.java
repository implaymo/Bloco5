package org.example.Exercicio4;

import org.example.Bloco5.Exercicio4.Exercicio4_3;
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
    void valid_tests_for_every_direction(char[][] boardGame, ArrayList<Character> wordToFind,int beginRow,
                                         int beginColumn, int endRow, int endColumn, boolean expected) {
        // arrange

        // act
        boolean result = Exercicio4_3.findWordProvided(boardGame, wordToFind, beginRow, beginColumn, endRow, endColumn);

        // assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> valid_tests_for_every_direction() {
        return Stream.of(
                Arguments.of((Object) new char[][]
                        {
                                {'a', 'b', 'c'},
                                {'x', 'x', 'x'},
                                {'x', 'x', 'x'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')), 0, 0, 0, 2, true),
                Arguments.of((Object) new char[][]
                        {
                                {'x', 'x', 'x'},
                                {'a', 'b', 'c'},
                                {'x', 'x', 'x'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')), 2, 0, 2, 2, false),
                Arguments.of((Object) new char[][]
                        {
                                {'x', 'x', 'x'},
                                {'c', 'b', 'a'},
                                {'x', 'x', 'x'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')), 1, 2, 1, 0, true),
                Arguments.of((Object) new char[][]
                        {
                                {'x', 'x', 'x'},
                                {'a', 'b', 'c'},
                                {'x', 'x', 'x'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')), 1, 2, 1, 0, false),
                Arguments.of((Object) new char[][]
                        {
                                {'a', 'x', 'x'},
                                {'b', 'x', 'x'},
                                {'c', 'x', 'x'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')), 0, 0, 2, 0, true),
                Arguments.of((Object) new char[][]
                        {
                                {'a', 'x', 'x'},
                                {'b', 'x', 'x'},
                                {'c', 'x', 'x'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')),1, 1, 2, 1,false),
                Arguments.of((Object) new char[][]
                        {
                                {'c', 'x', 'x'},
                                {'b', 'x', 'x'},
                                {'a', 'x', 'x'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')),2, 0, 0, 0, true),
                Arguments.of((Object) new char[][]
                        {
                                {'c', 'x', 'x'},
                                {'b', 'x', 'x'},
                                {'a', 'x', 'x'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')),2, 1, 0, 1, false),
                Arguments.of((Object) new char[][]
                        {
                                {'a', 'x', 'x'},
                                {'x', 'b', 'x'},
                                {'x', 'x', 'c'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')),0, 0, 2, 2, true),
                Arguments.of((Object) new char[][]
                        {
                                {'a', 'x', 'x'},
                                {'x', 'b', 'x'},
                                {'x', 'x', 'c'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')),0, 1, 1, 2, false),
                Arguments.of((Object) new char[][]
                        {
                                {'c', 'x', 'x'},
                                {'x', 'b', 'x'},
                                {'x', 'x', 'a'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')),2, 2, 0, 0, true),
                Arguments.of((Object) new char[][]
                        {
                                {'c', 'x', 'x'},
                                {'x', 'b', 'x'},
                                {'x', 'x', 'a'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')),2, 1, 1, 0, false),
                Arguments.of((Object) new char[][]
                        {
                                {'x', 'x', 'a'},
                                {'x', 'b', 'x'},
                                {'c', 'x', 'x'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')),0, 2, 2, 0, true),
                Arguments.of((Object) new char[][]
                        {
                                {'x', 'x', 'a'},
                                {'x', 'b', 'x'},
                                {'c', 'x', 'x'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')),0, 1, 1, 0, false),
                Arguments.of((Object) new char[][]
                        {
                                {'x', 'x', 'c'},
                                {'x', 'b', 'x'},
                                {'a', 'x', 'x'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')),2, 0, 0, 2, true),
                Arguments.of((Object) new char[][]
                        {
                                {'x', 'x', 'c'},
                                {'x', 'b', 'x'},
                                {'a', 'x', 'x'}
                        }, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')),2, 1, 0, 1, false)


        );
    }
}