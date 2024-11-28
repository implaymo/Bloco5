package org.example.Exercicio2;

import org.example.Bloco5.Exercicio2.Exercicio2_3;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio2_3Test {

    @Test
    void test_constructor() {
        new Exercicio2_3();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct_answers(int[][] array, double expected) {
        //arrange
        //act
        double result = Exercicio2_3.averageNumber(array);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 1},{2}, {3, 3}}, 2.0),
                Arguments.of(new int[][]{{1, 3},{2, 5}, {6, 7}}, 4.0),
                Arguments.of(new int[][]{{} ,{}, {}}, -1),
                Arguments.arguments(new int[][]{{1, 1},{}, {3}}, -1),
                Arguments.arguments(new int[][]{{1, },{2, }, {3}}, 2.0),
                Arguments.arguments(new int[][]{{1, 2},{2, 3}, {}}, -1)
                );
    }
}