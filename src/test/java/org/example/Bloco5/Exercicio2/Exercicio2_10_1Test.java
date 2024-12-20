package org.example.Bloco5.Exercicio2;

import org.example.Bloco5.Exercicio2.Exercicio2_10_1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio2_10_1Test {

    @Test
    void test_constructor() {
        new Exercicio2_10_1();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct_answers(int[][] matrix, double[][] expected) {
        //arrange
        //act
        double[][] result = Exercicio2_10_1.invertedMatrix2By2(matrix);
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{4, 7}, {2, 6}}, new double[][]{{0.6, -0.7}, {-0.2, 0.4}}),
                Arguments.of(new int[][]{{4, 7}, {2, 6, 3}}, new double[][]{{-1}, {-1}}),
                Arguments.of(new int[][]{{4, 8}, {2, 4}}, new double[][]{{-1}, {-1}}),
                Arguments.of(new int[][]{{}, {2, 6}}, new double[][]{{-1.0}, {-1.0}})
        );
    }
}