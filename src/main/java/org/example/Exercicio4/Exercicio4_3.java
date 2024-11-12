package org.example.Exercicio4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Supplier;

public class Exercicio4_3 {

    public static boolean findWordProvided(char[][] boardGame, ArrayList<Character> wordToFind, int rowFirstChar,
                                           int columnFirstChar, int rowLastChar, int columnLastChar) {

        ArrayList<int[]> letterPositions = new ArrayList<>();
        letterPositions.add(new int[]{rowFirstChar, columnFirstChar});
        letterPositions.add(new int[]{rowLastChar, columnLastChar});

        ArrayList<Supplier<ArrayList<int[]>>> methods = new ArrayList<>();
        methods.add(() -> isWordHorizontal(boardGame, wordToFind));
        methods.add(() -> isWordHorizontalReversed(boardGame, wordToFind));
        methods.add(() -> isWordVertical(boardGame, wordToFind));
        methods.add(() -> isWordVerticalReversed(boardGame, wordToFind));
        methods.add(() -> isWordDiagonalTopLeft(boardGame, wordToFind));
        methods.add(() -> isWordDiagonalTopRight(boardGame, wordToFind));
        methods.add(() -> isWordDiagonalBottomLeft(boardGame, wordToFind));
        methods.add(() -> isWordDiagonalBottomRight(boardGame, wordToFind));
        for (int i = 0; i < methods.size(); i++) {
            if (checkIfPositionsMatch(letterPositions, methods.get(i).get())){
                return true;
            }
        }
        return false;
    }


    public static boolean checkIfPositionsMatch(ArrayList<int[]> letterPositions, ArrayList<int[]> result) {
        if (result.size() < 2) {
            return false;
        }
        return (result.get(0)[0] == letterPositions.get(0)[0] && result.get(0)[1] == letterPositions.get(0)[1]) &&
                (result.get(result.size() - 1)[0] == letterPositions.get(1)[0] && result.get(result.size() - 1)[1] == letterPositions.get(1)[1]);
    }

    public static ArrayList<int[]> isWordHorizontal(char[][] boardGame, ArrayList<Character> wordToFind){
        for (int row = 0; row < boardGame.length; row++) {
            for (int column = 0; column <= boardGame[0].length - wordToFind.size(); column++) {
                if(Exercicio4_2.isWordMatchHorizontal(boardGame, wordToFind, row, column)){
                }
            }
        }
        return new ArrayList<>();
    }


    public static ArrayList<int[]> isWordHorizontalReversed(char[][] boardGame, ArrayList<Character> wordToFind){
        for (int row = 0; row < boardGame.length; row++) {
            for (int column = boardGame[0].length - 1; column >= wordToFind.size() - 1; column--) {
                if(Exercicio4_2.isWordMatchHorizontalReversed(boardGame, wordToFind, row, column)){
                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<int[]> isWordVertical(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int column = 0; column < boardGame[0].length; column++) {
            for (int row = 0; row <= boardGame.length - wordToFind.size(); row++) {
                if(Exercicio4_2.isWordMatchVertical(boardGame, wordToFind, row, column)){
                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<int[]> isWordVerticalReversed(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int column = 0; column < boardGame[0].length; column++) {
            for (int row = boardGame.length - 1; row >= wordToFind.size() - 1; row--) {
                if(Exercicio4_2.isWordMatchVerticalReversed(boardGame, wordToFind, row, column)){

                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<int[]> isWordDiagonalTopLeft(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = 0; row < boardGame.length; row++) {
            for(int column = 0; column < boardGame[0].length; column++) {
                if(Exercicio4_2.isWordMatchDiagonalTopLeftStart(boardGame, wordToFind, row, column)){

                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<int[]> isWordDiagonalBottomLeft(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = boardGame.length -1 ; row > 0; row--) {
            for(int column = 0; column < boardGame[0].length; column++) {
                if(Exercicio4_2.isWordMatchDiagonalBottomLeftStart(boardGame, wordToFind, row, column)){

                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<int[]> isWordDiagonalTopRight(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = 0; row < boardGame.length; row++) {
            for(int column = boardGame[0].length - 1; column > 0; column--) {
                if(Exercicio4_2.isWordMatchDiagonalTopRightStart(boardGame, wordToFind, row, column)){

                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<int[]> isWordDiagonalBottomRight(char[][] boardGame, ArrayList<Character> wordToFind) {
        for (int row = boardGame.length - 1; row > 0; row--) {
            for(int column = boardGame[0].length - 1; column > 0; column--) {
                if(Exercicio4_2.isWordMatchDiagonalBottomRightStart(boardGame, wordToFind, row, column)){

                }
            }
        }
        return new ArrayList<>();
    }
}

