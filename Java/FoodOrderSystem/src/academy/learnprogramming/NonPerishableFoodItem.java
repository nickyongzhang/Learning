package academy.learnprogramming;

public class NonPerishableFoodItem extends FoodItem {
    public static final int MAX_ALLOWED_QUANTITY = 100;
    public NonPerishableFoodItem(String name, Double price, Integer availableQuantity) {
        super(name, price, availableQuantity, MAX_ALLOWED_QUANTITY, "non-perishable");
    }
}
