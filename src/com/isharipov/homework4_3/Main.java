package com.isharipov.homework4_3;

/**
 * Created by user007 on 23.07.2016.
 */
public class Main {

    public static void main(String[] args) {
        CounterMap<String> counterMap = new CounterMapImpl<>();
        counterMap.add("Hello");
        counterMap.add("Hello");
        counterMap.add("Hello");
        counterMap.add("Hello");
        counterMap.add("World");
        System.out.println(counterMap.size());
        System.out.println(counterMap.getCount("Hello"));
        System.out.println(counterMap.remove("Hello"));
        System.out.println(counterMap.size());
    }
}
