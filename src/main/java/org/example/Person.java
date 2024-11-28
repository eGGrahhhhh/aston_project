package org.example;

public class Person {

    private String fullName;
    private String position;
    private String email;
    private String number;
    private int salary;
    private int age;

    public Person(String fullName, String position, String email, String number, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Full Name: " + fullName);
        System.out.println("Position: " + position);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + number);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
    }
}
