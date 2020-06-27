package com.suprun.arrayoperation.parser;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;

// class is used for parsing string with data to ArrayWrapper
public class CustomParser {

    // method is used for parsing string data to ArrayWrapper
    public void parseToArrayWrapper(ArrayWrapper arrayWrapper, String inputData) throws ValidationException {
        if (arrayWrapper == null || inputData == null) {
            throw new ValidationException("Invalid input parameter");
        }
        String[] splits = inputData.split("\\s+");
        int index = 0;
        int counter = 0;
        while (index < splits.length - 1 && counter < arrayWrapper.length()) {
            try {
                int value = Integer.parseInt(splits[index++]);
                arrayWrapper.setElement(value, counter);
                counter++;
            } catch (NumberFormatException e) {
                System.out.println("Skip incorrect data from file");
            }
        }
    }
}
