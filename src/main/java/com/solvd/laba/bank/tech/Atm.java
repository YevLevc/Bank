package com.solvd.laba.bank.tech;

import com.solvd.laba.bank.PersonalAccount;
import com.solvd.laba.bank.enums.AccountType;
import com.solvd.laba.bank.exeptions.BalanceException;
import com.solvd.laba.bank.exeptions.NegativeValueException;
import com.solvd.laba.bank.exeptions.PinCodeException;
import com.solvd.laba.bank.interfaces.IAccountOperation;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Atm extends Secure implements IAccountOperation {

    private static final Logger LOGGER = Logger.getLogger(Atm.class);

    public void process(PersonalAccount account) {
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        int choice = 0;
        while (choice == 0) {
            LOGGER.info("Choose operation:" +
                    "\n '1' - WITHDRAW (commission " + account.getAccountType().getPercent() +
                    ") | '2' - REFILL | '3' - ACCOUNT STATE | '9' - Turn Back");
            try {
                choice = scan.nextInt();
                if (choice == 9) return;
            } catch (InputMismatchException e) {
                LOGGER.error("Wrong input");
                scan.nextLine();
            }
        }
        while (sum == 0 && choice != 3) {
            LOGGER.info("Enter amount: ");
            try {
                sum = scan.nextInt();
                if (sum<0) throw new NegativeValueException("Please, enter non negative value!");
            } catch (InputMismatchException|NegativeValueException e) {
                if (e.getClass()==InputMismatchException.class) LOGGER.error("Please, enter proper input!");
                else LOGGER.error(e.getMessage());
                scan.nextLine();
                sum=0;
            }
        }
        switch (choice) {
            case 1:
                withdrawal(account, sum);
                LOGGER.info("Account state: " + account.getAccountState());
                break;
            case 2:
                refill(account, sum);
                LOGGER.info("Account state: " + account.getAccountState());
                break;
            case 3:
                LOGGER.info("Account state: " + account.getAccountState());
                break;
        }
    }

    public boolean pinChecked(PersonalAccount account) {
        Scanner scan = new Scanner(System.in);
        for (int i = 2; i >= 0; i--) {
            LOGGER.info("Please enter pin: ");
            int pin = scan.nextInt();
            if (pin != account.getPinCode()) {
                try {
                    throw new PinCodeException("Wrong pin");
                } catch (PinCodeException e) {
                    LOGGER.error(e.getMessage());
                    LOGGER.info("There last " + i + " try(es)");
                }
            } else {
                i = -1;
                return true;
            }
        }
        account.setAccountBlocked(true);
        LOGGER.warn("Your card is blocked!");
        LOGGER.info(account.isAccountBlocked());
        return false;
    }

    @Override
    public void refill(PersonalAccount account, double amount) {
        if (pinChecked(account)) account.setAccountState(account.getAccountState() + amount);
    }

    @Override
    public void withdrawal(PersonalAccount account, double amount) {
        try {
            if (pinChecked(account)) {
                if (account.getAccountState() < amount + amount * account.getAccountType().getPercent()
                        && account.getAccountType() == AccountType.CARD) throw new BalanceException("Insufficient funds!");
                else account.setAccountState(account.getAccountState() - amount
                        - amount * account.getAccountType().getPercent());
            }
            else throw new PinCodeException("Wrong pin");
        } catch (PinCodeException | BalanceException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
