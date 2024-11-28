package org.example.Exercicio4;

import org.example.Bloco5.Exercicio4.Exercicio4_1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio4_1Test {

    @Test
    void test_constructor() {
        new Exercicio4_1();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider1")
    void should_return_correct_answers_4_1(char[][] boardGame, char letterToFind, int[][] expected) {
        //arrange
        //act
        int[][] result = Exercicio4_1.createMaskGrid(boardGame, letterToFind);
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider1() {
        return Stream.of(
                Arguments.of(new char[][]{{'A', 'B', 'X'}, {'X', 'D', 'E'}, {'F', 'G', 'X'}}, 'X',
                        new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 1}}
                )
        );
    }
}