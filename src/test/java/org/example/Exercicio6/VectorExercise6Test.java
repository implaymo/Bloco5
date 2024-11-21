package org.example.Exercicio6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class VectorExercise6Test {

    @Test
    void test_constructor1() {
        new VectorExercise6();
    }

    @Test
    void test_constructor2() {
        // arrange
        int[] array = new int[]{1, 2};
        new VectorExercise6(array);
    }

    @ParameterizedTest
    @MethodSource("arrayProvider0")
    void should_return_array_with_the_add_value(int value, int[] initialArray) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        boolean result = vectorExercise6.addValue(value);
        //assert
        assertTrue(result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider0() {
        return Stream.of(
                Arguments.of(4, new int[]{1,2,3}),
                Arguments.of(4, new int[]{}),
                Arguments.of(0, new int[]{1,2,3}),
                Arguments.of(-1, new int[]{1,2,3})
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider1")
    void should_return_array_with_first_value_removed(int[] initialArray) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        boolean result = vectorExercise6.removeFirstValue();
        //assert
        assertTrue(result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider1() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}),
                Arguments.of(new int[]{0,2,3}),
                Arguments.of(new int[]{-1,2,3})
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
                Arguments.of(new int[]{-1,2,3}, 2, 3),
                Arguments.of(new int[]{}, 2, -1),
                Arguments.of(null, 2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider3")
    void should_return_total_elements_array(int[] initialArray, int expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        int result = vectorExercise6.getTotalElements();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider3() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, 3),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 5)
        );
    }


    @ParameterizedTest
    @MethodSource("arrayProvider4")
    void should_return_highest_value_in_array(int[] initialArray, int expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        int result = vectorExercise6.getHighestNumber();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider4() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, 3),
                Arguments.of(new int[]{-1,-2,-3}, -1),
                Arguments.of(new int[]{}, -1),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider5")
    void should_return_lowest_value_in_array(int[] initialArray, int expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        int result = vectorExercise6.getLowestNumber();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider5() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, 1),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5}, 0),
                Arguments.of(new int[]{0, -1, 2, 3, 4, 5}, -1)

        );
    }


    @ParameterizedTest
    @MethodSource("arrayProvider6")
    void should_return_average_of_elements_in_array(int[] initialArray, double expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        double result = vectorExercise6.getAverage();
        //assert
        assertEquals(expected, result, 0.01);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider6() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, 2),
                Arguments.of(new int[]{-1,2,3}, 1.33),
                Arguments.of(new int[]{}, -1),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5}, 2.5)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider7")
    void should_return_average_of_even_number_elements_in_array(int[] initialArray, double expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        double result = vectorExercise6.getAverageEvenNumbers();
        //assert
        assertEquals(expected, result, 0.01);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider7() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 3.0),
                Arguments.of(new int[]{1, -2, 3, 4}, 1.0),
                Arguments.of(new int[]{}, -1),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5}, 2.0)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider8")
    void should_return_average_of_odd_number_elements_in_array(int[] initialArray, double expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        double result = vectorExercise6.getAverageOddNumbers();
        //assert
        assertEquals(expected, result, 0.01);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider8() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 2.0),
                Arguments.of(new int[]{-1, 2, 3, 4}, 1.0),
                Arguments.of(new int[]{}, -1),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5}, 3.0)
        );
    }


    @ParameterizedTest
    @MethodSource("arrayProvider9")
    void should_return_average_of_numbers_multiple_of_given_number(int[] initialArray, int number, double expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        double result = vectorExercise6.getAverageOfMultiplesOfGivenNumber(number);
        //assert
        assertEquals(expected, result, 0.01);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider9() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 2, 3.0),
                Arguments.of(new int[]{1, -2, 3, 4}, 2, 1.0),
                Arguments.of(new int[]{}, 1, -1),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5}, 3, 1.5)
        );
    }



    @ParameterizedTest
    @MethodSource("arrayProvider10")
    void should_return_sorted_array_depending_on_direction_0_ascending_1_descending(int[] initialArray, int direction, int[] expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        int[] result = vectorExercise6.sortArray(direction);
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider10() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1, 4}, 0,new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{}, 0,new int[]{-1}),
                Arguments.of(new int[]{}, 1,new int[]{-1}),
                Arguments.of(new int[]{0, 2, 5, 4, 3, 1}, 0, new int[]{0, 1, 2, 3, 4, 5}),
                Arguments.of(new int[]{0, 2, 5, 4, 3, -1}, 0, new int[]{-1, 0, 2, 3, 4, 5}),
                Arguments.of(new int[]{3, 2, 1, 4}, 1,new int[]{4, 3, 2, 1}),
                Arguments.of(new int[]{0, 2, 5, 4, 3, 1}, 1, new int[]{5, 4, 3, 2, 1, 0}),
                Arguments.of(new int[]{0, 2, 5, 4, 3, -1}, 1, new int[]{5, 4, 3, 2, 0, -1})

        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider11")
    void should_return_true_if_array_empty_else_false(int[] initialArray, boolean expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        boolean result = vectorExercise6.isArrayEmptyOrNull();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider11() {
        return Stream.of(
                Arguments.of(new int[]{}, true),
                Arguments.of(new int[]{1, 2}, false),
                Arguments.of(new int[]{-1, -2}, false)

        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider12")
    void should_return_true_if_array_has_only_one_value(int[] initialArray, boolean expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        boolean result = vectorExercise6.hasOnlyOneValue();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider12() {
        return Stream.of(
                Arguments.of(new int[]{}, false),
                Arguments.of(new int[]{1}, true),
                Arguments.of(new int[]{-1}, true),
                Arguments.of(new int[]{1, 2}, false),
                Arguments.of(new int[]{-1, -2}, false)


        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider13")
    void should_return_true_if_array_has_only_even_values(int[] initialArray, boolean expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        boolean result = vectorExercise6.hasOnlyEvenValues();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider13() {
        return Stream.of(
                Arguments.of(new int[]{1 ,2}, false),
                Arguments.of(new int[]{1}, false),
                Arguments.of(new int[]{0, 2}, true),
                Arguments.of(new int[]{0, 2}, true),
                Arguments.of(new int[]{-2, 0, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider14")
    void should_return_true_if_array_has_only_odd_values(int[] initialArray, boolean expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        boolean result = vectorExercise6.hasOnlyOddValues();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider14() {
        return Stream.of(
                Arguments.of(new int[]{1 ,2}, false),
                Arguments.of(new int[]{1}, true),
                Arguments.of(new int[]{0, 2}, false),
                Arguments.of(new int[]{1, 3}, true),
                Arguments.of(new int[]{-1, 1, 3}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider15")
    void should_return_true_if_array_has_duplicated_values(int[] initialArray, boolean expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        boolean result = vectorExercise6.hasDuplicatedValues();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider15() {
        return Stream.of(
                Arguments.of(new int[]{1 ,2}, false),
                Arguments.of(new int[]{1}, false),
                Arguments.of(new int[]{}, false),
                Arguments.of(null, false),
                Arguments.of(new int[]{0, 2}, false),
                Arguments.of(new int[]{1, 1, 3}, true),
                Arguments.of(new int[]{-1, -1, 3}, true),
                Arguments.of(new int[]{-1, 1, 3}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider16")
    void should_return_elements_that_total_digits_is_bigger_than_the_average_of_digits(int[] initialArray, boolean expected) {
        //arrange
        VectorExercise6 vectorExercise6 = new VectorExercise6(initialArray);
        //act
        boolean result = vectorExercise6.hasDuplicatedValues();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider16() {
        return Stream.of(
                Arguments.of(new int[]{1 ,2}, false),
                Arguments.of(new int[]{1}, false),
                Arguments.of(new int[]{}, false),
                Arguments.of(null, false),
                Arguments.of(new int[]{0, 2}, false),
                Arguments.of(new int[]{1, 1, 3}, true),
                Arguments.of(new int[]{-1, -1, 3}, true),
                Arguments.of(new int[]{-1, 1, 3}, false)
        );
    }


}