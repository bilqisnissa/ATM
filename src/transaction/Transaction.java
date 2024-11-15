package transaction;

import model.Account;

public abstract class Transaction {
    protected Account account;

    public Transaction(Account account) {
        this.account = account;
    }

    public abstract void execute();
}
