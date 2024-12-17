package org.example.lesson_13.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelephoneBook {

    private final HashMap<String, List<String>> userNumber = new HashMap<>();

    public void add(String lastName, String phone) {
        userNumber.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phone);
    }

    public void get(String lastName) {
        System.out.println(userNumber.get(lastName));
    }

}