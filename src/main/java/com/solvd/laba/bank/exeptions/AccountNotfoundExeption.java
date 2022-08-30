package com.solvd.laba.bank.exeptions;

public class AccountNotfoundExeption extends NullPointerException{
    public AccountNotfoundExeption() {
    }

    public AccountNotfoundExeption(String s) {
        super(s);
    }
}
