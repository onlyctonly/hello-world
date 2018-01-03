package com.jxyu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.jxyu")
@PropertySource("config.properties")
public class Config {
}
