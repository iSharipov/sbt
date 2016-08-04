package com.isharipov.homework5_3;

import java.util.Scanner;

/**
 * Created by Илья on 04.08.2016.
 */
public class Main {

    public static void main(String[] args) {
        Person person = new Person(new Card("432156789012", "1234"));
        Terminal terminal = new TerminalImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите пин код: ");
        String pin = scanner.nextLine();
        while (!terminal.checkPin(pin)) {
            System.out.print("Введите пин код: ");
            pin = scanner.nextLine();
        }
    }
}
