import com.solvd.laba.bank.Client;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interact {
    private static final Logger LOGGER = Logger.getLogger(Interact.class);

    public static int interact (Client client) {
    Scanner scan = new Scanner(System.in);
    int choice = 0;
        LOGGER.info("Hello, " + client.getFullName() + "! Choose operation:" +
                "\n '1' - Open account | '2' - ATM | '3' - Exchange | '9' - Close program");
        try {choice = scan.nextInt();
        }
        catch (InputMismatchException e) {
            LOGGER.error("Wrong input");
        }
        return choice;
    }

//    public static int atm () {
//
//        LOGGER.info(accountMap.entrySet());
//
//
//
//
//
//
//        LOGGER.info(Main.atm.changeCurrency(4000, Currency.UAH, Currency.EUR));
//
//        LOGGER.info(cash1.getPosition().changeCurrency(1000, Currency.USD, Currency.UAH));
//
//        cashier.withdrawal(accountMap.get(1), 1000);
//        LOGGER.info(accountMap.get(1).getAccountState());
//
//        atm.refill(accountMap.get(1), 1000);
//        LOGGER.info(accountMap.get(1).getAccountState());
//
//        LOGGER.info(accountMap.get(1));
//    }
}
