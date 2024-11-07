package org.example.Exercicio1;

public class Exercicio1_3 {

    public static boolean exercicio1_3(int[][] array){
        int totalColumns = array.length;
        boolean isNotRectAndSquare = false;
        for (int i = 0; i < totalColumns; i++) {
            if (totalColumns != array[i].length && isColumnsDifferent(array, array[i])) {
                isNotRectAndSquare = true;
            } else {
                isNotRectAndSquare = false;
            }
        }
        return isNotRectAndSquare;
    }


    public static boolean isColumnsDifferent(int[][] array, int[] row){
        for (int i = 0; i < array.length; i++) {
            if (row.length != array[i].length) {
                return true;
            }
        }
        return false;
    }
}
