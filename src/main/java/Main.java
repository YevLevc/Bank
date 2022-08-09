import com.solvd.laba.bank.Client;
import com.solvd.laba.bank.PersonalAccount;
import com.solvd.laba.bank.enums.AccountType;
import com.solvd.laba.bank.enums.Currency;
import com.solvd.laba.bank.tech.Atm;
import com.solvd.laba.bank.worker.administration.Director;
import com.solvd.laba.bank.worker.operation.Cashier;
import com.solvd.laba.bank.worker.operation.Manager;

public class Main {
    public static void main(String[] args) {
        Director director = new Director(1,"Kozlov",50000);
//        Worker manager = director.employeeHiring(EmployeePosition.MANAGER,2,"Ivanov",10000);
        Client client = new Client(1,"Petrov");
        Manager manager = new Manager(1,"Ivanov", 20000);
        PersonalAccount a1 = manager.openAccount(client.getID(), AccountType.CARD,1000, 4444);
        Cashier cashier = new Cashier();
        cashier.setCashregAccess(true);

        Atm atm = new Atm();

        System.out.println(atm.changeCurrency(4000,Currency.UAH,Currency.EUR));

        System.out.println(cashier.changeCurrency(1000, Currency.USD, Currency.UAH));
        a1.setAccountState(cashier.withdrawal(a1, 1000));
        System.out.println(a1.getAccountState());

        a1.setAccountState(atm.refill(a1,1000));
        System.out.println(a1.getAccountState());
    }
}

