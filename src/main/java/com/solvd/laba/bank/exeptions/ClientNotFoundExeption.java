package com.solvd.laba.bank.exeptions;

public class ClientNotFoundExeption extends NullPointerException{
    public ClientNotFoundExeption() {
    }

    public ClientNotFoundExeption(String s) {
        super(s);
    }
}
