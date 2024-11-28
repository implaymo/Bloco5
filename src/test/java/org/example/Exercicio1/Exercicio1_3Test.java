package org.example.Exercicio1;

import org.example.Bloco5.Exercicio1.Exercicio1_3;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio1_3Test {

    @Test
    void test_constructor() {
        new Exercicio1_3();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct_answers(int[][] array, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio1_3.isMatrixNotSquareOrRect(array);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 1},{2}, {3, 3}}, true),
                Arguments.of(new int[][]{{1, 1},{2, 2}, {3, 3}}, false),
                Arguments.of(new int[][]{{},{}, {}}, false),
                Arguments.arguments(new int[][]{{1, 1},{2, 2}, {3}}, true)
        );
    }
}