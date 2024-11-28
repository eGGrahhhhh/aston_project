package org.example;

public class Park {

    private class Attraction {
        private String nameAttraction;
        private String workingTime;
        private int price;

        public Attraction(String nameAttraction, String workingTime, int price) {
            this.nameAttraction = nameAttraction;
            this.workingTime = workingTime;
            this.price = price;
        }
    }
}
