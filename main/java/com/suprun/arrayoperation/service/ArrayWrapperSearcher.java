package com.suprun.arrayoperation.service;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;

// class is used for search in ArrayWrapper
public class ArrayWrapperSearcher {

    // method for binary search in ArrayWrapper
    public int binarySearch(ArrayWrapper arrayWrapper, int searchedItem) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        if (!isSorted(arrayWrapper)){
            throw new ValidationException("Input ArrayWrapper is not sorted");
        }
        return binarySearch(arrayWrapper, 0, arrayWrapper.length() - 1, searchedItem);
    }

    // method for definition if ArrayWrapper is sorted
    public boolean isSorted(ArrayWrapper arrayWrapper) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        boolean ascending = arrayWrapper.getElement(0) <= arrayWrapper.getElement(arrayWrapper.length()-1);
        for (int i = 0; i < arrayWrapper.length()-1; i++){
            if (ascending? arrayWrapper.getElement(i) > arrayWrapper.getElement(i+1) :
                    arrayWrapper.getElement(i) < arrayWrapper.getElement(i+1)){
                return false;
            }
        }
        return true;
    }

    // additional method for binary search in ArrayWrapper
    private int binarySearch(ArrayWrapper arrayWrapper, int low, int high, int searchedItem) throws ValidationException {
        if (low <= high){
            int middle = (low + high) / 2;
            int middleValue = arrayWrapper.getElement(middle);
            boolean ascending = arrayWrapper.getElement(low) <= arrayWrapper.getElement(high);
            if (middleValue == searchedItem) {
                return middle;
            } else if (middleValue > searchedItem) {
                return ascending ? binarySearch(arrayWrapper, low, middle - 1, searchedItem) :
                        binarySearch(arrayWrapper, middle + 1, high, searchedItem);
            } else {
                return ascending ? binarySearch(arrayWrapper, middle + 1, high, searchedItem) :
                        binarySearch(arrayWrapper, low, middle - 1, searchedItem);
            }
        }
        return -1;
    }
}
