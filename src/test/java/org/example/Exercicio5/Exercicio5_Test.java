package org.example.Exercicio5;

import org.example.Bloco5.Exercicio5.Exercicio5;
import org.example.Bloco5.Exercicio5.SudokuBoardValidation;
import org.example.Bloco5.Exercicio5.SudokuRules;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercicio5_Test {

    @Test
    void test_constructor() {
        new Exercicio5();
    }

    @ParameterizedTest
    @MethodSource("arrayProvider0")
    void should_return_true_if_still_free_spaces_on_board_game(int[][] updatedBoardGame, boolean expected) {
        //arrange
        //act
        boolean result = Exercicio5.hasFreeSpaces(updatedBoardGame);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider0() {
        return Stream.of(
                Arguments.of(new int[][]{
                                {0, 0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 7, 1, 0, 0, 0, 0, 0, 5},
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 2, 0, 0, 0, 4, 0, 0},
                                {0, 0, 6, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 9, 0, 0, 0, 0, 0},
                                {0, 6, 0, 0, 0, 0, 0, 0, 4},
                                {2, 0, 3, 0, 1, 0, 0, 0, 0},
                                {0, 0, 5, 0, 0, 0, 0, 0, 0}
                        },
                        true
                ),
                Arguments.of(new int[][]{
                                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        },
                        false
                )
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider1")
    void should_return_true_if_player_played(int[][] boardGame, int[][] updatedBoardGame, int row, int column, boolean expected) {
        //arrange
        ArrayList<int[]> notAvailablePositions = Exercicio5.getOccupiedPositions(boardGame);
        //act
        boolean result = Exercicio5.isPlayerMove(notAvailablePositions, row, column);
        //assert
        assertEquals(expected, result);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider1() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 7, 0, 0, 0, 0, 0, 0, 5},
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 4, 0, 0},
                                {0, 0, 6, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 9, 0, 0, 0, 0, 0},
                                {0, 6, 0, 0, 0, 0, 0, 0, 4},
                                {2, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 5, 0, 0, 0, 0, 0, 0}
                        },
                        new int[][]{
                                {0, 0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 7, 1, 0, 0, 0, 0, 0, 5},
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 2, 0, 0, 0, 4, 0, 0},
                                {0, 0, 6, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 9, 0, 0, 0, 0, 0},
                                {0, 6, 0, 0, 0, 0, 0, 0, 4},
                                {2, 0, 3, 0, 1, 0, 0, 0, 0},
                                {0, 0, 5, 0, 0, 0, 0, 0, 0}
                        }, 1, 2, true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider2")
    void should_return_mask_matrix(int[][] boardGame, int[][] expected) {
        //arrange
        //act
        int[][] result = Exercicio5.maskBoard(boardGame);
        //assert
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> arrayProvider2() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 7, 0, 0, 0, 0, 0, 0, 5},
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 4, 0, 0},
                                {0, 0, 6, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 9, 0, 0, 0, 0, 0},
                                {0, 6, 0, 0, 0, 0, 0, 0, 4},
                                {2, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 5, 0, 0, 0, 0, 0, 0}
                        }, new int[][]{
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 1, 0, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                                {0, 0, 1, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                                {0, 1, 0, 0, 0, 0, 0, 0, 1},
                                {1, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 1, 0, 0, 0, 0, 0, 0}
                        }
                )
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider3")
    void should_return_all_locations_of_unavailable_locations(int[][] boardGame, ArrayList<int[]> expected) {
        //arrange
        //act
        ArrayList<int[]> result = Exercicio5.getOccupiedPositions(boardGame);
        //assert
        for (int i = 0; i < expected.size(); i++) {
            assertTrue(Arrays.equals(expected.get(i), result.get(i)));
        }
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider3() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 7, 0, 0, 0, 0, 0, 0, 5},
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 4, 0, 0},
                                {0, 0, 6, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 9, 0, 0, 0, 0, 0},
                                {0, 6, 0, 0, 0, 0, 0, 0, 4},
                                {2, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 5, 0, 0, 0, 0, 0, 0}
                        }, new ArrayList<>(Arrays.asList(
                                new int[]{0, 4},
                                new int[]{1, 1},
                                new int[]{1, 8},
                                new int[]{2, 4},
                                new int[]{3, 6},
                                new int[]{4, 2},
                                new int[]{4, 8},
                                new int[]{5, 3},
                                new int[]{6, 1},
                                new int[]{6, 8},
                                new int[]{7, 0},
                                new int[]{7, 4},
                                new int[]{8, 2}
                        )

                )
        ));
    }

    @ParameterizedTest
    @MethodSource("arrayProvider4")
    void should_return_all_location_free_spaces(int[][] boardGame, ArrayList<int[]> expected) {
        //arrange
        //act
        ArrayList<int[]> result = Exercicio5.getFreePositions(boardGame);
        //assert
        for (int i = 0; i < expected.size(); i++) {
            assertTrue(Arrays.equals(expected.get(i), result.get(i)));
        }
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider4() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {3, 7, 4, 2, 8, 6, 9, 1, 5},
                                {6, 5, 2, 3, 1, 4, 7, 9, 8},
                                {1, 9, 3, 5, 4, 7, 4, 8, 2},
                                {8, 4, 6, 7, 3, 2, 5, 9, 1},
                                {5, 2, 9, 9, 6, 1, 3, 7, 4},
                                {7, 6, 8, 4, 5, 3, 0, 6, 4},
                                {2, 3, 1, 8, 0, 5, 6, 4, 7},
                                {9, 8, 5, 6, 7, 9, 3, 2, 1},
                                {4, 1, 7, 3, 2, 8, 5, 0, 9}
                        }, new ArrayList<>(Arrays.asList(
                                new int[]{5, 6},
                                new int[]{6, 4},
                                new int[]{8, 7}
                        )
                        )));
    }

    @ParameterizedTest
    @MethodSource("arrayProvider5")
    void should_return_all_location_player_player_spaces(int[][] boardGame, int[][] updatedBoardGame,ArrayList<int[]> expected) {
        //arrange
        ArrayList<int[]> notAvailablePositions = Exercicio5.getOccupiedPositions(boardGame);
        //act
        ArrayList<int[]> result = Exercicio5.getPlayerPlayedPositions(updatedBoardGame, notAvailablePositions);
        //assert
        for (int i = 0; i < expected.size(); i++) {
            assertTrue(Arrays.equals(expected.get(i), result.get(i)));
        }
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider5() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 7, 0, 0, 0, 0, 0, 0, 5},
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 4, 0, 0},
                                {0, 0, 6, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 9, 0, 0, 0, 0, 0},
                                {0, 6, 0, 0, 0, 0, 0, 0, 4},
                                {2, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 5, 0, 0, 0, 0, 0, 0}
                        },
                        new int[][]{
                                {0, 0, 0, 0, 7, 0, 0, 0, 0},
                                {0, 7, 1, 0, 0, 0, 0, 0, 5},
                                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 2, 0, 0, 0, 4, 0, 0},
                                {0, 0, 6, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 9, 0, 0, 0, 0, 0},
                                {0, 6, 0, 0, 0, 0, 0, 0, 4},
                                {2, 0, 3, 0, 1, 0, 0, 0, 0},
                                {0, 0, 5, 0, 0, 0, 0, 0, 0}
                        }, new ArrayList<>(Arrays.asList(
                                new int[]{1, 2},
                                new int[]{3, 2},
                                new int[]{7, 2}
                        )
                        )));
    }

    @ParameterizedTest
    @MethodSource("arrayProvider6")
    void should_return_updated_board_game(int[][] boardGame, int rowPlayed, int columnPlayed, int numberPlayed, int[][] expected) {
        //arrange
        //act
        int[][] result = Exercicio5.addNumberToBoard(boardGame, rowPlayed, columnPlayed, numberPlayed);
        //assert
        assertArrayEquals(result,expected);
    }

    // This method provides test data to the parameterized test
    private static Stream<Arguments> arrayProvider6() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 3, 4, 6, 7, 8, 9, 1, 2},
                                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        }, 0, 0, 5,
                        new int[][]{
                                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        }),
                Arguments.of(
                        new int[][]{
                                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 0, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        }, 4, 4, 5,
                        new int[][]{
                                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        }),
                Arguments.of(
                        new int[][]{
                                {0, 3, 4, 6, 7, 8, 9, 1, 2},
                                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        }, 0, 0, 9,
                        new int[][]{
                                {9, 3, 4, 6, 7, 8, 9, 1, 2},
                                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        })
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider7")
    void should_return_valid_finished_board(int[][] boardGame, int[][] expected) {
        //arrange
        //act
        int[][] result = Exercicio5.sudoku(boardGame);
        //assert
        assertArrayEquals(result,expected);
    }

    private static Stream<Arguments> arrayProvider7() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        },
                        new int[][]{
                                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        })
        );
    }

    @ParameterizedTest
    @MethodSource("arrayProvider8")
    void should_return_if_board_is_Valid(int[][] boardGame, boolean expected) {
        // arrange
        SudokuBoardValidation validator = new SudokuBoardValidation(boardGame);
        // act
        boolean result = validator.isBoardValid(boardGame);
        // assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> arrayProvider8() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        }, true
                ),
                Arguments.of(
                        new int[][]{
                                {5, 3, 4, 5, 7, 8, 9, 1, 2},
                                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        }, false
                ),
                Arguments.of(
                        new int[][]{
                                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                                {5, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        }, false
                )
        );
    }
    @Test
    void testIsNumberValidInRow() {
        // arrange
        int[][] board = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        // act
        SudokuRules rules = new SudokuRules(board);
        // assert
        assertFalse(rules.isNumberValidInRow(5, 0, 1)); // 5 is already in the row
    }

    @Test
    void testIsNumberValidInColumn() {
        // arrange
        int[][] board = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        // act
        SudokuRules rules = new SudokuRules(board);
        // assert
        assertFalse(rules.isNumberValidInColumn(5, 0, 1));
    }

    @Test
    void testIsNumberValidIn3x3Matrix() {
        // arrange
        int[][] board = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        // act
        SudokuRules rules = new SudokuRules(board);
        // assert
        assertFalse(rules.isNumberValidIn3x3Matrix(5, 0, 1));
    }
}