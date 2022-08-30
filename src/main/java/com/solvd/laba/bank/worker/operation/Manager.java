package com.solvd.laba.bank.worker.operation;

import com.solvd.laba.bank.PersonalAccount;
import com.solvd.laba.bank.enums.AccountType;
import com.solvd.laba.bank.interfaces.IOpensAccount;
import com.solvd.laba.bank.service.Computer;
import com.solvd.laba.bank.worker.Worker;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager extends Worker implements IOpensAccount {

    public static final Logger LOGGER = Logger.getLogger(Manager.class);

    public Manager(int ID, String fullName, Object position, int salary) {
        super(ID, fullName, position, salary);
    }

    public Manager() {
    }

    public PersonalAccount openAccount (int num, String type, double state, boolean blocked, int pin) {
        return new PersonalAccount(num, AccountType.valueOf(type), state, blocked, pin);
    }
    @Override
    public PersonalAccount openAccount() {
        Scanner scan = new Scanner(System.in);
        int sum = -1;
        int type=0;
        while (type ==0) {
            LOGGER.info("Choose account type:" +
                    "\n '1' - CARD ("+AccountType.CARD.getPercent()*100+"%) | '2' - DEPOSIT("+AccountType.DEPOSIT.getPercent()*100+"%)" +
                    " | '3' - CREDIT("+AccountType.CREDIT.getPercent()*100+"%) | '9' - Turn Back");
            try {
                type = scan.nextInt();
                if (type==9) return null;
                if (type!=1&&type!=2&&type!=3) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                LOGGER.error("Wrong input");
                scan.nextLine();
                type=0;
            }
        }
        while (sum < 0) {
            LOGGER.info("Enter amount to put: ");
            try {
                sum = scan.nextInt();
            } catch (InputMismatchException e) {
                LOGGER.error("Wrong input");
            }
        }
        switch (type) {
            case 1:
                return new PersonalAccount(Computer.randomNum(), AccountType.CARD, sum, Computer.randomPin());
            case 2:
                return new PersonalAccount(Computer.randomNum(), AccountType.DEPOSIT, sum, Computer.randomPin());
            case 3:
                return new PersonalAccount(Computer.randomNum(), AccountType.CREDIT, sum, Computer.randomPin());
            case 9:
                return null;
        }
        return null;
    }

}
