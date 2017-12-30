package com.jxyu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PrintCompare {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        Employee jiajia = new Employee("jiajia", 20);
        Employee xinhe = new Employee("xinhe", 50);
        Employee lele = new Employee("lele", 1);
        list.add(jiajia);
        list.add(xinhe);
        list.add(lele);

        printMyList(list, new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge()<20;
            }
        });

        IntPredicate intp = i->i>15;
        IntPredicate intp2 = i->i<100;
        System.out.println(intp.test(20));
        System.out.println(intp2.and(intp).test(50));
        System.out.println(intp2.and(intp).test(100 ));

    }

    public static void printMyList (List<Employee> list, Predicate<Employee> predicate) {
        for (Employee e : list) {
            if (predicate.test(e)) {
                System.out.println(e);
            }
        }
    }
}


