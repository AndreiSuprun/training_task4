package com.suprun.arrayoperation.parser;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomParserTest {

    private CustomParser parser;

    @BeforeClass
    public void beforeClass() {
        parser = new CustomParser();
    }

    @DataProvider
    public static Object[][] parseToArrayWrapper() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(10), "55 356 46 44443 344 645 4365 5 ty 65 56 4356 345",
                new ArrayWrapper(new int[]{55, 356, 46, 44443, 344, 645, 4365, 5, 65, 56})}};
    }
    @Test(dataProvider = "parseToArrayWrapper")
    public void testParseToArrayWrapperEquals(ArrayWrapper arrayWrapper, String input, ArrayWrapper expectedResult) throws ValidationException {
        parser.parseToArrayWrapper(arrayWrapper, input);
        assertEquals(arrayWrapper,expectedResult);
    }

    @DataProvider
    public static Object[][] parseToArrayWrapperNotEquals() throws ValidationException {
        return new Object[][]{{new ArrayWrapper(10), "55 356 46 44443 344 645 4365 5 ty 65 56 4356 345",
                new ArrayWrapper(new int[]{55, 356, 46, 4443, 344, 645, 465, 5, 0, 56})}};
    }
    @Test(dataProvider = "parseToArrayWrapperNotEquals")
    public void testParseToArrayWrapperNotEquals(ArrayWrapper arrayWrapper, String input, ArrayWrapper expectedResult) throws ValidationException {
        parser.parseToArrayWrapper(arrayWrapper, input);
        assertNotEquals(arrayWrapper,expectedResult);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testParseToArrayWrapperExceptionArray() throws ValidationException {
        parser.parseToArrayWrapper(null, "34 234 234 234");
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testParseToArrayWrapperExceptionData() throws ValidationException {
        parser.parseToArrayWrapper(new ArrayWrapper(new int[]{55, 356, 46, 44443, 344, 5, 65, 56}), null);
    }

    @AfterClass
    public void afterClass() {
        parser = null;
    }
}