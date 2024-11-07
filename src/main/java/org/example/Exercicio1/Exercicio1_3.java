package org.example.Exercicio1;

public class Exercicio1_3 {

    public static boolean exercicio1_3(int[][] array){
        int totalColumns = array.length;
        for (int i = 0; i < totalColumns; i++) {
            if (isColumnsDifferent(array, array[i])) {
                return true;
            }
        }
        return false;
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
