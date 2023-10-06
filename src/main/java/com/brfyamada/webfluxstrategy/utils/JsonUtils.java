package com.brfyamada.webfluxstrategy.utils;

import com.brfyamada.webfluxstrategy.exceptions.JsonConvertingException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;

public abstract class JsonUtils {

    private JsonUtils(){

    }

    @SneakyThrows
    public static String toStringJson(Object value){
        try{
            return getObjectMapper().writeValueAsString(value);
        } catch (Exception ex){
            throw new JsonConvertingException(ex);
        }
    }

    private static ObjectMapper getObjectMapper(){
        var mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        return mapper;
    }
}
