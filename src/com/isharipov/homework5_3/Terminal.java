package com.isharipov.homework5_3;

/**
 * Created by Илья on 04.08.2016.
 */
public interface Terminal {
    boolean checkPin(String pin);

    String checkBalance();

    boolean putMoney(String amount);

    void insertCard(Card card);

    boolean takeMoney(String amount);
}
