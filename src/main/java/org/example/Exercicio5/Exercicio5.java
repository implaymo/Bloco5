package org.example.Exercicio5;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercicio5 {

    public static int[][] sudoku(int[][]boardGame) {
        SudokuBoardValidation sudokuBoardValidation = new SudokuBoardValidation(boardGame);

        if(getFreePositions(boardGame).isEmpty() && sudokuBoardValidation.isBoardValid(boardGame)) {
            return boardGame;
        }
        return boardGame;
    }
    
    public static ArrayList<int[]> getOccupiedPositions(int[][] boardGame) {
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

    public static ArrayList<int[]> getFreePositions(int[][] boardGame) {
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

    public static ArrayList<int[]> getPlayerPlayedPositions(int[][] updatedBoardGame, ArrayList<int[]> unavailablePositions) {
        ArrayList<int[]> playerMoves = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (updatedBoardGame[row][column] > 0 && updatedBoardGame[row][column] < 9) {
                     if(isPlayerMove(unavailablePositions, row, column)){
                         playerMoves.add(new int[]{row, column});
                     }
                }
            }
        }
        return playerMoves;
    }

    public static boolean isPlayerMove(ArrayList<int[]> unavailablePositions, int row, int column) {
        int[] positionToCheck = new int[]{row, column};
        for (int i = 0; i < unavailablePositions.size(); i++) {
            if (Arrays.equals(unavailablePositions.get(i), positionToCheck)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasFreeSpaces(int[][] updatedBoardGame) {
        return !getFreePositions(updatedBoardGame).isEmpty();
    }

    public static int[][] maskBoard(int[][] boardGame) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (boardGame[row][column] > 0 && boardGame[row][column] <= 9) {
                    boardGame[row][column] = 1;
                }
            }
        }
        return boardGame;
    }

    public static int[][] addNumberToBoard(int[][] boardGame, int row, int column, int number){
        int[] positionToAdd = new int[]{row,column};
        ArrayList<int[]> freeLocations = getFreePositions(boardGame);
        for (int i = 0; i < freeLocations.size(); i++) {
            if(Arrays.equals(freeLocations.get(i), positionToAdd)) {
                boardGame[row][column] = number;
            }
        }
        return boardGame;
    }

}
