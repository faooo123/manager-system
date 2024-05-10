package com.ebay.manager.utils;

import java.util.Base64;

public class Base64Util {

    public static String decode(String base64Str){
        byte[] bytes = Base64.getDecoder().decode(base64Str);
        return new String(bytes);
    }

    public static String encode(String content){
        return Base64.getEncoder().encodeToString(content.getBytes());
    }
}
