package com.suprun.arrayoperation.main;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.service.ArrayWrapperFilling;
import com.suprun.arrayoperation.service.ArrayWrapperOperator;
import com.suprun.arrayoperation.service.ArrayWrapperSearcher;
import com.suprun.arrayoperation.service.ArrayWrapperSorter;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;

public class ArrayWrapperMain {

    public static void main(String[] args) {
        try {
            ArrayWrapper arrayWrapper = new ArrayWrapper(10);
            ArrayWrapperFilling filler = new ArrayWrapperFilling();
            ArrayWrapperSorter sorter = new ArrayWrapperSorter();
            ArrayWrapperOperator operator = new ArrayWrapperOperator();
            ArrayWrapperSearcher searcher = new ArrayWrapperSearcher();
            filler.fillWithRandomNumbers(arrayWrapper);
            System.out.printf("ArrayWrapper filled with random %s%n", arrayWrapper);
            filler.fillFromFile(arrayWrapper, "arrayWrapper");
            System.out.printf("ArrayWrapper filled from file %s%n", arrayWrapper);
            sorter.bubbleSort(arrayWrapper, true);
            System.out.printf("ArrayWrapper sorted ascending %s%n", arrayWrapper);
            sorter.bubbleSort(arrayWrapper, false);
            System.out.printf("ArrayWrapper sorted descending %s%n", arrayWrapper);
            int index = searcher.binarySearch(arrayWrapper, 25);
            System.out.printf("Binary search of value 25: element has index %d%n", index);
            int sum = operator.sumElement(arrayWrapper);
            System.out.printf("Sum of elements of ArrayWrapper is %d%n", sum);
            int[] prime = operator.findPrimeNumbers(arrayWrapper);
            System.out.printf("Found %d prime numbers%n", prime.length);
            for (int prim : prime) {
                System.out.printf("Prime number is %d%n", prim);
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}