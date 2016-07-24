package com.isharipov.homework2;

/**
 * Created by Илья on 24.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Person ivan = new Person(true, "Ivan");
        Person maria = new Person(false, "Maria");
        ivan.marry(maria);
        System.out.println("Ivan's spouse name: " + ivan.getSpouse().getName());
        System.out.println("Maria's spouse name: " + maria.getSpouse().getName());
        Person elena = new Person(false, "Elena");
        elena.marry(ivan);
        System.out.println("Ivan's spouse name after divorce with Maria and marry with Elena: " + ivan.getSpouse().getName());
        System.out.println("Maria's spouse name after divorce with Ivan: " + maria.getSpouse());
        System.out.println("Elena's spouse name after marry with Ivan: " + elena.getSpouse().getName());

        Person gayPerson1 = new Person(true, "Bob");
        Person gayPerson2 = new Person(true, "Roger");
        if (!gayPerson1.marry(gayPerson2)) {
            System.out.println("Gay marriages in Russia are prohibited");
        }
    }
}
