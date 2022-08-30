import com.solvd.laba.bank.Client;
import com.solvd.laba.bank.service.Stream;
import com.solvd.laba.bank.enums.Currency;
import com.solvd.laba.bank.exeptions.AccountNotfoundExeption;
import com.solvd.laba.bank.exeptions.ClientNotFoundExeption;
import com.solvd.laba.bank.exeptions.NegativeValueException;
import com.solvd.laba.bank.interfaces.CapitalizeFirst;
import com.solvd.laba.bank.interfaces.CurrencyExchange;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
    private static final Logger LOGGER = Logger.getLogger(Bank.class);

    public static Client greeting() {
        Scanner scan = new Scanner(System.in);
        String choice = "";
        boolean clientFound = false;
        while (!clientFound) {
            LOGGER.info("Hello! Please enter your name if your existing client or 'NEW' to create new.");
            choice = scan.nextLine();
            if (choice.equalsIgnoreCase("new")) {
                LOGGER.info("Please enter your name:");
                String nm = scan.nextLine();
                CapitalizeFirst cap = name -> {
                    String n = StringUtils.stripStart(nm, StringUtils.SPACE);
                    return n.substring(0, 1).toUpperCase() + n.substring(1, n.indexOf(' ')) +
                            n.substring(n.indexOf(' '), n.indexOf(' ') + 2).toUpperCase() + n.substring(n.indexOf(' ') + 2);
                };
                Client client = new Client(Main.clientSet.size() + 1, cap.getResult(nm));
                Main.clientSet.add(client);
                return client;
            }
            try {
                if (Stream.getByName(Main.clientSet, choice) == null)
                    throw new ClientNotFoundExeption("There is no such client.");
                else clientFound = true;
            } catch (InputMismatchException | ClientNotFoundExeption e) {
                LOGGER.error(e.getMessage());
                choice = "";
            }
        }
        return Stream.getByName(Main.clientSet, choice);
    }

    public static int interact(Client client) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        LOGGER.info("Hello, " + client.getFullName() + "! Choose operation:" +
                "\n '1' - Open account | '2' - ATM | '3' - Exchange | '8' - Close program | '9' - DEADLOCK");
        try {
            choice = scan.nextInt();
            if ((choice == 2) && Main.accountMap.get(client.getID()) == null)
                throw new AccountNotfoundExeption();
        } catch (InputMismatchException e) {
            LOGGER.error("Wrong input");
            scan.nextLine();
        } catch (AccountNotfoundExeption e) {
            LOGGER.error("No account yet!");
            scan.nextLine();
            choice = 0;
        }
        return choice;
    }

    public static void changeCurrency() {
        Scanner scan = new Scanner(System.in);
        int amount;
        int cur1 = 0;
        int cur2 = 0;
        do {
            LOGGER.info("Please choose first currency:" +
                    "\n '1' - UAH | '2' - USD | '3' - EUR | '9' - Exit");
            try {
                cur1 = scan.nextInt();
                if (cur1 != 1 && cur1 != 2 && cur1 != 3 && cur1 != 9)
                    throw new InputMismatchException("Please, enter correct value!");
                if (cur1 == 9) break;
            } catch (InputMismatchException e) {
                LOGGER.error(e.getMessage());
                scan.nextLine();
                continue;
            }
            LOGGER.info("Please enter amount:");
            try {
                amount = scan.nextInt();
                if (amount < 0) throw new NegativeValueException("Please, enter non-negative value!");
            } catch (InputMismatchException | NegativeValueException e) {
                LOGGER.error(e.getMessage());
                scan.nextLine();
                continue;
            }
            LOGGER.info("Please choose second currency:" +
                    "\n '1' - UAH | '2' - USD | '3' - EUR | '9' - Exit");
            try {
                cur2 = scan.nextInt();
                if (cur2 != 1 && cur2 != 2 && cur1 != 3 && cur2 != 9)
                    throw new InputMismatchException("Please, enter correct value!");
            } catch (InputMismatchException e) {
                LOGGER.error(e.getMessage());
                scan.nextLine();
                continue;
            }
            Currency a = Currency.UAH;
            Currency b = Currency.UAH;
            switch (cur1) {
                case 2:
                    a = Currency.USD;
                    break;
                case 3:
                    a = Currency.EUR;
                    break;
            }
            switch (cur2) {
                case 2:
                    b = Currency.USD;
                    break;
                case 3:
                    b = Currency.EUR;
                    break;
            }
            CurrencyExchange exchange = (am, c1, c2) -> am / c1.getRate() * c2.getRate();
            LOGGER.info("Exchange result: " + (int) exchange.changeCurrency(amount, a, b) + " " + b.name());
        }
        while (cur2 != 9);
    }
}
