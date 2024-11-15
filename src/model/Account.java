package model;

import java.util.Scanner;

public class Account {
    private String accountNumber;
    private String pin;
    private double balance;

    // Saldo minimum yang harus disisakan
    public static final double MINIMUM_BALANCE = 50000.0;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    // Getter and Setter
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) {
        this.balance -= amount;
    }

    public boolean withdraw(double amount) {
        if (balance - amount < MINIMUM_BALANCE) {
            System.out.println("Penarikan gagal. Saldo minimal Rp" + MINIMUM_BALANCE + " harus tetap ada.");
            return false;
        }
        balance -= amount;
        System.out.println("Penarikan sebesar Rp" + amount + " berhasil. Saldo sekarang: Rp" + balance);
        return true;
    }

    // Method to change PIN
    public void changePin(Scanner scanner) {
        System.out.print("Masukkan PIN lama: ");
        String oldPin = scanner.nextLine();

        if (oldPin.equals(this.pin)) {
            System.out.print("Masukkan PIN baru: ");
            String newPin = scanner.nextLine();
            System.out.print("Konfirmasi PIN baru: ");
            String confirmPin = scanner.nextLine();

            if (newPin.equals(confirmPin)) {
                this.pin = newPin;
                System.out.println("PIN berhasil diubah.");

                // Validasi ulang setelah PIN berhasil diubah
                System.out.println("\nUntuk melanjutkan, silakan masukkan kembali Nomor Akun dan PIN baru.");
                System.out.print("Masukkan accountNumber: ");
                String inputAccountNumber = scanner.nextLine();
                System.out.print("Masukkan PIN: ");
                String inputPin = scanner.nextLine();

                if (inputAccountNumber.equals(this.accountNumber) && inputPin.equals(this.pin)) {
                    System.out.println("Verifikasi berhasil, Anda dapat melanjutkan transaksi.");
                } else {
                    System.out.println("Verifikasi gagal. AccountNumber atau PIN salah.");
                }
            } else {
                System.out.println("Konfirmasi PIN tidak cocok.");
            }
        } else {
            System.out.println("PIN lama tidak sesuai.");
        }
    }
}
