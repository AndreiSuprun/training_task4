package com.suprun.arrayoperation.reader;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.assertEquals;

public class CustomDataReaderTest {

    private CustomDataReader reader;

    @BeforeClass
    public void beforeClass() {
        reader = new CustomDataReader();
    }

    @DataProvider
    public static Object[][] defaultFileRead() {
        return new Object[][]{{"h", "55 356 46 44443 344 645 4365 5 ty 65 56 4356 345 6347 34 73 86 456 4545 " +
                "23577 3452 124256 73 47437 347 34 7347 437 34 678 656 9879867 87657 855656"+System.lineSeparator()}};
    }

    @Test(dataProvider = "defaultFileRead")
    public void testDefaultFileRead(String path, String expectedResult) {
        String actual = reader.fileRead(path);
        assertEquals(actual, expectedResult);
    }

    @Test
    public void testConsoleRead() {
        int expectedResult = 10;
        String input = Integer.toString(expectedResult);
        Scanner scanner = new Scanner(input);
        int actual = reader.consoleRead(scanner);
        assertEquals(actual, expectedResult);
    }

    @AfterClass
    public void afterClass() {
        reader = null;
    }
}