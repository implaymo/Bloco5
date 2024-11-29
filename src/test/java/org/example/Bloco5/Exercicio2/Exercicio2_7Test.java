package org.example.Bloco5.Exercicio2;

import org.example.Bloco5.Exercicio2.Exercicio2_7;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio2_7Test {

    @Test
    void test_constructor() {
        new Exercicio2_7();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct_answers(int[][] array, int[] expected) {
        //arrange
        //act
        int[] result = Exercicio2_7.principalMatrixDiagonal(array);
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 1}, {2,2}}, new int[]{1, 2}),
                 Arguments.of(new int[][]{{1, 2, 3}, {3, 4, 5}, {6, 7, 8}}, new int[]{1, 4, 8}),
                Arguments.of(new int[][]{{1, 2}, {2,3}, {3,4,5}}, new int[]{-1}),
                Arguments.of(new int[][]{{}, {}, {}}, new int[]{-1}),
                Arguments.of(new int[][]{{1, 1}, {}, {3}}, new int[]{-1}),
                Arguments.of(new int[][]{{1}, {0}, {3}}, new int[]{-1}),
                Arguments.of(new int[][]{{1, 2}, {2, 3}, {}}, new int[]{-1})
        );
    }


}