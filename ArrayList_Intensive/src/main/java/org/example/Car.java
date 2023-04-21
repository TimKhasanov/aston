package org.example;

public class Car implements Comparable<Car> {
        private final int id;
        private final String name;

        public int getId() {
            return id;
        }

        public Car(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Car " + "id=" + id + ", name='" + name + '\'' ;
        }


    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.id, o.getId());
    }
}

