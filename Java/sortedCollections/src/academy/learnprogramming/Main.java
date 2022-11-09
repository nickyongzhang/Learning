package academy.learnprogramming;

import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static StockList stockList = new StockList();
    public static void main(String[] args) {
	// write your code here
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.4, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s:stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket basket = new Basket("Tim");

        sellItem(basket, "car", 1);
        System.out.println(basket);

        sellItem(basket, "car", 1);
        System.out.println(basket);

        if (sellItem(basket, "car", 1)!=1) {
            System.out.println("There are no more cars in the stock list");
        }
//        System.out.println(basket);

        sellItem(basket, "spanner", 5);
        sellItem(basket, "juice", 4);
        sellItem(basket, "cup", 12);
        sellItem(basket, "bread", 1);
        System.out.println(basket);

//        System.out.println(stockList);

        Basket timsBasket = new Basket("customer");
        sellItem(timsBasket, "cup", 100);
        sellItem(timsBasket, "juice", 5);
        removeItem(timsBasket, "cup", 1);
        System.out.println(timsBasket);

        removeItem(basket, "car", 1);
        removeItem(basket, "cup", 9);
        removeItem(basket, "car", 1);
        System.out.println("Cars removed: "+removeItem(basket, "car", 1));

        System.out.println(basket);

        removeItem(basket, "bread", 1);
        removeItem(basket, "cup", 3);
        removeItem(basket, "juice", 4);
        removeItem(basket, "cup", 3);
        System.out.println(basket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(timsBasket);
        System.out.println(stockList);
        checkOut(timsBasket);
        System.out.println(timsBasket);
        System.out.println(stockList);

//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp); // will return an error because Items() is unmodifiable
        StockItem car = stockList.Items().get("car");
        if (car!=null) {
            car.adjustStock(2000); // but can modify the individual item in the hashmap
            stockList.get("car").adjustStock(-1000);
        }
        System.out.println(stockList);


//        for (Map.Entry<String, Double> price: stockList.priceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }

        checkOut(basket);
        System.out.println(basket);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem==null) {
            System.out.println("We don't sell "+item);
            return 0;
        }

        if (stockList.reserveStock(item, quantity)!=0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem==null) {
            System.out.println("We don't sell "+item);
            return 0;
        }

        if (basket.removeFromBasket(stockItem, quantity)!=0) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item: basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
