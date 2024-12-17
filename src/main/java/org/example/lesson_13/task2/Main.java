package org.example.lesson_13.task2;

public class Main {
    public static void main(String[] args) {

        TelephoneBook myUsers = new TelephoneBook();

        myUsers.add("Иванов", "375(12)345-67-89");
        myUsers.add("Иванов", "375(33)333-44-55");
        myUsers.add("Иванов", "375(44)111-22-33");
        myUsers.add("Петров", "375(44)432-43-11");
        myUsers.add("Сидоров", "375(29)847-09-26");
        myUsers.get("Иванов");
        myUsers.get("Петров");
        myUsers.get("Сидоров");


    }
}
