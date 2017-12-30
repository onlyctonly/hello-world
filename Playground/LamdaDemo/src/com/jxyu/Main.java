package com.jxyu;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("hello from thread")).start();

        List<Employee> list = new ArrayList<>();

        Employee jiajia = new Employee("jiajia", 20);
        Employee xinhe = new Employee("xinhe", 50);
        Employee lele = new Employee("lele", 1);
        list.add(jiajia);
        list.add(xinhe);
        list.add(lele);

        list.forEach(employee -> System.out.println(employee));

        Collections.sort(list, (e1, e2)->e1.getName().compareTo(e2.getName()));
        System.out.println("\nbelow is sorted list by name\n");
        list.forEach(employee -> System.out.println(employee));

        System.out.println("\nbelow is sorted list by age\n");

        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getAge() > o2.getAge()) return 1;
                else if (o1.getAge() == o2.getAge()) {
                    return 0;
                }
                return -1;
            }
        });

        list.forEach(employee -> System.out.println(employee));

        Upperconcat uc = ((s1, s2) -> s1 + s2);

        String r = dostringstaff(uc, list.get(0).getName(), list.get(1).getName());
        System.out.println(r);

    }

    public final static String dostringstaff(Upperconcat uc, String s1, String s2) {
        return uc.uc(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name " + this.getName()+", Age: " + this.getAge();
    }
}

interface Upperconcat {
    String uc(String s1, String s2);

}