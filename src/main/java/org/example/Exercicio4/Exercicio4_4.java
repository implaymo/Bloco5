//package org.example.Exercicio4;
//
//import java.util.ArrayList;
//import java.util.function.Supplier;
//
//public class Exercicio4_4 {
//
//    public static boolean findWordProvided(char[][] boardGame, ArrayList<Character> wordToFind, int rowFirstChar,
//                                           int columnFirstChar, int rowLastChar, int columnLastChar) {
//
//        ArrayList<int[]> letterPositions = new ArrayList<>();
//        letterPositions.add(new int[]{rowFirstChar, columnFirstChar});
//        letterPositions.add(new int[]{rowLastChar, columnLastChar});
//
//        ArrayList<Supplier<ArrayList<int[]>>> methods = new ArrayList<>();
//        methods.add(() -> isWordHorizontal(boardGame, wordToFind));
//        methods.add(() -> isWordHorizontalReversed(boardGame, wordToFind));
//        methods.add(() -> isWordVertical(boardGame, wordToFind));
//        methods.add(() -> isWordVerticalReversed(boardGame, wordToFind));
//        methods.add(() -> isWordDiagonalTopLeft(boardGame, wordToFind));
//        methods.add(() -> isWordDiagonalTopRight(boardGame, wordToFind));
//        methods.add(() -> isWordDiagonalBottomLeft(boardGame, wordToFind));
//        methods.add(() -> isWordDiagonalBottomRight(boardGame, wordToFind));
//        for (int i = 0; i < methods.size(); i++) {
//            if (checkIfPositionsMatch(letterPositions, methods.get(i).get())){
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    public static boolean checkIfPositionsMatch(ArrayList<int[]> letterPositions, ArrayList<int[]> result) {
//        if (result.size() < 2) {
//            return false;
//        }
//        return true;
//    }
//
//    public static ArrayList<int[]> isWordHorizontal(char[][] boardGame, ArrayList<Character> wordToFind){
//        for (int row = 0; row < boardGame.length; row++) {
//            for (int column = 0; column <= boardGame[0].length - wordToFind.size(); column++) {
//                if(isWordMatchHorizontal(boardGame, wordToFind, row, column).size() > 0){
//                    return isWordMatchVertical(boardGame, wordToFind, row, column);
//                }
//            }
//        }
//        return new ArrayList<>();
//    }
//
//
//    public static ArrayList<int[]> isWordHorizontalReversed(char[][] boardGame, ArrayList<Character> wordToFind){
//        for (int row = 0; row < boardGame.length; row++) {
//            for (int column = boardGame[0].length - 1; column >= wordToFind.size() - 1; column--) {
//                if(isWordMatchHorizontalReversed(boardGame, wordToFind, row, column).size() > 0){
//                    return isWordMatchHorizontalReversed(boardGame, wordToFind, row, column);
//                }
//            }
//        }
//        return new ArrayList<>();
//    }
//
//    public static ArrayList<int[]> isWordVertical(char[][] boardGame, ArrayList<Character> wordToFind) {
//        for (int column = 0; column < boardGame[0].length; column++) {
//            for (int row = 0; row <= boardGame.length - wordToFind.size(); row++) {
//                if(isWordMatchVertical(boardGame, wordToFind, row, column).size() > 0){
//                    return isWordMatchVertical(boardGame, wordToFind, row, column);
//                }
//            }
//        }
//        return new ArrayList<>();
//    }
//
//    public static ArrayList<int[]> isWordVerticalReversed(char[][] boardGame, ArrayList<Character> wordToFind) {
//        for (int column = 0; column < boardGame[0].length; column++) {
//            for (int row = boardGame.length - 1; row >= wordToFind.size() - 1; row--) {
//                if(isWordMatchVerticalReversed(boardGame, wordToFind, row, column).size() > 0){
//                    return isWordMatchVertical(boardGame, wordToFind, row, column);
//                }
//            }
//        }
//        return new ArrayList<>();
//    }
//
//    public static ArrayList<int[]> isWordDiagonalTopLeft(char[][] boardGame, ArrayList<Character> wordToFind) {
//        for (int row = 0; row < boardGame.length; row++) {
//            for(int column = 0; column < boardGame[0].length; column++) {
//                if(isWordMatchDiagonalTopLeftStart(boardGame, wordToFind, row, column).size() > 0){
//                    return isWordMatchVertical(boardGame, wordToFind, row, column);
//                }
//            }
//        }
//        return new ArrayList<>();
//    }
//
//    public static ArrayList<int[]> isWordDiagonalBottomLeft(char[][] boardGame, ArrayList<Character> wordToFind) {
//        for (int row = boardGame.length -1 ; row > 0; row--) {
//            for(int column = 0; column < boardGame[0].length; column++) {
//                if(isWordMatchDiagonalBottomLeftStart(boardGame, wordToFind, row, column).size() > 0){
//                    return isWordMatchVertical(boardGame, wordToFind, row, column);
//                }
//            }
//        }
//        return new ArrayList<>();
//    }
//
//    public static ArrayList<int[]> isWordDiagonalTopRight(char[][] boardGame, ArrayList<Character> wordToFind) {
//        for (int row = 0; row < boardGame.length; row++) {
//            for(int column = boardGame[0].length - 1; column > 0; column--) {
//                if(isWordMatchDiagonalTopRightStart(boardGame, wordToFind, row, column).size() > 0){
//                    return isWordMatchVertical(boardGame, wordToFind, row, column);
//                }
//            }
//        }
//        return new ArrayList<>();
//    }
//
//    public static ArrayList<int[]> isWordDiagonalBottomRight(char[][] boardGame, ArrayList<Character> wordToFind) {
//        for (int row = boardGame.length - 1; row > 0; row--) {
//            for(int column = boardGame[0].length - 1; column > 0; column--) {
//                if(isWordMatchDiagonalBottomRightStart(boardGame, wordToFind, row, column).size() > 0){
//                    return isWordMatchVertical(boardGame, wordToFind, row, column);
//                }
//            }
//        }
//        return new ArrayList<>();
//    }
//
//
//    // Check Match Words in every direction
//
//    public static ArrayList<int[]> isWordMatchHorizontal(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
//        ArrayList<int[]> positionsOfWord = new ArrayList<>();
//        for (int i = 0; i < wordToFind.size(); i++) {
//            if (boardGame[row][column + i] != wordToFind.get(i)) {
//                continue;
//            } else {
//                positionsOfWord.add(new int[]{row, column + i});
//            }
//        }
//        return positionsOfWord;
//    }
//
//    public static ArrayList<int[]>  isWordMatchHorizontalReversed(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
//        ArrayList<int[]> positionsOfWord = new ArrayList<>();
//        for (int i = 0; i < wordToFind.size(); i++) {
//            if (boardGame[row][column - i] != wordToFind.get(i)){
//                continue;
//            } else{
//                positionsOfWord.add(new int[]{row, column - i});
//            }
//        }
//        return positionsOfWord;
//    }
//
//
//    public static ArrayList<int[]>  isWordMatchVertical(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
//        ArrayList<int[]> positionsOfWord = new ArrayList<>();
//        for (int i = 0; i < wordToFind.size(); i++) {
//            if (boardGame[row + i][column] != wordToFind.get(i)){
//                continue;
//            } else {
//                positionsOfWord.add(new int[]{row + i, column});
//            }
//        }
//        return positionsOfWord;
//    }
//
//    public static ArrayList<int[]>  isWordMatchVerticalReversed(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column){
//        ArrayList<int[]> positionsOfWord = new ArrayList<>();
//        for (int i = 0; i < wordToFind.size(); i++) {
//            if (boardGame[row - i][column] != wordToFind.get(i)){
//                continue;
//            } else {
//                positionsOfWord.add(new int[]{row - i, column});
//            }
//        }
//        return positionsOfWord;
//    }
//
//
//    public static ArrayList<int[]>  isWordMatchDiagonalTopLeftStart(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
//        ArrayList<int[]> positionsOfWord = new ArrayList<>();
//        if (row + wordToFind.size() <= boardGame.length && column + wordToFind.size() <= boardGame[0].length) {
//            boolean match = true;
//            for (int i = 0; i < wordToFind.size(); i++) {
//                if (boardGame[row + i][column + i] != wordToFind.get(i)) {
//                    match = false;
//                    break;
//                } else{
//                    positionsOfWord.add(new int[]{row + i, column + i});
//                }
//            }
//        }
//        return positionsOfWord;
//    }
//
//    public static ArrayList<int[]>  isWordMatchDiagonalBottomLeftStart(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
//        ArrayList<int[]> positionsOfWord = new ArrayList<>();
//        if (row - wordToFind.size() >= -1 && column + wordToFind.size() <= boardGame[0].length) {
//            boolean match = true;
//            for (int i = 0; i < wordToFind.size(); i++) {
//                if (boardGame[row - i][column + i] != wordToFind.get(i)) {
//                    match = false;
//                    break;
//                } else {
//                    positionsOfWord.add(new int[]{row - i, column + i});
//                }
//            }
//        }
//        return positionsOfWord;
//    }
//
//    public static ArrayList<int[]>  isWordMatchDiagonalTopRightStart(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
//        ArrayList<int[]> positionsOfWord = new ArrayList<>();
//        if (row + wordToFind.size() <= boardGame.length && column - wordToFind.size() >= -1) {
//            boolean match = true;
//            for (int i = 0; i < wordToFind.size(); i++) {
//                if (boardGame[row + i][column - i] != wordToFind.get(i)) {
//                    match = false;
//                    break;
//                } else {
//                    positionsOfWord.add(new int[]{row + i, column - i});
//                }
//            }
//        }
//        return positionsOfWord;
//    }
//
//    public static ArrayList<int[]>  isWordMatchDiagonalBottomRightStart(char[][] boardGame, ArrayList<Character> wordToFind, int row, int column) {
//        ArrayList<int[]> positionsOfWord = new ArrayList<>();
//        if (row - wordToFind.size() >= -1 && column - wordToFind.size() >= -1) {
//            boolean match = true;
//            for (int i = 0; i < wordToFind.size(); i++) {
//                if (boardGame[row - i][column - i] != wordToFind.get(i)) {
//                    match = false;
//                    break;
//                } else {
//                    positionsOfWord.add(new int[]{row - i, column - i});
//                }
//            }
//        }
//        return positionsOfWord;
//    }
//}
//
