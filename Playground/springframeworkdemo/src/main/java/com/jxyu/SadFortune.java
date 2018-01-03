package com.jxyu;

import org.springframework.stereotype.Component;

@Component
public class SadFortune implements FortuneService {
    public String getFortune() {
        return "it's raining!";
    }
}
