package com.suprun.arrayoperation.service;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.function.ThrowableFunction;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;

// class is used for jagged array sorting
public class JaggedArraySorter {

    ArrayWrapperOperator operator = new ArrayWrapperOperator();
    // function is used for summing element in row of jagged array
    public final ThrowableFunction<ArrayWrapper, Integer, ValidationException> sumFunction =
            operator::sumElement;
    // function is used for finding element with maximum value in row of jagged array
    public final ThrowableFunction<ArrayWrapper, Integer, ValidationException> maxFunction =
            operator::maxElement;
    // function is used for finding element with minimum value in row of jagged array
    public final ThrowableFunction<ArrayWrapper, Integer, ValidationException> minFunction =
            operator::minElement;

    // method for sorting jagged array
    public void bubbleSort(int[][] jaggedArray, boolean ascending,
                           ThrowableFunction<ArrayWrapper, Integer, ValidationException> function)
            throws ValidationException {
        if (jaggedArray == null || function == null) {
            throw new ValidationException("Invalid input parameters");
        }
        for (int j = 0; j < jaggedArray.length; j++) {
            for (int i = j + 1; i < jaggedArray.length; i++) {
                if (ascending ? (function.apply(new ArrayWrapper(jaggedArray[j]))) > (function.apply(new ArrayWrapper(jaggedArray[i]))) :
                        (function.apply(new ArrayWrapper(jaggedArray[j]))) < (function.apply(new ArrayWrapper(jaggedArray[i])))) {
                    swap(jaggedArray, i, j);
                }
            }
        }
    }

    // method for swapping arrays in jagged array
    private void swap(int[][] jaggedArray, int i, int j){
        int[] temp = jaggedArray[i];
        jaggedArray[i] = jaggedArray[j];
        jaggedArray[j] = temp;
    }
}