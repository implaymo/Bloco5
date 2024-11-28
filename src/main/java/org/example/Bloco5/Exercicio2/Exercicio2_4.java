package org.example.Bloco5.Exercicio2;

public class Exercicio2_4 {

    public static int productOfElements(int[][] array){
        if (Exercicio2_2.isArrayEmpty(array)){
            return -1;
        }

        int totalProduct = 1;
        for (int i = 0; i < array.length; i++) {
            totalProduct *= multiplicateLineNumbers(array[i]);
        }
        return  totalProduct;
    }

    public static int multiplicateLineNumbers(int[] array) {
        int mult = 1;
        for (int i = 0; i < array.length; i++) {
            mult *= array[i];
        }
        return mult;
    }
}
