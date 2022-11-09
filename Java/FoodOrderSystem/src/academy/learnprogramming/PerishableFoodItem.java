package academy.learnprogramming;

import java.time.LocalDateTime;

public class PerishableFoodItem extends FoodItem{
    public static final int MAX_ALLOWED_QUANTITY = 100;
    private LocalDateTime expirationDate;
    private LocalDateTime orderDate;

    public PerishableFoodItem(String name, Double price, Integer availableQuantity, LocalDateTime expirationDate, LocalDateTime orderDate) {
        super(name, price, availableQuantity, MAX_ALLOWED_QUANTITY, "perishable");
        this.expirationDate = expirationDate;
        this.orderDate = orderDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}
