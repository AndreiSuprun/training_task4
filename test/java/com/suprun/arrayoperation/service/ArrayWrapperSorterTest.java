package com.suprun.arrayoperation.service;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayWrapperSorterTest {

    private ArrayWrapperSorter sorter;

    @BeforeClass
    public void beforeClass() {
        sorter = new ArrayWrapperSorter();
    }

    @DataProvider
    public static Object[][] sortEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4}), true,
                new ArrayWrapper(new int[]{1, 2, 3, 4, 5, 7})},
                {new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4}), false,
                        new ArrayWrapper(new int[]{7, 5, 4, 3, 2, 1})}};
    }

    @Test(dataProvider = "sortEquals")
    public void testBubbleSortEquals(ArrayWrapper arrayWrapper, boolean asc, ArrayWrapper expectedResult)
            throws ValidationException {
        sorter.bubbleSort(arrayWrapper, asc);
        assertEquals(expectedResult, arrayWrapper);
    }

    @DataProvider
    public static Object[][] sortNotEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4}), true,
                new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4})},
                {new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4}), false,
                        new ArrayWrapper(new int[]{3, 1, 5, 7, 2, 4})}};
    }

    @Test(dataProvider = "sortNotEquals")
    public void testBubbleSortNotEquals(ArrayWrapper arrayWrapper, boolean asc, ArrayWrapper expectedResult)
            throws ValidationException {
        sorter.bubbleSort(arrayWrapper, asc);
        assertNotEquals(expectedResult, arrayWrapper);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testBubbleSortException() throws ValidationException {
        sorter.bubbleSort(null, true);;
    }

    @Test(dataProvider = "sortEquals")
    public void testInsertionSortEquals(ArrayWrapper arrayWrapper, boolean asc, ArrayWrapper expectedResult)
            throws ValidationException {
        sorter.insertionSort(arrayWrapper, asc);
        assertEquals(expectedResult, arrayWrapper);
    }

    @Test(dataProvider = "sortNotEquals")
    public void testInsertionSortNotEquals(ArrayWrapper arrayWrapper, boolean asc, ArrayWrapper expectedResult)
            throws ValidationException {
        sorter.insertionSort(arrayWrapper, asc);
        assertNotEquals(expectedResult, arrayWrapper);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testInsertionSortException() throws ValidationException {
        sorter.insertionSort(null, true);;
    }

    @Test(dataProvider = "sortEquals")
    public void testQuickSortEquals(ArrayWrapper arrayWrapper, boolean asc, ArrayWrapper expectedResult)
            throws ValidationException {
        sorter.quickSort(arrayWrapper, asc);
        assertEquals(expectedResult, arrayWrapper);
    }

    @Test(dataProvider = "sortNotEquals")
    public void testQuickSortNotEquals(ArrayWrapper arrayWrapper, boolean asc, ArrayWrapper expectedResult)
            throws ValidationException {
        sorter.quickSort(arrayWrapper, asc);
        assertNotEquals(expectedResult, arrayWrapper);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testQuickSortException() throws ValidationException {
        sorter.quickSort(null, true);;
    }

    @AfterClass
    public void afterClass() {
        sorter = null;
    }
}