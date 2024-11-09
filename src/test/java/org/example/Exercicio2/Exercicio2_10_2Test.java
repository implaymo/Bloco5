package org.example.Exercicio2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio2_10_2Test {

    @Test
    void test_constructor() {
        new Exercicio2_10_2();
    }
    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct_answers(int[][] matrix, double[][] expected) {
        //arrange
        //act
        double[][] result = Exercicio2_10_2.invertedMatrix3x3OrMore(matrix);
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{4, 3, 1}, {7, 5, 8}, {2, 6, 9}},
                        new double[][]{{-0.3704, 0.2593, 0.0370}, {0.3333, -0.2222, 0.1111}, {-0.0741, 0.1481, -0.0370}})
                ,
                Arguments.of(new int[][]{{4, 7}, {2, 6, 3}}, new double[][]{{-1}, {-1}}),
                Arguments.of(new int[][]{{4, 8}, {2, 4}}, new double[][]{{-1}, {-1}}),
                Arguments.of(new int[][]{{}, {2, 6}}, new double[][]{{-1.0}, {-1.0}})
        );
    }
}