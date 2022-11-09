package academy.learnprogramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTestParameterized {
    private BankAccount account;

    @BeforeEach
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }


    @ParameterizedTest
    @CsvSource({"100.00, true, 1100.00", "200.00, true, 1200.00", "325.14, true, 1325.14"})
    void deposit(double amount, boolean branch, double expected) {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.01);
    }
}
