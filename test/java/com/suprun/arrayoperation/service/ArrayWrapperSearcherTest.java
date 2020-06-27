package com.suprun.arrayoperation.service;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayWrapperSearcherTest {

    private ArrayWrapperSearcher searcher;

    @BeforeClass
    public void beforeClass() {
        searcher = new ArrayWrapperSearcher();
    }

    @DataProvider
    public static Object[][] searchEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{1, 2, 3, 4, 5, 7}), 4, 3},
                {new ArrayWrapper(new int[]{7, 5, 4, 3, 2, 1}), 5, 1},
                {new ArrayWrapper(new int[]{7, 5, 4, 3, 2, 1}), 6, -1}};
    }

    @Test(dataProvider = "searchEquals")
    public void testBinarySearchEquals(ArrayWrapper arrayWrapper, int searchItem, int expectedResult)
            throws ValidationException {
        int actual = searcher.binarySearch(arrayWrapper, searchItem);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] searchNotEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{1, 2, 3, 4, 5, 7}), 4, 2},
                {new ArrayWrapper(new int[]{7, 5, 4, 3, 2, 1}), 5, -1},
                {new ArrayWrapper(new int[]{7, 5, 4, 3, 2, 1}), 6, 0}};
    }

    @Test(dataProvider = "searchNotEquals")
    public void testBinarySearchNotEquals(ArrayWrapper arrayWrapper, int searchItem, int expectedResult)
            throws ValidationException {
        int actual = searcher.binarySearch(arrayWrapper, searchItem);
        assertNotEquals(expectedResult, actual);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testBubbleSortException() throws ValidationException {
        searcher.binarySearch(null, 5);
    }

    @DataProvider
    public static Object[][] isSorted() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{1, 2, 3, 4, 5, 7}), true},
                {new ArrayWrapper(new int[]{7, 5, 4, 3, 2, 1}), true},
                {new ArrayWrapper(new int[]{7, 7, 7, 7, 7, 7}), true},
                {new ArrayWrapper(new int[]{7, 5, 8, 3, 1, 9}), false}};
    }

    @Test(dataProvider = "isSorted")
    public void testIsSorted(ArrayWrapper arrayWrapper, boolean expectedResult)
            throws ValidationException {
        boolean actual = searcher.isSorted(arrayWrapper);
        assertEquals(expectedResult, actual);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testIsSortedException() throws ValidationException {
        boolean isSorted = searcher.isSorted(null);
    }

    @AfterClass
    public void afterClass() {
        searcher = null;
    }
}