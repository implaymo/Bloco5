package org.example.Exercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio1_2Test {

    @Test
    void test_constructor() {
        new Exercicio1_2();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct_answers(int[][] array, String expected) {
        // arrange
        // act
        String result = Exercicio1_2.exercicio1_2(array);
        // assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 1},{2, 2}, {3, 3}}, "Rectangle"),
                Arguments.of(new int[][]{{1, 1},{2, 2, 2}, {3, 3, 3}}, "Not Rectangle"),
                Arguments.of(new int[][]{{},{}, {}}, "Rectangle"),
                Arguments.arguments(new int[][]{{1, 1},{2, 2}, {3}}, "Not Rectangle")
        );
    }

}