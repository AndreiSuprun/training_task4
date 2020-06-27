package com.suprun.arrayoperation.service;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.BiPredicate;

import static org.testng.Assert.*;

public class ArrayWrapperOperatorTest {

    private ArrayWrapperOperator operator;

    @BeforeClass
    public void beforeClass() {
        operator = new ArrayWrapperOperator();
    }

    @DataProvider
    public static Object[][] findExtremumEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4}), new ArrayWrapperOperator().maxElement, 7},
                {new ArrayWrapper(new int[]{3, 9, 5, 7, 9, 4}), new ArrayWrapperOperator().minElement, 3}};
    }

    @Test(dataProvider = "findExtremumEquals")
    public void testFindExtremumEquals(ArrayWrapper arrayWrapper, BiPredicate<Integer, Integer> predicate, int expectedResult) throws ValidationException {
        int actual = operator.findExtremum(arrayWrapper, predicate);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] findExtremumNotEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4}), new ArrayWrapperOperator().maxElement, 2},
                {new ArrayWrapper(new int[]{3, 9, 5, 7, 9, 4}), new ArrayWrapperOperator().minElement, 5}};
    }

    @Test(dataProvider = "findExtremumNotEquals")
    public void testFindExtremumNotEquals(ArrayWrapper arrayWrapper, BiPredicate<Integer, Integer> predicate, int expectedResult) throws ValidationException {
        int actual = operator.findExtremum(arrayWrapper, predicate);
        assertNotEquals(expectedResult, actual);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testFindExtremumExceptionArray() throws ValidationException {
        int actual = operator.findExtremum(null, operator.maxElement);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testFindExtremumExceptionPredicate() throws ValidationException {
        int actual = operator.findExtremum(new ArrayWrapper(new int[]{3, 9, 5, 7, 9, 4}), null);
    }

    @DataProvider
    public static Object[][] maxElementEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4}), 7},
                {new ArrayWrapper(new int[]{3, 9, 5, 7, 9, 4}), 9}};
    }

    @Test(dataProvider = "maxElementEquals")
    public void testMaxElementEquals(ArrayWrapper arrayWrapper, int expectedResult) throws ValidationException {
        int actual = operator.maxElement(arrayWrapper);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] maxElementNotEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4}), 1},
                {new ArrayWrapper(new int[]{3, 9, 5, 7, 9, 4}), 3}};
    }

    @Test(dataProvider = "maxElementNotEquals")
    public void testMaxElementNotEquals(ArrayWrapper arrayWrapper, int expectedResult) throws ValidationException {
        int actual = operator.maxElement(arrayWrapper);
        assertNotEquals(expectedResult, actual);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testMaxElementException() throws ValidationException {
        int actual = operator.maxElement(null);
    }

    @DataProvider
    public static Object[][] minElementEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4}), 1},
                {new ArrayWrapper(new int[]{3, 9, 5, 7, 9, 4}), 3}};
    }

    @Test(dataProvider = "minElementEquals")
    public void testMinElementEquals(ArrayWrapper arrayWrapper, int expectedResult) throws ValidationException {
        int actual = operator.minElement(arrayWrapper);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] minElementNotEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4}), 5},
                {new ArrayWrapper(new int[]{3, 9, 5, 7, 9, 4}), 7}};
    }

    @Test(dataProvider = "minElementNotEquals")
    public void testMinElementNotEquals(ArrayWrapper arrayWrapper, int expectedResult) throws ValidationException {
        int actual = operator.minElement(arrayWrapper);
        assertNotEquals(expectedResult, actual);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testMinElementException() throws ValidationException {
        int actual = operator.minElement(null);
    }

    @DataProvider
    public static Object[][] sumElementEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4}), 22},
                {new ArrayWrapper(new int[]{3, 9, 5, 7, 9, 4}), 37}};
    }

    @Test(dataProvider = "sumElementEquals")
    public void testSumElementEquals(ArrayWrapper arrayWrapper, int expectedResult) throws ValidationException {
        int actual = operator.sumElement(arrayWrapper);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] sumElementNotEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4}), 25},
                {new ArrayWrapper(new int[]{3, 9, 5, 7, 9, 4}), 32}};
    }

    @Test(dataProvider = "sumElementNotEquals")
    public void testSumElementNotEquals(ArrayWrapper arrayWrapper, int expectedResult) throws ValidationException {
        int actual = operator.sumElement(arrayWrapper);
        assertNotEquals(expectedResult, actual);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testSumElementException() throws ValidationException {
        int actual = operator.sumElement(null);
    }

    @DataProvider
    public static Object[][] findPrimeNumbersEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4, 9, 12, 11}),
                new int[]{3, 5, 7, 2, 11}}};
    }

    @Test(dataProvider = "findPrimeNumbersEquals")
    public void testFindPrimeNumbersEquals(ArrayWrapper arrayWrapper, int[] expectedResult)
            throws ValidationException {
        int[] actual = operator.findPrimeNumbers(arrayWrapper);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] findPrimeNumbersNotEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4, 9, 12, 11}),
                new int[]{1, 4, 12}}};
    }

    @Test(dataProvider = "findPrimeNumbersNotEquals")
    public void testFindPrimeNumbersNotEquals(ArrayWrapper arrayWrapper, int[] expectedResult)
            throws ValidationException {
        int[] actual = operator.findPrimeNumbers(arrayWrapper);
        assertNotEquals(expectedResult, actual);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testFindPrimeNumbersException() throws ValidationException {
        int[] actual = operator.findPrimeNumbers(null);
    }

    @DataProvider
    public static Object[][] findFibonacciNumbersEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4, 9, 13, 11}),
                new int[]{3, 1, 5, 2, 13}}};
    }

    @Test(dataProvider = "findFibonacciNumbersEquals")
    public void testFindFibonacciNumbersEquals(ArrayWrapper arrayWrapper, int[] expectedResult)
            throws ValidationException {
        int[] actual = operator.findFibonacciNumbers(arrayWrapper);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] findFibonacciNumbersNotEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4, 9, 13, 11}), new int[]{3, 4, 9, 12}}};
    }

    @Test(dataProvider = "findFibonacciNumbersNotEquals")
    public void testFindFibonacciNumbersNotEquals(ArrayWrapper arrayWrapper, int[] expectedResult)
            throws ValidationException {
        int[] actual = operator.findFibonacciNumbers(arrayWrapper);
        assertNotEquals(expectedResult, actual);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testFindFibonacciNumbersException() throws ValidationException {
        int[] actual = operator.findFibonacciNumbers(null);
    }

    @DataProvider
    public static Object[][] findNonRepeatedDigitsEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 123, 344, 8787, 735, 89, 821, 13, 11}),
                new int[]{123, 735, 821}}};
    }

    @Test(dataProvider = "findNonRepeatedDigitsEquals")
    public void testFindNonRepeatedDigitsEquals(ArrayWrapper arrayWrapper, int[] expectedResult)
            throws ValidationException {
        int[] actual = operator.findNonRepeatableDigits(arrayWrapper);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] findNonRepeatedDigitsNotEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 123, 344, 8787, 735, 89, 821, 13, 11}),
                new int[]{3, 344, 8787}}};
    }

    @Test(dataProvider = "findNonRepeatedDigitsNotEquals")
    public void testFindNonRepeatedDigitsNotEquals(ArrayWrapper arrayWrapper, int[] expectedResult)
            throws ValidationException {
        int[] actual = operator.findNonRepeatableDigits(arrayWrapper);
        assertNotEquals(expectedResult, actual);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testFindNonRepeatedDigitsException() throws ValidationException {
        int[] actual = operator.findNonRepeatableDigits(null);
    }

    @AfterClass
    public void afterClass() {
        operator = null;
    }
}