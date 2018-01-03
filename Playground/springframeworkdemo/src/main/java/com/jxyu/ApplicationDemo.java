package com.jxyu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = context.getBean("tennisCoach",Coach.class);
        System.out.println(theCoach.getdailyworkout());
        System.out.println(theCoach.getFortune());
        context.close();
    }
}
