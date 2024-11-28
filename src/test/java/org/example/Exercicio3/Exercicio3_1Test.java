package org.example.Exercicio3;

import org.example.Bloco5.Exercicio3.Exercicio3_1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio3_1Test {

    @Test
    void test_constructor() {
        new Exercicio3_1();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct_answers(int[][] matrix, int constant, int[][] expected) {
        //arrange
        //act
        int[][] result = Exercicio3_1.matrixProductByConstant(matrix, constant);
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {1, 2}}, 1,
                        new int[][]{{1, 2},{1,2}}),
                Arguments.of(new int[][]{{0, 2}, {0, 2}}, 1,
                        new int[][]{{0, 2},{0,2}}),
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, 3,
                        new int[][]{{3, 6},{9, 12}}),
                Arguments.of(new int[][]{{}, {2, 6}}, 1, new int[][]{{-1}, {-1}})
        );
    }
}