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



}