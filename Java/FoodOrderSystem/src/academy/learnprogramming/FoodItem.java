package academy.learnprogramming;

public abstract class FoodItem {
    private String name;
    private Double price;
    private Integer availableQuantity;
    private Integer maxAllowedQuantity;
    private String foodType;

    public FoodItem(String name, Double price, Integer availableQuantity, Integer maxAllowedQuantity, String foodType) {
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.maxAllowedQuantity = maxAllowedQuantity;
        this.foodType = foodType;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public Integer getMaxAllowedQuantity() {
        return maxAllowedQuantity;
    }

    public String getFoodType() {
        return foodType;
    }
}
