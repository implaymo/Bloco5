package org.example.Exercicio3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio3_3Test {

    @Test
    void test_constructor() {
        new Exercicio3_3();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct_answers(int[][] matrixOne, int[][] matrixTwo, int[][] expected) {
        //arrange
        //act
        int[][] result = Exercicio3_3.productOfTwoMatrix(matrixOne, matrixTwo);
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, new int[][]{{5, 6}, {7, 8}},
                        new int[][]{{19, 22},{43,50}}),
                Arguments.of(new int[][]{{-1, 2}, {3, -4}}, new int[][]{{5, -6}, {-7, 8}},
                        new int[][]{{-19, 22}, {43, -50}}),
                Arguments.of(new int[][]{{2}, {-1}, {3}},
                        new int[][]{{4, -5, 6}},
                        new int[][]{{8, -10, 12}, {-4, 5, -6}, {12, -15, 18}}),
                Arguments.of(
                        new int[][]{ {1, 2, 3}, {4, 5, 6}, {7, 8, 9} },  // Matrix A
                        new int[][]{ {9, 8, 7}, {6, 5, 4}, {3, 2, 1} },  // Matrix B
                        new int[][]{ {30, 24, 18}, {84, 69, 54}, {138, 114, 90} }  // Expected Result
                ),
                Arguments.of(new int[][]{{}, {2, 6}}, new int[][]{{0, 2}, {0, 2}}, new int[][]{{-1}, {-1}})
        );
    }
}