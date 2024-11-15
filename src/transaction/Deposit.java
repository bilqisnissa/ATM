package transaction;

import model.Account;
import java.util.Scanner;

public class Deposit extends Transaction {

    public Deposit(Account account) {
        super(account);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah deposit: ");
        double amount = scanner.nextDouble();

        account.credit(amount);
        System.out.println("Deposit berhasil. Saldo Anda sekarang: " + account.getBalance());
    }
}