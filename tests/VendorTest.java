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
    void buyAnItemTest(){
        item.purchase(1);
        assertEquals(4, item.getStock());
    }


}