package com.isharipov.homework5_3;

import com.isharipov.homework5_3.exceptions.terminalserver.AccountProblemException;
import com.isharipov.homework5_3.exceptions.terminalserver.AmountMultipleException;
import com.isharipov.homework5_3.exceptions.terminalserver.InsufficientFundsException;

import java.util.Scanner;

/**
 * Created by Илья on 04.08.2016.
 */
public class Main {

    public static void main(String[] args) {
        Person person = new Person(new Card("432156789012", "1234"));
        Terminal terminal = new TerminalImpl();
        terminal.insertCard(person.getCard());
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите пин код: ");
        String pin = scanner.nextLine();
        while (!terminal.checkPin(pin)) {
            System.out.print("Введите пин код: ");
            pin = scanner.nextLine();
        }

        try {
            System.out.println(terminal.checkBalance());
        } catch (AccountProblemException e) {
            System.out.println(e.getMessage());
            System.exit(0);
            //После этого вынимаем карту и повторяем ввод
        }
        System.out.println("Введите сумму: ");
        String amount = scanner.nextLine();
        boolean isCorrectMoney = true;
        while (isCorrectMoney) {
            try {
                terminal.putMoney(amount);
                isCorrectMoney = false;
            } catch (AmountMultipleException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите сумму: ");
                amount = scanner.nextLine();
            }
        }

        System.out.println("Ваш баланс: " + terminal.checkBalance());

        System.out.println("Введите сумму для снятия: ");
        try {
            terminal.takeMoney(scanner.nextLine());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}