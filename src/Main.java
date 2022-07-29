import com.solvd.laba.bank.Client;
import com.solvd.laba.bank.tech.Atm;
import com.solvd.laba.bank.tech.Computer;
import com.solvd.laba.bank.worker.administration.*;

public class Main {
    public static void main(String[] args) {
        Director d = new Director(1, "Petro Ivanenko");
        Accountant a = new Accountant(2,"Katia Petrenko");
        Atm atm = new Atm();
        Computer c = new Computer();
        System.out.println(d.getFullName()+d.isCashregAccess());
        System.out.println(a.isCashregAccess());
    }
}

