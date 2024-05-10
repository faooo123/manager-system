package com.ebay.manager.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJSON(Object obj) throws Exception{
            return objectMapper.writeValueAsString(obj);
    }


    public static String toPrettyJSON(Object obj) throws Exception {
            return objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(obj);
    }

    public static <T> T toObject(String origin, Class<T> clazz) throws Exception{
            return objectMapper.readValue(origin, clazz);
    }
}
