package com.isharipov.homework5_3;

import com.isharipov.homework5_3.exceptions.pinvalidator.AccountIsLockedException;
import com.isharipov.homework5_3.exceptions.pinvalidator.IncorrectPinException;

import java.util.Date;

/**
 * Created by Илья on 04.08.2016.
 */
public class PinValidator {
    private static int counter = 3;
    private Date lockDate;
    private Card card;

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean checkPin(String userPin) {
        if (counter < 2) {
            if (lockDate == null) {
                lockDate = new Date(new Date().getTime() + 5000);
            }
            if ((lockDate.getTime() > new Date().getTime())) {
                throw new AccountIsLockedException("Аккаунт заблокирован на 5 секунд, до: " + lockDate);
            } else {
                lockDate = null;
                counter = 3;
            }
        } else {
            if (!userPin.equals(card.getPin())) {
                counter--;
                throw new IncorrectPinException("Введен некорректный пин код, попробуйте еще раз");
            } else {
                return true;
            }
        }
        return false;
    }
}
