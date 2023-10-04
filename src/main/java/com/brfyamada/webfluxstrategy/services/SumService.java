package com.brfyamada.webfluxstrategy.services;

import org.springframework.stereotype.Service;

@Service
public class SumService {

    public int sum(int code){
        return code + 1;
    }
}
