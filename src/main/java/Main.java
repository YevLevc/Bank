import com.solvd.laba.bank.Client;
import com.solvd.laba.bank.PersonalAccount;
import com.solvd.laba.bank.service.AccountParser;
import com.solvd.laba.bank.service.Stream;
import com.solvd.laba.bank.service.TextParser;
import com.solvd.laba.bank.tech.Atm;
import com.solvd.laba.bank.worker.Worker;
import com.solvd.laba.bank.worker.administration.Director;
import com.solvd.laba.bank.worker.operation.Cashier;
import com.solvd.laba.bank.worker.operation.Manager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class); // = LogManager....
    public static Map<Integer, PersonalAccount> accountMap = new HashMap<>();
    public static List<Client> clientSet = new ArrayList<>();
    public static Atm atm = new Atm();
    public static Director director = new Director();
    public static Manager manager = new Manager();
    public static Cashier cashier = new Cashier();

    public static void main(String[] args) throws IOException {
        Worker<Manager> man1 = director.employeeHiring(2, "Ivanov", manager, 10000);
        Worker<Cashier> cash1 = director.employeeHiring(3, "Ivanov", cashier, 10000);
        cash1.setCashregAccess(true);

        ArrayList<ArrayList<String>> clients = TextParser.runParse("assets/clients.txt");
        ArrayList<ArrayList<String>> accounts = AccountParser.runParse("assets/accounts.txt");

        for (ArrayList<String> strings : clients) {
            clientSet.add(new Client(Integer.parseInt(strings.get(0)), strings.get(1)));
        }
        for (ArrayList<String> strings : accounts) {
            accountMap.put(Integer.parseInt(strings.get(0)),
                    man1.getPosition().openAccount(Integer.parseInt(strings.get(1)), strings.get(2), Double.parseDouble(strings.get(3)),
                            Boolean.parseBoolean(strings.get(4)), Integer.parseInt(strings.get(5))));
        }

        int choice;
        for (Client value : Stream.sortByName(clientSet)) {
            LOGGER.info(value.toString());
        }
        Client client = Bank.greeting();
        do {
            choice = Bank.interact(client);
            switch (choice) {
                case 1:
                    accountMap.put(client.getID(), man1.getPosition().openAccount());
                    LOGGER.info("Account opened: " + accountMap.get(client.getID()).infoString());
                    break;
                case 2:
                    atm.process(accountMap.get(client.getID()));
                    break;
                case 3:
                    Bank.changeCurrency();

            }

        }
        while (choice != 8 && choice != 9);

        File cl = new File("assets/clients.txt");
        File acc = new File("assets/accounts.txt");
        FileUtils.writeLines(cl, clientSet);
        FileUtils.writeLines(acc, accountMap.entrySet());
        if (choice == 9) {
            TwoTasks tasks = new TwoTasks();
            new

                    Thread(tasks.getTask1(), "First Thread").

                    start();
            new

                    Thread(tasks.getTask2(), "Second Thread").

                    start();
        }
    }

    static class TwoTasks {
        private String str1 = "First";
        private String str2 = "Second";

        //        @SuppressWarnings("Duplicates")
        public Runnable getTask1() {
            return () -> {
                while (true) {
                    synchronized (str1) {
                        synchronized (str2) {
                            LOGGER.info(str1 + str2);
                        }
                    }
                }
            };
        }

        public Runnable getTask2() {
            return () -> {
                while (true) {
                    synchronized (str2) {
                        synchronized (str1) {
                            LOGGER.info(str2 + str1);
                        }
                    }
                }
            };
        }
    }
}

