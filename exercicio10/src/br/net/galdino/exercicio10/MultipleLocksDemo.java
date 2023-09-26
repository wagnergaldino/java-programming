package br.net.galdino.exercicio10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
public class MultipleLocksDemo {
    public static void main(String[] args) throws InterruptedException {
        List<BankAccount> accounts = new ArrayList<>();
        Random random = new Random();
 
        for (int i = 0; i < 5; i++) {
            BankAccount account = new BankAccount(i + 1, 1000.0);
            accounts.add(account);
        }
 
        List<Thread> threads = new ArrayList<>();
 
        for (int i = 0; i < 10; i++) {
            DepositTask depositTask = new DepositTask(accounts.get(random.nextInt(accounts.size())));
            Thread depositThread = new Thread(depositTask);
            threads.add(depositThread);
            depositThread.start();
 
            WithdrawTask withdrawTask = new WithdrawTask(accounts.get(random.nextInt(accounts.size())));
            Thread withdrawThread = new Thread(withdrawTask);
            threads.add(withdrawThread);
            withdrawThread.start();
        }
 
        for (Thread thread : threads) {
            thread.join();
        }
 
        for (BankAccount account : accounts) {
            System.out.println("Account " + account.getAccountNumber() + " balance: $" + account.getBalance());
        }
    }
}
 
class BankAccount {
    private int accountNumber;
    private double balance;
    private Lock lock;
 
    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.lock = new ReentrantLock();
    }
 
    public int getAccountNumber() {
        return accountNumber;
    }
 
    public double getBalance() {
        return balance;
    }
 
    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }
 
    public void withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
            }
        } finally {
            lock.unlock();
        }
    }
}
 
class DepositTask implements Runnable {
    private BankAccount account;
 
    public DepositTask(BankAccount account) {
        this.account = account;
    }
 
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            double amount = random.nextDouble() * 400 + 100;
            account.deposit(amount);
        }
    }
}
 
class WithdrawTask implements Runnable {
    private BankAccount account;
 
    public WithdrawTask(BankAccount account) {
        this.account = account;
    }
 
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            double amount = random.nextDouble() * 150 + 50;
            account.withdraw(amount);
        }
    }
}