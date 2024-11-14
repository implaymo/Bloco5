package org.example.Exercicio5;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercicio5_2 {

    public static boolean sudoku(int[][]boardGame, int[][] updatedBoardGame) {
        if(checkIfBoardAsFreeSpaces(updatedBoardGame)){
            return true;
        } else{
            return false;
        }
    }

    public static ArrayList<int[]> freePositions(int[][] boardGame) {
        ArrayList<int[]> availablePositions = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (boardGame[row][column] == 0) {
                    availablePositions.add(new int[]{row, column});
                }
            }
        }
        return availablePositions;
    }

    public static boolean checkIfBoardAsFreeSpaces(int[][] updatedBoardGame) {
        if(freePositions(updatedBoardGame).isEmpty()) {
            return false;
        }
        return true;
    }
}
