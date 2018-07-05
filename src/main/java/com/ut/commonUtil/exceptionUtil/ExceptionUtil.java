package com.ut.commonUtil.exceptionUtil;

import javax.xml.bind.ValidationException;

public class ExceptionUtil {

    public static void runtimeException(String message) {
        throw new RuntimeException(message);
    }

    public static void validationException(String message){

        try {
            throw new ValidationException(message);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }
}
