package com.isharipov.homework5_3;

import com.isharipov.homework5_3.exceptions.pinvalidator.AccountIsLockedException;
import com.isharipov.homework5_3.exceptions.pinvalidator.IncorrectPinException;
import com.isharipov.homework5_3.exceptions.terminalserver.AmountMultipleException;

/**
 * Created by Илья on 04.08.2016.
 */
public class TerminalImpl implements Terminal {
    private TerminalServer server = new TerminalServer();
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
    public String checkBalance() {
        return server.checkBalance();
    }


    @Override
    public void insertCard(Card card) {
        server.setCard(card);
        pinValidator.setCard(card);
    }

    @Override
    public boolean putMoney(String amount) {
        if (Double.parseDouble(amount) % 100 == 0) {
            server.putMoney(Double.parseDouble(amount));
            return true;
        } else {
            throw new AmountMultipleException("Сумма не кратна 100, повторите ввод");
        }
    }

    @Override
    public boolean takeMoney(String amount) {
        if (Double.parseDouble(amount) % 100 == 0) {
            server.takeMoney(Double.parseDouble(amount));
            return true;
        } else {
            throw new AmountMultipleException("Сумма не кратна 100, повторите ввод");
        }
    }
}
