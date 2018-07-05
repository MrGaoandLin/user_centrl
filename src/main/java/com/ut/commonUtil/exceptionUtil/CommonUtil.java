package com.ut.commonUtil.exceptionUtil;

import java.util.UUID;

public class CommonUtil {

    public static String getUUID() {

        String result = UUID.randomUUID().toString();
        return result.replaceAll("-", "");
    }
}
