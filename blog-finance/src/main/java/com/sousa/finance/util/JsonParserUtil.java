package com.sousa.finance.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonParserUtil {

    public static Object parser(Class clase, String body) throws JsonProcessingException {
        ObjectMapper objectMapper =  new ObjectMapper();
        Object object = objectMapper.readValue(body, clase);
        return object;
    }
}
