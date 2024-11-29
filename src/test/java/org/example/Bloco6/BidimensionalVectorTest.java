package org.example.Bloco6;

import org.example.Bloco6.exercicio1.VectorExercise6;
import org.example.Bloco6.exercicio2.BidimensionalVector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BidimensionalVectorTest {


    @Test
    void test_constructor1(){
        new BidimensionalVector();
    }

    @Test
    void test_constructor2(){
        int[][] newMatrix = {{1, 2}, {1, 2}};
        new BidimensionalVector(newMatrix);
    }


    @ParameterizedTest
    @MethodSource("arrayProvider0")
    void should_return_true_if_value_add_to_row(int value, int rowToAddValue, int[][] initialBidimensionalArray) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        boolean result = bidimensionalVector.hasAddValue(value, rowToAddValue);
        //assert
        assertTrue(result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider0() {
        return Stream.of(
                Arguments.of(4, 1, new int[][]{{1,2,3}, {1,2,3}}),
                Arguments.of(4, 0, new int[][]{{1,2,3}, {1,2,3}}),
                Arguments.of(0, 1, new int[][]{{1,2,3}, {1,2,3}}),
                Arguments.of(0, 0, new int[][]{{1,2,3}, {1,2,3}})
        );
    }


    @ParameterizedTest
    @MethodSource("arrayProvider1")
    void should_return_true_if_value_removed(int value, int[][] initialBidimensionalArray) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        boolean result = bidimensionalVector.hasRemovedValue(value);
        //assert
        assertTrue(result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider1() {
        return Stream.of(
                Arguments.of(3, new int[][]{{1,2,3}, {1,2,3}}),
                Arguments.of(3, new int[][]{{1,2,3}, {1,2,3}}),
                Arguments.of(0, new int[][]{{1,2,3}, {1,2,3}})
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider2")
    void should_return_true_if_matrix_is_empty_or_null(int[][] initialBidimensionalArray) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        boolean result = bidimensionalVector.isMatrixNullOrEmpty();
        //assert
        assertTrue(result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider2() {
        return Stream.of(
                Arguments.of((Object) new int[][]{{},{}}),
                Arguments.of((Object) new int[][]{{1,2}, {}}),
                Arguments.of((Object) new int[][]{{1,2}, {}})
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider3")
    void should_return_biggest_value_of_matrix(int[][] initialBidimensionalArray, int expected) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        int result = bidimensionalVector.getBiggestValueMatrix();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider3() {
        return Stream.of(
                Arguments.of(null, -1),
                Arguments.of(new int[][]{{}, null}, -1),
                Arguments.of(new int[][]{{1,2},{3,4}}, 4),
                Arguments.of(new int[][]{{-1,2}, {0,1}}, 2),
                Arguments.of(new int[][]{{-1,-2}, {-3}}, -1),
                Arguments.of(new int[][]{{0,-1}, {-2}}, 0),
                Arguments.of(new int[][]{{}, {}}, -1)
                );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider4")
    void should_return_lowest_value_of_matrix(int[][] initialBidimensionalArray, int expected) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        int result = bidimensionalVector.getLowestValueMatrix();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider4() {
        return Stream.of(
                Arguments.of(null, -1),
                Arguments.of(new int[][]{null, {}}, -1),
                Arguments.of(new int[][]{{}, {}}, -1),
                Arguments.of(new int[][]{{1,2},{3,4}}, 1),
                Arguments.of(new int[][]{{-1,2}, {0,1}}, -1),
                Arguments.of(new int[][]{{-1,-2}, {-3}}, -3),
                Arguments.of(new int[][]{{0,1}, {2}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider5")
    void should_return_average_value_of_matrix(int[][] initialBidimensionalArray, double expected) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        double result = bidimensionalVector.getAverageMatrix();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider5() {
        return Stream.of(
                Arguments.of(null, -1),
                Arguments.of(new int[][]{null, {}}, -1),
                Arguments.of(new int[][]{{}, {}}, -1),
                Arguments.of(new int[][]{{1,2},{3,4}}, 2.5),
                Arguments.of(new int[][]{{-1,2}, {0,1}}, 0.5),
                Arguments.of(new int[][]{{-1,-2}, {-3}}, -2.0),
                Arguments.of(new int[][]{{0,1}, {2}}, 1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider6")
    void should_return_array_which_each_positions_is_the_sum_of_matrix_row(int[][] initialBidimensionalArray, int[] expected) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        int[] result = bidimensionalVector.getRowsSum();
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider6() {
        return Stream.of(
                Arguments.of(null, new int[]{-1}),
                Arguments.of(new int[][]{null, {}}, new int[]{-1}),
                Arguments.of(new int[][]{{}, {}}, new int[]{-1}),
                Arguments.of(new int[][]{{1,2},{3,4}}, new int[]{3, 7}),
                Arguments.of(new int[][]{{-1,2}, {0,1}}, new int[]{1, 1}),
                Arguments.of(new int[][]{{-1,-2}, {-3}}, new int[]{-3, -3}),
                Arguments.of(new int[][]{{0,1}, {2}}, new int[]{1, 2})
        );
    }


    @ParameterizedTest
    @MethodSource("arrayProvider7")
    void should_return_array_with_sum_of_each_column_of_matrix(int[][] initialBidimensionalArray, int[] expected) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        int[] result = bidimensionalVector.getSumOfEachColumn();
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider7() {
        return Stream.of(
                Arguments.of(new int[][]{{1,2},{3,4}}, new int[]{4, 6}),
                Arguments.of(new int[][]{{-1,2}, {0,1}}, new int[]{-1, 3}),
                Arguments.of(new int[][]{{-1,-2}, {-3}}, new int[]{-4, -2}),
                Arguments.of(new int[][]{{0,1}, {2}}, new int[]{2, 1}),
                Arguments.of(null, new int[]{-1}),
                Arguments.of(new int[][]{null, {}}, new int[]{-1}),
                Arguments.of(new int[][]{{}, {}}, new int[]{-1})
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider8")
    void should_return_index_array_with_biggest_sum_of_elements(int[][] initialBidimensionalArray, int expected) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        int result = bidimensionalVector.getIndexArrayWithBiggestSumOfElements();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider8() {
        return Stream.of(
                Arguments.of(new int[][]{{1,2},{3,4}}, 1),
                Arguments.of(new int[][]{{-1,2}, {0,1}}, 0),
                Arguments.of(new int[][]{{-1,-2}, {-3, -2}}, 0),
                Arguments.of(new int[][]{{0,1}, {2}}, 1),
                Arguments.of(null, -1),
                Arguments.of(new int[][]{null, {}}, -1),
                Arguments.of(new int[][]{{}, {}}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider9")
    void should_return_true_if_matrix_square(int[][] initialBidimensionalArray) {
        // arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        // act
        boolean result = bidimensionalVector.isMatrixSquare();
        // assert
        assertTrue(result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider9() {
        return Stream.of(
                Arguments.of((Object) new int[][]{{2, 2},{2, 2}}),
                Arguments.of((Object) new int[][]{{2, 2, 4},{1, 2, 3}, {1, 2, 3}})
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider10")
    void should_return_true_if_matrix_square_and_symmetric(int[][] initialBidimensionalArray) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        boolean result = bidimensionalVector.isMatrixSquareAndSymmetric();
        //assert
        assertTrue(result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider10() {
        return Stream.of(
                Arguments.of((Object) new int[][]{{1, 2, 3}, {2, 4, 5}, {3, 5, 6}}),
                Arguments.of((Object) new int[][]{{4, 7}, {7, 2}}),
                Arguments.of((Object) new int[][]{{1, 3, 5, 7}, {3, 2, 4, 6}, {5, 4, 3, 8}, {7, 6, 8, 9}})
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider11")
    void should_return_total_of_none_negative_numbers_in_principal_array_if_matrix_is_square_if_not_return_minus_1(
            int[][] initialBidimensionalArray, int expected) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        int result = bidimensionalVector.getTotalOfNoneNegativeNumbersInPrincipalDiagonal();
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider11() {
        return Stream.of(
                Arguments.of((Object) new int[][]{{-1, 2, 3}, {2, 4, 5}, {3, 5, 6}}, 2),
                Arguments.of((Object) new int[][]{{4, 7}, {7, 2}}, 2),
                Arguments.of((Object) new int[][]{{0, 3, 5, 7}, {3, -2, 4, 6}, {5, 4, -3, 8}, {7, 6, 8, 9}}, 2),
                Arguments.of(null, -1),
                Arguments.of(new int[][]{null, {}}, -1),
                Arguments.of(new int[][]{{}, {}}, -1),
                Arguments.of((Object) new int[][]{{4, 7}, {7}}, -1)
                );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider12")
    void should_return_true_if_diagonal_primary_and_secondary_are_equal_and_have_the_same_order(
            int[][] initialBidimensionalArray) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        boolean result = bidimensionalVector.isPrincipalDiagonalEqualSecondaryDiagonalAndSameDigitOrder();
        //assert
        assertTrue(result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider12() {
        return Stream.of(
                Arguments.of((Object) new int[][]{{1, 2, 1}, {3, 5, 3}, {2, 4, 2}}),
                Arguments.of((Object) new int[][]{{4, 7, 4}, {6, 8, 6}, {9, 5, 9}}),
                Arguments.of((Object) new int[][]{{2, 3, 5, 2}, {4, 7, 7, 4}, {1, 6, 6, 1}, {3, 8, 9, 3}})
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider13")
    void should_return_elements_that_total_digits_is_bigger_than_the_average_number_of_digits(int[][] initialBidimensionalArray, int[] expected) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        int[] result = bidimensionalVector.getAllElementsWhichHaveHigherDigitsPercentageThanTheAverageOfDigits();
        //assert
        assertArrayEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider13() {
        return Stream.of(
                Arguments.of(new int[][]{{1 ,222, 33},{1 ,222, 33}}, new int[]{222, 222}),
                Arguments.of(new int[][]{{1 ,222, 33},{1 ,-222, 33}}, new int[]{222, -222}),
                Arguments.of(new int[][]{{1 ,1, 1}, {1, 1, 1}}, new int[]{}),
                Arguments.of(new int[][]{{1 ,22, 33, 44, 55},{1 ,2, 3, 4, 5}}, new int[]{22, 33, 44, 55}),
                Arguments.of(null, new int[]{-1}),
                Arguments.of(new int[][]{{},{}}, new int[]{-1})
        );
    }


    @ParameterizedTest
    @MethodSource("arrayProvider14")
    void should_return_array_with_elements_that_have_bigger_even_digits_average_than_the_total_average_of_even_digits(
        int[][] initialBidimensionalArray, int[] expected) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        int[] result = bidimensionalVector.getAllElementsWhichHaveHigherEvenDigitsPercentageThanTheAverageOfEvenDigits();
        //assert
        assertArrayEquals(expected, result);

    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider14() {
        return Stream.of(
                Arguments.of(new int[][]{{248, 135, 860},{248, 135, 860}}, new int[]{248, 860, 248, 860}),
                Arguments.of(new int[][]{{5, 5, 3},{-248, 135, 860}}, new int[]{-248, 860}),
                Arguments.of(new int[][]{{1},{0}}, new int[]{0}),
                Arguments.of(new int[][]{{1},{1,1}}, new int[]{}),
                Arguments.of(null, new int[]{-1}),
                Arguments.of(new int[][]{{},{}}, new int[]{-1})
        );
    }


    @ParameterizedTest
    @MethodSource("arrayProvider15")
    void should_return_matrix_with_values_of_rows_inverted(
            int[][] initialBidimensionalArray, int[][] expected) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        int[][] result = bidimensionalVector.invertMatrixRowValues();
        //assert
        assertArrayEquals(expected, result);

    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider15() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3},{4, 5, 6}}, new int[][]{{3, 2, 1},{6, 5, 4}}),
                Arguments.of(new int[][]{{0, 2, 3},{-4, 5, 6}}, new int[][]{{3, 2, 0},{6, 5, -4}}),
                Arguments.of(new int[][]{{1, 2},{4, 5, 6}}, new int[][]{{2, 1},{6, 5, 4}}),
                Arguments.of(new int[][]{{0},{0}}, new int[][]{{0},{0}}),
                Arguments.of(new int[][]{{},{1,1}}, new int[][]{{-1}}),
                Arguments.of(null, new int[][]{{-1}}),
                Arguments.of(new int[][]{{},{}}, new int[][]{{-1}}),
                Arguments.of(new int[][]{null ,{1,1}}, new int[][]{{-1}})
                );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider16")
    void should_return_matrix_with_values_of_columns_inverted(
            int[][] initialBidimensionalArray, int[][] expected) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        int[][] result = bidimensionalVector.invertMatrixColumnValues();
        //assert
        assertArrayEquals(expected, result);

    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider16() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3},{4, 5, 6}}, new int[][]{{4, 5, 6},{1, 2, 3}}),
                Arguments.of(new int[][]{{0, 2, 3},{-4, 5, 6}}, new int[][]{{-4, 5, 6},{0, 2, 3}}),
                Arguments.of(new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}}, new int[][]{{7, 8, 9},{4, 5, 6},{1, 2, 3}}),
                Arguments.of(new int[][]{{1, 2},{4, 5, 6}}, new int[][]{{4, 5, 6},{1, 2}}),
                Arguments.of(new int[][]{{0},{0}}, new int[][]{{0},{0}}),
                Arguments.of(new int[][]{{},{1,1}}, new int[][]{{-1}}),
                Arguments.of(null, new int[][]{{-1}}),
                Arguments.of(new int[][]{{},{}}, new int[][]{{-1}}),
                Arguments.of(new int[][]{null ,{1,1}}, new int[][]{{-1}})
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider17")
    void should_return_matrix_rotated_90_degress(
            int[][] initialBidimensionalArray, int[][] expected) {
        //arrange
        BidimensionalVector bidimensionalVector = new BidimensionalVector(initialBidimensionalArray);
        //act
        int[][] result = bidimensionalVector.rotateMatrix90Degrees();
        //assert
        assertArrayEquals(expected, result);

    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider17() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3},{4, 5, 6}}, new int[][]{{4, 1},{5, 2}, {6, 3}}),
                Arguments.of(new int[][]{{0, 2, 3},{-4, 5, 6}}, new int[][]{{-4, 0},{5, 2}, {6, 3}}),
                Arguments.of(new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}}, new int[][]{{7, 4, 1},{8, 5, 2}, {9, 6, 3}}),
                Arguments.of(new int[][]{{1, 2},{4, 5, 6}}, new int[][]{{-1}}),
                Arguments.of(new int[][]{{0},{0}}, new int[][]{{0,0}}),
                Arguments.of(new int[][]{{},{1,1}}, new int[][]{{-1}}),
                Arguments.of(null, new int[][]{{-1}}),
                Arguments.of(new int[][]{{},{}}, new int[][]{{-1}}),
                Arguments.of(new int[][]{null ,{1,1}}, new int[][]{{-1}})
        );
    }
}