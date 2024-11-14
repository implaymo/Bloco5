package org.example.Exercicio5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio5_Test {

    @Test
    void test_constructor() {
        new Exercicio5();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct(int[][] boardGame, int[][] updatedBoardGame, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio5.sudoku(boardGame, updatedBoardGame);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
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
                        },new int[][]{
                                {0, 0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 7, 1, 0, 0, 0, 0, 0, 5},
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 2, 0, 0, 0, 4, 0, 0},
                                {0, 0, 6, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 9, 0, 0, 0, 0, 0},
                                {0, 6, 0, 0, 0, 0, 0, 0, 4},
                                {2, 0, 3, 0, 1, 0, 0, 0, 0},
                                {0, 0, 5, 0, 0, 0, 0, 0, 0}
                        }
                        ,
                        true
                )
        );
    }
}