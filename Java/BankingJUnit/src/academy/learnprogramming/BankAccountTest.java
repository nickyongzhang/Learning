package academy.learnprogramming;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;
    private static int count;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @BeforeEach
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200.0, true);
        assertEquals(1200.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_notBranch() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(600.00, false));
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        double balance = account.deposit(200.0, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        double balance = account.withdraw(200.0, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    void isChecking() {
        assertTrue(account.isChecking(), "The account is not a checking account");
    }

    @org.junit.jupiter.api.AfterAll
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = "+count++);
    }

    @AfterEach
    public void teardown() {
        System.out.println("Count = "+count++);
    }
}