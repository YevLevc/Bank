import com.solvd.laba.bank.Client;
import com.solvd.laba.bank.Enums.AccountType;
import com.solvd.laba.bank.Enums.Currency;
import com.solvd.laba.bank.accounts.PersonalAccount;
import com.solvd.laba.bank.tech.Atm;
import com.solvd.laba.bank.worker.operation.Cashier;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(1,"Petrov");
        PersonalAccount a1 = new PersonalAccount(client.getID(), AccountType.CARD,1000, 4444);
        Cashier cashier = new Cashier();
        Atm atm = new Atm();
        cashier.setCashregAccess(true);
        System.out.println(cashier.changeCurrency(1000, Currency.USD, Currency.UAH));
        cashier.accountOperation(a1, 1000);
        System.out.println(a1.getAccountState());
        atm.accountOperation(a1,-1000);
        System.out.println(a1.getAccountState());
    }
}

