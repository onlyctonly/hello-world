package com.jxyu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Coach theCoach = context.getBean("tennisCoach",Coach.class);
        System.out.println(theCoach.getdailyworkout());
        System.out.println(theCoach.getFortune());
        context.close();
    }
}
