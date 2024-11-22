import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

    static Vending v;
    static Item item;

    @BeforeAll
    public static void setup(){
        v = new Vending(1, 1);
        item = new Item(10, 5);
    }

    @Test
    void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void addMoneyTest(){
        v.addMoney(2.0);
        assertEquals(2.0, v.getBalance());
    }

    @Test
    void addMoneyTest2(){
        v.addMoney(-1.0);
        assertEquals(0.0, v.getBalance());
    }

    @Test
    void addMoneyTest3(){
        v.addMoney(0);
        assertEquals(0.0, v.getBalance());
    }

    @Test
    void buyAnItemTest(){
        item.purchase(1);
        assertEquals(4, item.getStock());
    }

    @Test
    void buyAnItemTest2(){
        item.purchase(-1);
        assertEquals(5, item.getStock());
    }

    @Test
    void buyAnItemTest3(){
        item.purchase(0);
        assertEquals(5, item.getStock());
    }

    @Test
    void emptyInventoryTest() {
        Vending v1 = new Vending(4, 4);
        v1.addMoney(7.0); // min amount of money to purchase 4 candy and 4 gum (4*1.25 + 4*0.5)
        for (int i = 0; i < 4; i++) {
            v1.purchase("Candy");
            v1.purchase("Gum");
        }
        assertEquals(true, v1.isStockEmpty());
        System.out.println(v1.getBalance());
    }

    @Test
    void emptyInventoryTest2() {
        Vending v1 = new Vending(4, 4);
        v1.addMoney(6.0); // not enough money to purchase all items and empty out inventory
        for (int i = 0; i < 4; i++) {
            v1.purchase("Candy");
            v1.purchase("Gum");
        }
        assertEquals(false, v1.isStockEmpty());
        System.out.println(v1.getBalance());
    }

    @Test
    void restockUSTest(){
        Vending v1 = new Vending(4, 4);
        v1.addMoney(7.0); // not enough money to purchase all items and empty out inventory
        for (int i = 0; i < 4; i++) {
            v1.purchase("Candy");
            v1.purchase("Gum");
        }

        v1.restock("Candy", 4);
        assertEquals(false, v1.isStockEmpty());
    }



}