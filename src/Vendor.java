import java.util.HashMap;


/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vending {
    private static HashMap<String, Item> Stock = new HashMap<String, Item>();
    private double balance;

    Vending(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(0.5, numGum));
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

    void purchase(String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (balance >= item.price && item.getStock() > 0) {
                item.purchase(1);
                this.balance = this.balance - item.price;
            } else if (item.getStock() == 0) {
                System.out.println("Item out of stock");
            } else {
                System.out.println("Gimme more money");
            }
        } else {
            System.out.println("Sorry, don't know that item");
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
}



class Examples {
}

