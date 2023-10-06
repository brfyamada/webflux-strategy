package com.brfyamada.webfluxstrategy.exceptions;

public class JsonConvertingException extends RuntimeException{

    public JsonConvertingException(Throwable throwable){
        super("Falha ao converter json");
    }
}
