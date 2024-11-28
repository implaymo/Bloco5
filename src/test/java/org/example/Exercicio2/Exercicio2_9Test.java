package org.example.Exercicio2;

import org.example.Bloco5.Exercicio2.Exercicio2_9;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio2_9Test {

    @Test
    void isIdentityMatrix() {
        new Exercicio2_9();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void should_return_correct_answers(int[][] array, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio2_9.isIdentityMatrix(array);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 0}, {0, 1}}, true),
                Arguments.of(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, true),
                Arguments.of(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 0}}, false),
                Arguments.of(new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}, true),
                Arguments.of(new int[][]{{1, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}, {0, 1, 0, 1}}, false),
                Arguments.of(new int[][]{{}, {}, {}}, false),
                Arguments.of(new int[][]{{1, 1}, {}, {3}}, false),
                Arguments.of(new int[][]{{1}, {0}, {3}}, false),
                Arguments.of(new int[][]{{1, 2}, {2, 3}, {}}, false)
        );
    }
}