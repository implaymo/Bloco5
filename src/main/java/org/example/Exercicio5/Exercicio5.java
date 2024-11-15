package org.example.Exercicio5;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercicio5 {

    public static int[][] sudoku(int[][]boardGame, int rowToPlay, int columnToPlay, int numberToPlay) {
        SudokuRules sudokuRules = new SudokuRules(boardGame);

        if (!sudokuRules.isNumberInRow(numberToPlay, rowToPlay)
                || !sudokuRules.isNumberInColumn(numberToPlay, columnToPlay) || !sudokuRules.isNumberIn3x3Matrix(numberToPlay,rowToPlay,columnToPlay)) {
            int[][] updatedBoardGame = playerAddNewNumber(boardGame, rowToPlay,columnToPlay, numberToPlay);
            return updatedBoardGame;
        }
        return boardGame;
    }
    
    public static ArrayList<int[]> occupiedPositions(int[][] boardGame) {
        ArrayList<int[]> unavailablePositions = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (boardGame[row][column] > 0 && boardGame[row][column] <= 9) {
                    unavailablePositions.add(new int[]{row, column});
                }

            }
        }
        return unavailablePositions;
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

    public static ArrayList<int[]> playerPlayedPositions(int[][] updatedBoardGame, ArrayList<int[]> unavailablePositions) {
        ArrayList<int[]> playerPlayedPositions = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (updatedBoardGame[row][column] > 0 && updatedBoardGame[row][column] < 9) {
                     if(checkIfPlayerPlayed(unavailablePositions, row, column)){
                         playerPlayedPositions.add(new int[]{row, column});
                     }
                }
            }
        }
        return playerPlayedPositions;
    }

    public static boolean checkIfPlayerPlayed(ArrayList<int[]> unavailablePositions, int row, int column) {
        int[] positionToCheck = new int[]{row, column};
        for (int i = 0; i < unavailablePositions.size(); i++) {
            if (Arrays.equals(unavailablePositions.get(i), positionToCheck)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfBoardAsFreeSpaces(int[][] updatedBoardGame) {
        if(freePositions(updatedBoardGame).isEmpty()) {
            return false;
        }
        return true;
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

    public static int[][] playerAddNewNumber(int[][] boardGame, int row, int column, int number){
        int[] positionToAdd = new int[]{row,column};
        ArrayList<int[]> freeLocations = freePositions(boardGame);
        for (int i = 0; i < freeLocations.size(); i++) {
            if(Arrays.equals(freeLocations.get(i), positionToAdd)) {
                boardGame[row][column] = number;
            }
        }
        return boardGame;
    }

}
