package com.solvd.laba.bank.tech;

import com.solvd.laba.bank.accounts.PersonalAccount;

import java.util.Scanner;

public class Atm extends Secure {

    public void accountOperation(PersonalAccount account, double income) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter pin:");
        int pin = scan.nextInt();
        if (pin== account.getPin()) {
            account.setAccountState(account.getAccountState() + income -
                    Math.abs(income*account.getAccountType().getPercent()));
        }
    }

}
