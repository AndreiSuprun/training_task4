package com.suprun.arrayoperation.main;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.jaggedarray.JaggedArrayCreator;
import com.suprun.arrayoperation.service.JaggedArraySorter;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;

public class JaggedArrayMain {

    public static void main(String[] args) {
        try {
            JaggedArrayCreator jaggedArrayCreator = new JaggedArrayCreator();
            JaggedArraySorter jaggedArraySorter = new JaggedArraySorter();
            int[][] jaggedArray = jaggedArrayCreator.createJaggedArray();
            System.out.println("Jagged array after creation");
            for (int[] arrayWrapper : jaggedArray) {
                System.out.println((new ArrayWrapper(arrayWrapper)).toString());
            }
            jaggedArraySorter.bubbleSort(jaggedArray, true, jaggedArraySorter.maxFunction);
            System.out.println("Jagged array after sorting by max value in each row");
            for (int[] arrayWrapper : jaggedArray) {
                System.out.println((new ArrayWrapper(arrayWrapper)).toString());
            }
            jaggedArraySorter.bubbleSort(jaggedArray, true, jaggedArraySorter.minFunction);
            System.out.println("Jagged array after sorting by min value in each row");
            for (int[] arrayWrapper : jaggedArray) {
                System.out.println((new ArrayWrapper(arrayWrapper)).toString());
            }
            jaggedArraySorter.bubbleSort(jaggedArray, true, jaggedArraySorter.sumFunction);
            System.out.println("Jagged array after sorting by sum value of each row");
            for (int[] arrayWrapper : jaggedArray) {
                System.out.println((new ArrayWrapper(arrayWrapper)).toString());
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}