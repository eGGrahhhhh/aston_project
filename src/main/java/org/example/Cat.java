package org.example;

public class Cat extends Animal {
    private static int catCount = 0;
    static boolean satiety = false;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать так далеко.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public static int getCatCount() {
        return catCount;
    }

    public void eat(int amountFood) {
        if (bowlFood >= amountFood) {
            bowlFood -= amountFood;
            satiety = true;
        } else {
            satiety = false;
        }
    }

    public static void addFood(int amount) {
        bowlFood += amount;
    }
}
