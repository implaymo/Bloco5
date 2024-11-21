package org.example.Exercicio6;

public class VectorExercise6 {

    private int[] array;
    private int value;

    public VectorExercise6() {
        this.array = new int[]{};
    }

    public VectorExercise6(int[] array) {
        this.array = array;
    }


    public int[] addValue(int value) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = value;
        array = newArray;
        return array;
    }

    public int[] removeFirstValue() {
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            newArray[i] = array[i + 1];
        }
        array = newArray;
        return array;
    }

    public int getValue(int index) {
        return array[index];
    }

    
}
