import com.solvd.laba.bank.tech.Atm;
import com.solvd.laba.bank.tech.Computer;
import com.solvd.laba.bank.worker.administration.*;

public class Main {
    public static void main(String[] args) {
        Director d = new Director();
        Accountant a = new Accountant();
        Atm atm = new Atm();
        Computer c = new Computer();

        System.out.println(d.isCashregAccess());
        System.out.println(a.isCashregAccess());
    }
}

