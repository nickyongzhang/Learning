package academy.learnprogramming;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private String accountNumber;

    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    // Synchronize the entire methods
//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }

    // Synchronize the necessary code blocks
//    public void deposit(double amount) {
//        synchronized (this) {
//            balance += amount;
//        }
//
//    }
//
//    public void withdraw(double amount) {
//        synchronized (this) {
//            balance -= amount;
//        }
//    }

    // use reentrant lock instead of synchronization
//    public void deposit(double amount) {
//        lock.lock();
//        try {
//            balance += amount;
//        } finally {
//            lock.unlock();
//        }
//
//    }
//
//    public void withdraw(double amount) {
//        lock.lock();
//        try {
//            balance -= amount;
//        } finally {
//            lock.unlock();
//        }
//    }

    // use trylock() method
//    public void deposit(double amount) {
//        try {
//            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) { // try to get the lock
//                try {
//                    balance += amount;
//                } finally {
//                    lock.unlock();
//                }
//            } else {
//                System.out.println("Could not get the lock");
//            }
//        } catch (InterruptedException e) {
//            // do something here
//        }
//    }
//
//    public void withdraw(double amount) {
//        try {
//            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
//                try {
//                    balance -= amount;
//                } finally {
//                    lock.unlock();
//                }
//            } else {
//                System.out.println("Could not get the lock");
//            }
//        } catch (InterruptedException e) {
//            // do something here
//        }
//    }

    // Q: how to make status variable threadsafe
    // A: no need change because status is local variable.
    public void deposit(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            // do something here
        }

        System.out.println("Transaction status = "+status);
    }

    public void withdraw(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            // do something here
        }

        System.out.println("Transaction status = "+status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number: "+accountNumber);
    }
}
