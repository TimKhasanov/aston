package org.example;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> i = new MyArrayList<>();
        i.add("1");
        i.add("2");
        i.add("3");
i.remove("2");

        System.out.println(i.toString());

    }
}