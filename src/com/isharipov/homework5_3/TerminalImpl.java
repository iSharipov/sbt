package com.isharipov.homework5_3;

import com.isharipov.homework5_3.exceptions.pinvalidator.AccountIsLockedException;
import com.isharipov.homework5_3.exceptions.pinvalidator.IncorrectPinException;

/**
 * Created by Илья on 04.08.2016.
 */
public class TerminalImpl implements Terminal {
    //    private TerminalServer server;
    private PinValidator pinValidator = new PinValidator();

    @Override
    public boolean checkPin(String userPin) {
        try {
            return pinValidator.checkPin(userPin);
        } catch (AccountIsLockedException e) {
            System.out.println(e.getMessage());
            return false;

        } catch (IncorrectPinException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Double checkBalance(String cardNumber) {
        return null;
    }

    @Override
    public void registerCard(Card card) {
        pinValidator.setCard(card);
    }
}
