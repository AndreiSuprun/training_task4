package com.suprun.arrayoperation.service;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

// class is used for performing different operation on ArrayWrapper
public class ArrayWrapperOperator {

    // predicate for checking if number is prime
    public final Predicate<Integer> isPrime = this::isPrimeNumber;
    // predicate for checking if number is fibonacci
    public final Predicate<Integer> isFibonacci = this::isFibonacciNumber;
    // predicate for checking if number has three non repeatable digit
    public final Predicate<Integer> isNonRepeatableDigit = this::isNonRepeatableDigitNumber;
    //predicate for finding minimum value in in ArrayWrapper
    public final BiPredicate<Integer, Integer> minElement = (a, b) -> a < b;
    //predicate for finding maximum value in in ArrayWrapper
    public final BiPredicate<Integer, Integer> maxElement = (a, b) -> a > b;

    // method for finding extremum value (minimum, maximum) in ArrayWrapper
    public int findExtremum(ArrayWrapper arrayWrapper, BiPredicate<Integer, Integer> predicate) throws ValidationException {
        if (arrayWrapper == null || predicate == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        int extremum = arrayWrapper.getElement(0);
        for (int i = 1; i < arrayWrapper.length(); i++) {
            if (predicate.test(arrayWrapper.getElement(i), extremum)) {
                extremum = arrayWrapper.getElement(i);
            }
        }
        return extremum;
    }

    // method for finding maximum value in ArrayWrapper
    public int maxElement(ArrayWrapper arrayWrapper) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        int max = arrayWrapper.getElement(0);
        for (int i = 1; i < arrayWrapper.length(); i++) {
            if (arrayWrapper.getElement(i) > max) {
                max = arrayWrapper.getElement(i);
            }
        }
        return max;
    }

    // method for finding minimum value in ArrayWrapper
    public int minElement(ArrayWrapper arrayWrapper) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        int min = arrayWrapper.getElement(0);
        for (int i = 1; i < arrayWrapper.length(); i++) {
            if (arrayWrapper.getElement(i) < min) {
                min = arrayWrapper.getElement(i);
            }
        }
        return min;
    }

    // method for finding sum of values in ArrayWrapper
    public int sumElement(ArrayWrapper arrayWrapper) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        int[] array = arrayWrapper.getArray();
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    // method for finding prime numbers in ArrayWrapper
    public int[] findPrimeNumbers(ArrayWrapper arrayWrapper) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        int[] outputArray = new int[arrayWrapper.length()];
        int counter = 0;
        for (int i = 0; i< arrayWrapper.length(); i++) {
            if (isPrimeNumber(arrayWrapper.getElement(i))) {
                outputArray[counter] = arrayWrapper.getElement(i);
                counter++;
            }
        }
        return trimArray(outputArray, counter);
    }

    // method for finding fibonacci numbers in ArrayWrapper
    public int[] findFibonacciNumbers(ArrayWrapper arrayWrapper) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        int[] outputArray = new int[arrayWrapper.length()];
        int counter = 0;
        for (int i = 0; i< arrayWrapper.length(); i++) {
            if (isFibonacciNumber(arrayWrapper.getElement(i))) {
                outputArray[counter] = arrayWrapper.getElement(i);
                counter++;
            }
        }
        return trimArray(outputArray, counter);
    }

    // method for finding numbers containing three non repeatable digit in ArrayWrapper
    public int[] findNonRepeatableDigits(ArrayWrapper arrayWrapper) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        int[] outputArray = new int[arrayWrapper.getArray().length];
        int counter = 0;
        for (int i=0; i< arrayWrapper.length(); i++) {
            if (isNonRepeatableDigitNumber(arrayWrapper.getElement(i))) {
                outputArray[counter] = arrayWrapper.getElement(i);
                counter++;
            }
        }
        return trimArray(outputArray, counter);
    }

    // method for finding numbers (prime, fibonacci, with repeatable digits) in ArrayWrapper
    // according to specified predicate
    public int[] findWithPredicate(ArrayWrapper arrayWrapper, Predicate<Integer> predicate)
            throws ValidationException {
        if (arrayWrapper == null || predicate == null) {
            throw new ValidationException("Null input parameter");
        }
        int[] outputArray = new int[arrayWrapper.getArray().length];
        int counter = 0;
        for (int i=0; i< arrayWrapper.length(); i++) {
            if (predicate.test(arrayWrapper.getElement(i))) {
                outputArray[counter] = arrayWrapper.getElement(i);
                counter++;
            }
        }
        return trimArray(outputArray, counter);
    }

    // method for trimming zero values in the end of array
    private int[] trimArray(int[] array, int count) {
        int[] trimmedArray = new int[count];
        for (int i = 0; i < count; i++){
            trimmedArray[i] = array[i];
        }
        return trimmedArray;
    }

    // method for checking if number is prime
    private boolean isPrimeNumber(int input) {
        if (input <= 1) {
            return false;
        }
        if (input == 2) {
            return true;
        }
        for (int i = 2; i < input; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }

    // method for checking if number is fibonacci
    private boolean isFibonacciNumber(int input) {
        int first = 0;
        int second = 1;
        int third = 0;
        while (third < input) {
            third = first + second;
            first = second;
            second = third;
        }
        return third == input;
    }

    // method for checking if number has three non repeatable digit
    private boolean isNonRepeatableDigitNumber(int input) {
        if (input < 100 || input > 999) {
            return false;
        }
        int firstDigit = input / 100;
        int secondDigit = (input - firstDigit * 100) / 10;
        int thirdDigit = input % 10;
        return firstDigit != secondDigit && firstDigit != thirdDigit && secondDigit != thirdDigit;
    }
}