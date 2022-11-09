package academy.learnprogramming;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> grocerList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        grocerList.add(item);
    }

    public ArrayList<String> getGrocerList() {
        return grocerList;
    }

    public void printGroceryList() {
        System.out.println("You have "+grocerList.size()+" items in your grocery list");
        for (int i = 0; i<grocerList.size(); i++) {
            System.out.println((i+1) + ". "+grocerList.get(i));
        }
    }

    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if (position>=0) {
            modifyGroceryItem(position, newItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem) {
        grocerList.set(position, newItem);
        System.out.println("Grocery item "+(position+1)+" has been modified");
    }

    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if (position>=0) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position) {
        grocerList.remove(position);
    }

    private int findItem(String searchItem) {
//        boolean exists = grocerList.contains(searchItem);
        return grocerList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        if (position>=0) {
            return true;
        }
        return false;
    }
}

