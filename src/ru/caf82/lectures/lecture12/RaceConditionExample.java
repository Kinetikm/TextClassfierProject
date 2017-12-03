package ru.caf82.lectures.lecture12;

/**
 * Created by ilysko on 03.12.17.
 */
public class RaceConditionExample {
    public static void main(String[] args) {
        BankAccount client = new BankAccount("Ilya", 1000000);

        System.out.println("Money amount before workers: " + client.getMoneyAmount());

        Thread t1 = new MoneyIncrease(client);
        Thread t2 = new MoneyDecrease(client);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Money amount after workers: " + client.getMoneyAmount());
    }
}

class BankAccount {
    final String clientName;
    private int moneyAmount;

    public BankAccount(String clientName, int moneyAmount) {
        this.clientName = clientName;
        this.moneyAmount = moneyAmount;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void incMoneyAmount() {
        ++this.moneyAmount;
    }

    public void decrMoneyAmount() {
        --this.moneyAmount;
    }
}

class MoneyIncrease extends Thread {
    BankAccount bankAccount;

    public MoneyIncrease(BankAccount bankAccount) {
        super();
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; ++i) {
            bankAccount.incMoneyAmount();
        }
    }
}

class MoneyDecrease extends Thread {
    BankAccount bankAccount;

    public MoneyDecrease(BankAccount bankAccount) {
        super();
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; ++i) {
            bankAccount.decrMoneyAmount();
        }
    }
}
