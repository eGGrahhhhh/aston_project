package org.example.lesson_13.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arrayWords = {
                "сосулька", "маг", "жемчуг", "пакет", "фургон", "овод", "овод", "овод", "кино", "сахар",
                "жемчуг", "жатва", "жатва", "фургон", "жатва", "жатва", "маг", "овод", "жемчуг"
        };


        Set<String> mySet = new HashSet<>(Arrays.asList(arrayWords));
        Object[] arrayWordsNoDouble = mySet.toArray();
        HashMap<String, Integer> myMap = new HashMap<>();

        for (Object word : arrayWordsNoDouble) {
            int count = 0;
            for (String arrayWord : arrayWords) {
                if (word == arrayWord) {
                    count++;
                }
            }
            myMap.put((String) word, count);
        }

        System.out.println(mySet);
        System.out.println(myMap.entrySet());
    }
}