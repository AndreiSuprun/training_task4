package com.suprun.arrayoperation.service;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;

// class is used for sorting ArrayWrapper
public class ArrayWrapperSorter {

    // method for bubble sort ArrayWrapper in both directions
    public void bubbleSort(ArrayWrapper arrayWrapper, boolean ascending) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        for (int j = 0; j < arrayWrapper.length(); j++) {
            for (int i = j + 1; i < arrayWrapper.length(); i++) {
                if (ascending ? (arrayWrapper.getElement(j) > arrayWrapper.getElement(i)) :
                        (arrayWrapper.getElement(j) < arrayWrapper.getElement(i))) {
                    swap(arrayWrapper, i, j);
                }
            }
        }
    }

    // method for insertion sort ArrayWrapper in both directions
    public void insertionSort(ArrayWrapper arrayWrapper, boolean ascending) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        for (int j = 0; j < arrayWrapper.length(); j++) {
            for (int i = j; i > 0 && i <= j; i--) {
                if (ascending ? arrayWrapper.getElement(i - 1) > arrayWrapper.getElement(i) :
                        arrayWrapper.getElement(i - 1) < arrayWrapper.getElement(i)) {
                    swap(arrayWrapper, i - 1, i);
                }
            }
        }
    }

    // method for quicksort ArrayWrapper in both directions
    public void quickSort(ArrayWrapper arrayWrapper, boolean ascending) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        quickSort(arrayWrapper, 0, arrayWrapper.length() - 1, ascending);
    }

    // additional method for quicksort ArrayWrapper in both directions
    private void quickSort(ArrayWrapper arrayWrapper, int low, int high, boolean ascending) throws ValidationException {
        if (low < high) {
            int partIndex = arrayPartition(arrayWrapper, low, high, ascending);
            quickSort(arrayWrapper, low, partIndex - 1, ascending);
            quickSort(arrayWrapper, partIndex + 1, high, ascending);
        }
    }

    // additional method for quicksort ArrayWrapper in both directions
    private int arrayPartition(ArrayWrapper arrayWrapper, int low, int high, boolean ascending) throws ValidationException {
        int pivot = arrayWrapper.getElement(high);
        int j = low - 1;
        for (int i = low; i < high; i++) {
            if (ascending ? arrayWrapper.getElement(i) < pivot : arrayWrapper.getElement(i) > pivot) {
                j++;
                swap(arrayWrapper, i, j);
            }
        }
        swap(arrayWrapper, j + 1, high);
        return j + 1;
    }

    // method for swapping elements in ArrayWrapper
    private void swap(ArrayWrapper arrayWrapper, int i, int j) throws ValidationException {
        int temp = arrayWrapper.getElement(i);
        arrayWrapper.setElement(arrayWrapper.getElement(j), i);
        arrayWrapper.setElement(temp, j);
    }
}