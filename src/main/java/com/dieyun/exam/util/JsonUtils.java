package com.dieyun.exam.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author yuchao
 * @date 2017/7/11
 * @desc：
 */
public class JsonUtils {
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * object to json string
     */
    public static String toJSONString(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    /**
     * json string to object
     */
    public static <T> T parse(String text, Class<T> clazz) throws IOException {
        return mapper.readValue(text, clazz);
    }

    /**
     * json string to map
     */
    public static Map<String, Object> parseMap(String text) throws IOException {
        return mapper.readValue(text, new TypeReference<Map<String, Object>>() {
        });
    }

    /**
     * json string to list
     */
    public static List<Object> parseArray(String text) throws IOException {
        return mapper.readValue(text, new TypeReference<List<Object>>() {
        });
    }

    private JsonUtils() {
    }
}
