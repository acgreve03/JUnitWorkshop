import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vending {
    private static HashMap<String, Item> Stock = new HashMap<String, Item>();
    private HashMap<String, Integer> purchaseHistory = new HashMap<>(); //tracks purchases
    private ArrayList<Item> bestSellers = new ArrayList<>();
    private double balance;


    Vending(int numCandy, int numGum) {
        Stock.put("Candy", new Item("Candy", 1.25, numCandy));
        Stock.put("Gum", new Item("Gum", 0.5, numGum));
        this.balance = 0;
    }

    void resetBalance() {
        this.balance = 0;
    }

    double getBalance() {
        return this.balance;
    }

    void addMoney(double amt) {
        if (amt > 0) {
            this.balance = this.balance + amt;
        } else {
            System.out.println("You can't add a negative amount of money.");
        }
    }

    void addItem(String newName, double newAmount, int newNumPieces){
        Item item = new Item(newName, newAmount, newNumPieces);
        Stock.put(newName, item);
    }

    //User story for restocking items
    void restock(String name, int amount) {
        if(Stock.containsKey(name)){
            Item item = Stock.get(name);
            item.setStock(amount);
        }
        else{
            System.out.println("Sorry, don't know that item");
        }
    }

    boolean doesItemExist(String name){
        if(Stock.containsKey(name)){
            return true;
        }
        else{
            return false;
        }
    }

    void printInventory() {
        for (Map.Entry<String, Item> entry : Stock.entrySet()) {
            Item item = entry.getValue();
            System.out.println("Item: " + item.getName() + ", Price: $" + item.getPrice() + ", Stock: " + item.getStock());
        }
    }

    void removeItem(String itemName){
        if(Stock.containsKey(itemName)){
            Stock.remove(itemName);
        }
    }


    // Rename an item
    String renameItem(String oldName, String newName) {
        if (Stock.containsKey(oldName)) {
            Item item = Stock.remove(oldName);
            item.setName(newName);
            Stock.put(newName, item);
            return item.getName();
        } else {
            return("Item not found.");
        }
    }

    void purchase(String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (balance >= item.price && item.getStock() > 0) {
                item.purchase(1);
                this.balance = this.balance - item.price;
                purchaseHistory.put(name, purchaseHistory.getOrDefault(name, 0) + 1);
            } else if (item.getStock() == 0) {
                System.out.println("Item out of stock");
            } else {
                System.out.println("Gimme more money");
            }
        } else {
            System.out.println("Sorry, don't know that item");
        }
    }

    //checking the details of an item
    void viewItemDetails(String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            System.out.println("Item: " + item.getName());
            System.out.println("Price: $" + item.getPrice());
            System.out.println("Stock: " + item.getStock());
        } else {
            System.out.println("Item not found.");
        }
    }

    double getItemPrice(String name){
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            return item.getPrice();
        }
        else{
            System.out.println("Item not found.");
            return -1.0;
        }
    }

    void applyDiscount(String itemName, double discountedPercentage){
        if((discountedPercentage >= 0.0 && discountedPercentage <= 1.0) && Stock.containsKey(itemName)){
            Item item = Stock.get(itemName);
            item.setPrice(item.getPrice() * (1-discountedPercentage));
        }
        else if (discountedPercentage < 0.0 || discountedPercentage > 1.0) {
            System.out.println("Percentage must be between 0 and 1.");
        }
        else{
            System.out.println("Item not found.");
        }
    }

    int getPurchaseHistory(String itemName){
        if(purchaseHistory.containsKey(itemName)){
            return purchaseHistory.get(itemName);
        }
        else{
            System.out.println("Item cannot be found in the purchase history.");
            return -1;
        }
    }

    int getItemStock(String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            return item.getStock();
        } else {
            System.out.println("Item not found");
            return -1;
        }
    }

    public boolean isStockEmpty() {
        for (Item item : Stock.values()) {
            if (item.getStock() > 0) {
                return false;
            }
        }
        return true;
    }

    void addBestSeller(String name){
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            bestSellers.add(item);
        }
    }

    boolean isBestSeller(String name){
        for(Item i : bestSellers){
            if(i.getName() == name){
                return true;
            }
        }
        return false;
    }
}



class Examples {
}

