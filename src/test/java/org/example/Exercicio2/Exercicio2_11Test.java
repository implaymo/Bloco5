package org.example.Exercicio2;

import org.example.Bloco5.Exercicio2.Exercicio2_11;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio2_11Test {

    @Test
    void test_constructor() {
        new Exercicio2_11();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct_answers(int[][] matrix, int[][] expected) {
        //arrange
        //act
        int[][] result = Exercicio2_11.transposeMatrix(matrix);
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                        new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 16}}),
                Arguments.of(new int[][]{{2, 4, 6, 8}, {1, 3, 5, 7}, {9, 11, 13, 15}, {10, 12, 14, 16}},
                        new int[][]{{2, 1, 9, 10}, {4, 3, 11, 12}, {6, 5, 13, 14}, {8, 7, 15, 16}}),
                Arguments.of(new int[][]{{}, {2, 6}}, new int[][]{{-1}, {-1}})
        );
    }
}