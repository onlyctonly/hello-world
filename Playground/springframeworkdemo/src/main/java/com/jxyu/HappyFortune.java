package com.jxyu;

import org.springframework.stereotype.Component;

@Component
public class HappyFortune implements FortuneService {
    public String getFortune() {
        return "HappyDay!";
    }
}
