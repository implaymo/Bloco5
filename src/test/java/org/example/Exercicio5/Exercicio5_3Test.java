package org.example.Exercicio5;

import org.example.Exercicio3.Exercicio3_1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio5_3Test {

    @Test
    void test_constructor() {
        new Exercicio5_3();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider1")
    void should_return_mask_matrix(int[][] boardGame, int[][] expected) {
        //arrange
        //act
        int[][] result = Exercicio5_3.sudoku(boardGame);
        //assert
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> arrayProvider1() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 7, 0, 0, 0, 0, 0, 0, 5},
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 4, 0, 0},
                                {0, 0, 6, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 9, 0, 0, 0, 0, 0},
                                {0, 6, 0, 0, 0, 0, 0, 0, 4},
                                {2, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 5, 0, 0, 0, 0, 0, 0}
                        }, new int[][]{
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 1, 0, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                                {0, 0, 1, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                                {0, 1, 0, 0, 0, 0, 0, 0, 1},
                                {1, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 1, 0, 0, 0, 0, 0, 0}
                        }
                )
        );
    }
}