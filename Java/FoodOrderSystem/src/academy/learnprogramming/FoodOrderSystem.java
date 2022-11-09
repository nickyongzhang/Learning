package academy.learnprogramming;

import java.time.LocalDateTime;
import java.util.*;

public class FoodOrderSystem {
    private Map<String, Integer> dailyList;
    private Map<String, LinkedList<PerishableFoodItem>> perishableInventory;
    private Map<String, LinkedList<NonPerishableFoodItem>> nonPerishableInventory;

    public FoodOrderSystem(Map<String, Integer> dailyList, Map<String, LinkedList<PerishableFoodItem>> perishableInventory, Map<String, LinkedList<NonPerishableFoodItem>> nonPerishableInventory) {
        this.dailyList = dailyList;
        this.perishableInventory = perishableInventory;
        this.nonPerishableInventory = nonPerishableInventory;
    }

    public Map<String, Integer> getDailyList() {
        return dailyList;
    }

    public Map<String, LinkedList<PerishableFoodItem>> getPerishableInventory() {
        return perishableInventory;
    }

    public Map<String, LinkedList<NonPerishableFoodItem>> getNonPerishableInventory() {
        return nonPerishableInventory;
    }

    public void generatePerishableDailyList() {
        for (String itemName: perishableInventory.keySet()) {
            int cnt = 0;
            LinkedList<PerishableFoodItem> linkedList = perishableInventory.get(itemName);
            for (int i = 0;i<linkedList.size();i++) {
                PerishableFoodItem item = linkedList.get(i);
                if (item.getExpirationDate().equals(LocalDateTime.now())) {
                    linkedList.remove(i);
                } else {
                    cnt += item.getAvailableQuantity();
                }
            }
            dailyList.put(itemName, PerishableFoodItem.MAX_ALLOWED_QUANTITY-cnt);
        }
    }

    public void generateNonPerishableDailyList() {
        for (String itemName: nonPerishableInventory.keySet()) {
            int cnt = 0;
            LinkedList<NonPerishableFoodItem> linkedList = nonPerishableInventory.get(itemName);
            for (int i = 0;i<linkedList.size();i++) {
                NonPerishableFoodItem item = linkedList.get(i);
                cnt += item.getAvailableQuantity();
            }
            dailyList.put(itemName, NonPerishableFoodItem.MAX_ALLOWED_QUANTITY-cnt);
        }
    }

    public void generateDailyList() {
        generateNonPerishableDailyList();
        generatePerishableDailyList();
    }

}
