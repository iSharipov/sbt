package com.isharipov.homework5_3.exceptions.pinvalidator;

/**
 * Created by Илья on 04.08.2016.
 */
public class AccountIsLockedException extends PinValidatorException {
    public AccountIsLockedException(String message) {
        super(message);
    }
}
