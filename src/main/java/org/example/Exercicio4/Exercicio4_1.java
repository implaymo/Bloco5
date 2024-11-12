package org.example.Exercicio4;

public class Exercicio4_1 {

    public static int[][] createMaskGrid(char[][] boardGame, char letterToFind){
        int[][] maskGrid = new int[boardGame.length][boardGame[0].length];
        for (int i = 0; i < boardGame.length; i++) {
            for (int j = 0; j < boardGame[0].length; j++) {
                if (boardGame[i][j] == letterToFind) {
                    maskGrid[i][j] = 1;
                } else{
                    maskGrid[i][j] = 0;
                }
            }
        }
        return maskGrid;
    }
}

