package org.example.Exercicio4;

import java.util.ArrayList;

public class Exercicio4_2 {

    public static boolean wordSearchGame(char[][] boardGame, ArrayList<Character> wordToFind){
        if (isWordVertical(boardGame, wordToFind)){
            return true;
        } else{
            return false;
        }
    }

    // Directions

    public static boolean isWordHorizontal(char[][] boardGame, ArrayList<Character> wordToFind){
        for (int row = 0; row < boardGame.length; row++) {
            for (int column = 0; column <= boardGame[0].length - wordToFind.size(); column++) {
                if(isWordMatchHorizontal(boardGame, wordToFind, row,column)){
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean isWordHorizontalReversed(char[][] boardGame, ArrayList<Character> wordToFind){
        for (int row = 0; row < boardGame.length; row++) {
            for (int column = boardGame[0].length - 1; column >= wordToFind.size() - 1; column--) {
                if(isWordMatchHorizontalReversed(boardGame, wordToFind, row ,column)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWordVertical(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int column = 0; column < boardGame[0].length; column++) {
            for (int row = 0; row <= boardGame.length - wordToFind.size(); row++) {
                if(isWordMatchVertical(boardGame, wordToFind, row, column)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWordVerticalReversed(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int column = 0; column < boardGame[0].length; column++) {
            for (int row = boardGame.length - 1; row >= wordToFind.size() - 1; row--) {
                if(isWordMatchVerticalReversed(boardGame, wordToFind, row, column)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWordDiagonal(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = 0; row < boardGame.length; row++) {
            for(int column = 0; column < boardGame[0].length; column++) {
                if(isWordMatchDiagonalTopLeftStart(boardGame, wordToFind, row, column)) {
                    return true;
                }
            }
        }
        return false;
    }


    // Check Match Words in every direction

    public static boolean isWordMatchHorizontal(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row][column + i] != wordToFind.get(i)){
                return false;
            }
        }
        return true;
    }

    public static boolean isWordMatchHorizontalReversed(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row][column - i] != wordToFind.get(i)){
                return false;
            }
        }
        return true;
    }


    public static boolean isWordMatchVertical(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row + i][column] != wordToFind.get(i)){
                return false;
            }
        }
        return true;
    }

    public static boolean isWordMatchVerticalReversed(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
        for (int i = 0; i < wordToFind.size(); i++) {
            if (boardGame[row - i][column] != wordToFind.get(i)){
                return false;
            }
        }
        return true;
    }


    public static boolean isWordMatchDiagonalTopLeftStart(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
        if (row + wordToFind.size() <= boardGame.length && column + wordToFind.size() <= boardGame[0].length) {
            boolean match = true;
            for (int i = 0; i < wordToFind.size(); i++) {
                if (boardGame[row + i][column + i] != wordToFind.get(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWordMatchDiagonalDownLeftStart(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
        if (row + wordToFind.size() <= boardGame.length && column + wordToFind.size() <= boardGame[0].length) {
            boolean match = true;
            for (int i = 0; i < wordToFind.size(); i++) {
                if (boardGame[row + i][column + i] != wordToFind.get(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}

