package com.suprun.arrayoperation.service;

import com.suprun.arrayoperation.exception.ValidationException;
import com.suprun.arrayoperation.parser.CustomParser;
import com.suprun.arrayoperation.reader.CustomDataReader;
import com.suprun.arrayoperation.wrapper.ArrayWrapper;

import java.util.Random;
import java.util.Scanner;

// class is used for filling ArrayWrapper
public class ArrayWrapperFilling {

    // method for filling ArrayWrapper with random numbers
    public void fillWithRandomNumbers(ArrayWrapper arrayWrapper) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        Random random = new Random();
        for (int i = 0; i < arrayWrapper.length(); i++){
            arrayWrapper.setElement(random.nextInt(1000), i);
        }
    }

    // method for filling ArrayWrapper from console
    public void fillFromConsole(ArrayWrapper arrayWrapper) throws ValidationException {
        if (arrayWrapper == null) {
            throw new ValidationException("Null arrayWrapper parameter");
        }
        CustomDataReader reader = new CustomDataReader();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %d numbers for array values%n", arrayWrapper.length());
        for (int i = 0; i < arrayWrapper.length(); i++) {
            int value = reader.consoleRead(scanner);
            arrayWrapper.setElement(value, i);
        }
    }

    // method for filling ArrayWrapper from file data
    public void fillFromFile(ArrayWrapper arrayWrapper, String filePath) throws ValidationException {
        if (arrayWrapper == null || filePath == null) {
            throw new ValidationException("Invalid input parameter");
        }
        CustomDataReader reader = new CustomDataReader();
        CustomParser parser = new CustomParser();
        String data = reader.fileRead(filePath);
        if (data.isEmpty()) {
            System.out.println("WrappedArray is filled with random number generator");
            this.fillWithRandomNumbers(arrayWrapper);
            return;
        }
        parser.parseToArrayWrapper(arrayWrapper, data);
    }
}
