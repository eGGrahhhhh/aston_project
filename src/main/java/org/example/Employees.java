package org.example;


public class Employees {
    public static void main(String[] args) {
        Person[] personsArray = new Person[5];

        personsArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@gmail.com", "802312312", 30000, 30);
        personsArray[1] = new Person("Egorov Egor", "QA Java", "egor123@gmail.com", "802234456", 30000, 23);
        personsArray[2] = new Person("Andreev Andrey", "QA manual", "andrey123@gmail.com", "807895834", 20000, 25);
        personsArray[3] = new Person("Pavlov Pavel", "DevOps", "papavel@gmail.com", "802345678", 30000, 29);
        personsArray[4] = new Person("Osipenko Anna", "PM", "osipanna@gmail.com", "802392812", 20000, 24);

        for (Person person : personsArray) {
            person.printInfo();
            System.out.println();
        }

    }

}




