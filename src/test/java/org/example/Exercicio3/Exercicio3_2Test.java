package org.example.Exercicio3;

import org.example.Bloco5.Exercicio3.Exercicio3_2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio3_2Test {

    @Test
    void test_constructor() {
        new Exercicio3_2();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct_answers(int[][] matrixOne, int[][] matrixTwo, int[][] expected) {
        //arrange
        //act
        int[][] result = Exercicio3_2.sumTwoMatrix(matrixOne, matrixTwo);
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, new int[][]{{5, 6}, {7, 8}},
                        new int[][]{{6, 8},{10, 12}}),
                Arguments.of(new int[][]{{0, 2}, {0, 2}}, new int[][]{{0, 2}, {0, 2}},
                        new int[][]{{0, 4},{0, 4}}),
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, new int[][]{{1, 2}, {3, 4}},
                        new int[][]{{2, 4},{6, 8}}),
                Arguments.of(new int[][]{{}, {2, 6}}, new int[][]{{0, 2}, {0, 2}}, new int[][]{{-1}, {-1}}),
                Arguments.of(new int[][]{{1, 2}, {2, 6}}, new int[][]{{}, {0, 2}}, new int[][]{{-1}, {-1}})

        );
    }
}