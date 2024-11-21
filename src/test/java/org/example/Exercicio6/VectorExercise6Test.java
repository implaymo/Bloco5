package org.example.Exercicio6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VectorExercise6Test {

    @Test
    void test_constructor() {
        new VectorExercise6();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider0")
    void should_return_array_with_the_add_value(int value, int[] initialArray, int[] expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        int[] result = vectorExercise6.addValue(value);
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider0() {
        return Stream.of(
                Arguments.of(4, new int[]{1,2,3}, new int[]{1, 2, 3, 4}),
                Arguments.of(0, new int[]{1,2,3},new int[]{1, 2, 3, 0}),
                Arguments.of(-1, new int[]{1,2,3}, new int[]{1, 2, 3, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider1")
    void should_return_array_with_first_value_removed(int[] initialArray, int[] expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        int[] result = vectorExercise6.removeFirstValue();
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider1() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, new int[]{2, 3}),
                Arguments.of(new int[]{0,2,3}, new int[]{2, 3}),
                Arguments.of(new int[]{-1,2,3}, new int[]{2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider2")
    void should_return_value_in_array_at_a_determined_index(int[] initialArray, int index, int expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        int result = vectorExercise6.getValue(index);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider2() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, 0, 1),
                Arguments.of(new int[]{0,2,3}, 0, 0),
                Arguments.of(new int[]{-1,2,3}, 2, 3)
        );
    }
}