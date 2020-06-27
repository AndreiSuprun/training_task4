package com.suprun.arrayoperation.wrapper;

import com.suprun.arrayoperation.exception.ValidationException;

public class ArrayWrapper {

    private final int[] array;
    // default value for array size
    private static final int DEFAULT_SIZE = 10;

    public ArrayWrapper() {
        this.array = new int[DEFAULT_SIZE];
    }

    public ArrayWrapper(int size) throws ValidationException {
        if (size < 1) {
            throw new ValidationException("Invalid size value");
        }
        this.array = new int[size];
    }

    public ArrayWrapper(int[] inputArray) throws ValidationException {
        if (inputArray == null) {
            throw new ValidationException("Null input value");
        }
        this.array = new int[inputArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = inputArray[i];
        }
    }

    public ArrayWrapper(int[] inputArray, int start, int end) throws ValidationException {
        if (inputArray == null || start < 0 || end < 0 || end - start <= 0) {
            throw new ValidationException("Invalid input value");
        }
        this.array = new int[end - start];
        for (int i = 0; i < array.length; i++) {
            array[i] = inputArray[start + i];
        }
    }

    public int[] getArray() {
        int[] outputArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            outputArray[i] = array[i];
        }
        return outputArray;
    }

    public int length() {
        return array.length;
    }

    // method for getting value for specified index
    public int getElement(int index) throws ValidationException {
        if (index < 0 || index > length() - 1) {
            throw new ValidationException("Invalid index");
        }
        return array[index];
    }

    // method for setting specified value for specified index
    public void setElement(int value, int index) throws ValidationException {
        if (index < 0 || index > length() - 1) {
            throw new ValidationException("Invalid index");
        }
        array[index] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayWrapper arrayWrapper = (ArrayWrapper) o;
        if (this.length() != arrayWrapper.length()) {
            return false;
        }
        int[] otherArray = arrayWrapper.getArray();
        for (int i = 0; i < this.length(); i++) {
            if (this.array[i] != otherArray[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (this.array == null) {
            return 0;
        }
        int hashCode = 1;
        for (int value : array) {
            hashCode = 31 * hashCode + value;
        }
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("ArrayWrapper {");
        stringBuilder.append("Array = ");
        for (int i = 0; i < length(); i++) {
            stringBuilder.append(array[i]);
            if (i < length() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}