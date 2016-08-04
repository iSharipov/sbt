package com.isharipov.homework5_3;

/**
 * Created by Илья on 04.08.2016.
 */
public interface Terminal {
    boolean checkPin(String pin);

    Double checkBalance(String cardNumber);

    void registerCard(Card card);
}
