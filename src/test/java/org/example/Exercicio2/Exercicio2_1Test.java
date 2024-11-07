package org.example.Exercicio2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio2_1Test {

    @Test
    void test_constructor() {
        new Exercicio2_2();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct_answers(int[][] array, int expected) {
        //arrange
        //act
        int result = Exercicio2_1.exercicio2_1(array);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 1},{2}, {3, 3}}, 1),
                Arguments.of(new int[][]{{1, 3},{2, 5}, {6, 7}}, 1),
                Arguments.of(new int[][]{{}, {}, {}}, -1),
                Arguments.arguments(new int[][]{{1, 1},{2, 2}, {3}}, 1),
                Arguments.arguments(new int[][]{{1 , },{2, }, {3, }}, 1)

        );
    }

}