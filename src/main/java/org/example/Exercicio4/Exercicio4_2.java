package org.example.Exercicio4;

import java.util.ArrayList;

public class Exercicio4_2 {

    public static boolean wordSearchGame(char[][] boardGame, ArrayList<Character> wordToFind){
        if (isWordHorizontal(boardGame, wordToFind)){
            return true;
        } else{
            return false;
        }
    }

    public static boolean isWordHorizontal(char[][] boardGame, ArrayList<Character> wordToFind){
        ArrayList<Character> word = new ArrayList<>();
        for (int i = 0; i < boardGame.length; i++) {
            for (int j = 0; j <= boardGame[0].length - wordToFind.size(); j++) {
                if(isWordMatch(boardGame, wordToFind, i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWordMatch(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row][column + i] != wordToFind.get(i)){
                return false;
            }
        }
        return true;
    }
}
