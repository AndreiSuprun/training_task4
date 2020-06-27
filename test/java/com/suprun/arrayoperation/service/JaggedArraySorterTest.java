package com.suprun.arrayoperation.service;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.function.ThrowableFunction;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class JaggedArraySorterTest {

    private JaggedArraySorter sorter;

    @BeforeClass
    public void beforeClass() {
        sorter = new JaggedArraySorter();
    }

    @DataProvider
    public static Object[][] sortEquals() {
        return new Object[][]{{new int[][] {new int[] {3, 1, 5, 7, 2, 4}, new int[]{7, 4, 5, 9, 2, 4, 11, 14},
                new int[]{9, 2, 5, 6, 2, 4, 5, 9}}, true, new JaggedArraySorter().sumFunction,
                new int[][] {new int[]{3, 1, 5, 7, 2, 4}, new int[]{9, 2, 5, 6, 2, 4, 5, 9},
                        new int[]{7, 4, 5, 9, 2, 4, 11, 14}}},
                {new int[][] {new int[]{3, 8, 5, 7, 6, 4}, new int[]{7, 4, 5, 9, 1, 4, 11, 14},
                new int[]{9, 2, 5, 6, 2, 4, 5, 9}}, true, new JaggedArraySorter().minFunction,
                new int[][] {new int[]{7, 4, 5, 9, 1, 4, 11, 14}, new int[]{9, 2, 5, 6, 2, 4, 5, 9},
                        new int[]{3, 8, 5, 7, 6, 4}}},
                {new int[][] {new int[]{3, 8, 5, 7, 15, 4}, new int[]{7, 4, 5, 9, 8, 4, 11, 10},
                new int[]{9, 2, 5, 6, 2, 12, 5, 9}}, true, new JaggedArraySorter().maxFunction,
                new int[][] {new int[]{7, 4, 5, 9, 8, 4, 11, 10}, new int[]{9, 2, 5, 6, 2, 12, 5, 9},
                        new int[]{3, 8, 5, 7, 15, 4}}}};
    }

    @Test(dataProvider = "sortEquals")
    public void testBubbleSortEquals(int[][] jaggedArray, boolean ascending,
                               ThrowableFunction<ArrayWrapper, Integer, ValidationException> function,
                               int[][] expectedResult) throws ValidationException {
        sorter.bubbleSort(jaggedArray, ascending, function);
        boolean isEquals = Arrays.deepEquals(expectedResult, jaggedArray);
        assertTrue(isEquals);
    }

    @DataProvider
    public static Object[][] sortNotEquals() {
        return new Object[][]{{new int[][] {new int[] {3, 40, 5, 7, 2, 4}, new int[]{7, 4, 5, 9, 2, 4, 11, 14},
                new int[]{9, 2, 5, 6, 2, 4, 5, 9}}, true, new JaggedArraySorter().sumFunction,
                new int[][] {new int[]{3, 40, 5, 7, 2, 4}, new int[]{9, 2, 5, 6, 2, 4, 5, 9},
                        new int[]{7, 4, 5, 9, 2, 4, 11, 14}}},
                {new int[][] {new int[]{3, 8, 5, 7, 6, 4}, new int[]{7, 4, 5, 9, 10, 4, 11, 14},
                        new int[]{9, 2, 5, 6, 2, 4, 5, 9}}, true, new JaggedArraySorter().minFunction,
                        new int[][] {new int[]{7, 4, 5, 9, 10, 4, 11, 14}, new int[]{9, 2, 5, 6, 2, 4, 5, 9},
                                new int[]{3, 8, 5, 7, 6, 4}}},
                {new int[][] {new int[]{3, 8, 5, 7, 15, 4}, new int[]{7, 4, 5, 9, 8, 4, 16, 10},
                        new int[]{9, 2, 5, 6, 2, 12, 5, 9}}, true, new JaggedArraySorter().maxFunction,
                        new int[][] {new int[]{7, 4, 5, 9, 8, 4, 16, 10}, new int[]{9, 2, 5, 6, 2, 12, 5, 9},
                                new int[]{3, 8, 5, 7, 15, 4}}}};
    }

    @Test(dataProvider = "sortNotEquals")
    public void testBubbleSortNotEquals(int[][] jaggedArray, boolean ascending,
                                     ThrowableFunction<ArrayWrapper, Integer, ValidationException> function,
                                     int[][] expectedResult) throws ValidationException {
        sorter.bubbleSort(jaggedArray, ascending, function);
        boolean isEquals = Arrays.deepEquals(expectedResult, jaggedArray);
        assertFalse(isEquals);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testBubbleSortExceptionArray() throws ValidationException {
        sorter.bubbleSort(null, true, sorter.maxFunction);;
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testBubbleSortExceptionFunction() throws ValidationException {
        sorter.bubbleSort(new int[][] {new int[]{3, 8, 5, 7, 15, 4},
                new int[]{7, 4, 5, 9, 8, 4, 20, 10},
                new int[]{9, 2, 5, 6, 2, 12, 5, 9}}, true, null);
    }
}