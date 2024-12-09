package org.example;


public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Барсик"), new Cat("Лева"), new Cat("Кнопа")};
        Dog bobik = new Dog("Бобик");

        bobik.run(150);
        bobik.swim(5);
        cats[0].run(100);
        cats[1].swim(1);

        Cat.addFood(100);

        for (Cat cat : cats) {
            cat.eat(20);
        }

        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.satiety);
        }
    }
}




