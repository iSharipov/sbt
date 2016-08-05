package com.isharipov.homework5_3;

import com.isharipov.homework5_3.exceptions.terminalserver.AccountProblemException;
import com.isharipov.homework5_3.exceptions.terminalserver.InsufficientFundsException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Илья on 04.08.2016.
 */
public class TerminalServer {
    private final Map<String, String> account = new HashMap<>();

    private Card card;

    public TerminalServer() {
        account.put("432156789012", "1000");
        account.put("432156789013", "1000");
    }

    public String checkBalance() {
        if (account.containsKey(card.getCardNumber())) {
            return account.get(card.getCardNumber());
        } else {
            throw new AccountProblemException("Проблемы с картой, поворите запрос позже");
        }
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void putMoney(Double amount) {
        for (Map.Entry<String, String> entry : account.entrySet()) {
            if (entry.getKey().contains(card.getCardNumber())) {
                account.put(entry.getKey(), String.valueOf(Double.parseDouble(entry.getValue()) + amount));
            }
        }
    }

    public void takeMoney(Double amount) {
        for (Map.Entry<String, String> entry : account.entrySet()) {
            if (entry.getKey().contains(card.getCardNumber())) {
                if (Double.parseDouble(checkBalance()) > amount) {
                    account.put(entry.getKey(), String.valueOf(Double.parseDouble(entry.getValue()) - amount));
                } else {
                    throw new InsufficientFundsException("Недостаточно средств");
                }
            }
        }
    }
}
