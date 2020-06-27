package com.suprun.arrayoperation.jaggedarray;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.service.ArrayWrapperFilling;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;

// class is used for creation sample jagged array
public class JaggedArrayCreator {

    public int[][] createJaggedArray() throws ValidationException {
        ArrayWrapperFilling arrayWrapperFilling = new ArrayWrapperFilling();
        int[][] jaggedArray = new int[3][];
        ArrayWrapper first = new ArrayWrapper(10);
        ArrayWrapper second = new ArrayWrapper(15);
        ArrayWrapper third = new ArrayWrapper(20);
        arrayWrapperFilling.fillWithRandomNumbers(first);
        arrayWrapperFilling.fillWithRandomNumbers(second);
        arrayWrapperFilling.fillFromFile(third, "f");
        jaggedArray[0] = first.getArray();
        jaggedArray[1] = second.getArray();
        jaggedArray[2] = third.getArray();
        return jaggedArray;
    }
}
