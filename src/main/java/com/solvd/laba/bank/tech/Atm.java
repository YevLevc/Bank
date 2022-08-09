package com.solvd.laba.bank.tech;

import com.solvd.laba.bank.PersonalAccount;
import com.solvd.laba.bank.interfaces.AccountOperation;
import com.solvd.laba.bank.interfaces.CurrencyExchange;

import java.util.Scanner;

public class Atm extends Secure  implements CurrencyExchange, AccountOperation {

    public double refill(PersonalAccount account, double amount) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter pin:");
        int pin = scan.nextInt();
        if (pin== account.getPinCode()) {
            return account.getAccountState() + amount - amount*account.getAccountType().getPercent();
        }
        return 0;
    }
}
