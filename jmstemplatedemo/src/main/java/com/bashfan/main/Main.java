package com.bashfan.main;

import com.bashfan.config.AppConfig;
import com.bashfan.producer.Producer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        annotationConfigApplicationContext.registerShutdownHook();
        Producer producer = annotationConfigApplicationContext.getBean(Producer.class);

        producer.send();
    }
}
