package org.example.Exercicio5;

import java.util.ArrayList;

public class Exercicio5_3 {

    public static int[][] sudoku(int[][]boardGame) {

        return maskMatrix(boardGame);
    }

    public static int[][] maskMatrix(int[][] boardGame) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (boardGame[row][column] > 0 && boardGame[row][column] <= 9) {
                    boardGame[row][column] = 1;
                }
            }
        }
        return boardGame;
    }
}
