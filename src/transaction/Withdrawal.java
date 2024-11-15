package transaction;

import java.util.Scanner;
import model.Account;

public class Withdrawal extends Transaction {

    public Withdrawal(Account account) {
        super(account);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah penarikan: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Jumlah penarikan harus lebih dari 0.");
            return;
        }

        // Validasi saldo minimum
        if (account.getBalance() - amount >= Account.MINIMUM_BALANCE) {
            account.debit(amount);
            System.out.println("Penarikan berhasil. Saldo Anda sekarang: Rp" + account.getBalance());
        } else if (amount > account.getBalance()) {
            System.out.println("Saldo tidak mencukupi untuk melakukan penarikan.");
        } else {
            System.out.println("Penarikan gagal. Anda harus menyisakan minimal Rp" + Account.MINIMUM_BALANCE + " di rekening Anda.");
        }
    }
}
