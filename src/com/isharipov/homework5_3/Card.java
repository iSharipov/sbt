package com.isharipov.homework5_3;

/**
 * Created by Илья on 04.08.2016.
 */
public class Card {
    private final String cardNumber;

    private final String pin;

    public Card(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }
}
