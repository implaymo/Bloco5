package org.example.Exercicio6;

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
                Arguments.of(new int[][]{{1,2},{3,4}}, 4),
                Arguments.of(new int[][]{{-1,2}, {0,1}}, 2),
                Arguments.of(new int[][]{{-1,-2}, {-3}}, -1),
                Arguments.of(new int[][]{{0,-1}, {-2}}, 0)
                );
    }

}