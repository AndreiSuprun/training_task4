package com.suprun.arrayoperation.service;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.reader.CustomDataReader;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.assertEquals;

public class ArrayWrapperFillingTest {

    private ArrayWrapperFilling filling;

    @BeforeClass
    public void beforeClass() {
        filling = new ArrayWrapperFilling();
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testFillWithRandomNumberException() throws ValidationException {
        filling.fillWithRandomNumbers(null);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testFillFromConsoleException() throws ValidationException {
        filling.fillFromConsole(null);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testFillFromFileExceptionArray() throws ValidationException {
        filling.fillFromFile(null, "file");
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testFillFromFileExceptionFile() throws ValidationException {
        filling.fillFromFile(new ArrayWrapper(new int[]{55, 356, 46, 44443, 344, 645, 5, 65, 56}), null);
    }

    @DataProvider
    public static Object[][] defaultFileRead() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(10), "h",
                new ArrayWrapper(new int[]{55, 356, 46, 44443, 344, 645, 4365, 5, 65, 56})}};
    }

    @Test(dataProvider = "defaultFileRead")
    public void testDefaultFileRead(ArrayWrapper arrayWrapper, String path, ArrayWrapper expectedResult)
            throws ValidationException {
        filling.fillFromFile(arrayWrapper, path);
        assertEquals(arrayWrapper, expectedResult);
    }

    @Test
    public void testReadFromConsole() throws ValidationException {
        String input = "55 356 46 44443 344 645 4365 5 ty 65 56 4356 345";
        Scanner scanner = new Scanner(input);
        ArrayWrapper actual = new ArrayWrapper(10);
        CustomDataReader reader = new CustomDataReader();
        for (int i=0; i < actual.length(); i++){
                actual.setElement(reader.consoleRead(scanner), i);
        }
        ArrayWrapper expectedResult = new ArrayWrapper(new int[]{55, 356, 46, 44443, 344, 645, 4365, 5, 65, 56});
        assertEquals(actual, expectedResult);
    }

    @AfterClass
    public void afterClass() {
        filling = null;
    }
}