import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

    static Vending v;

    @BeforeAll
    public static void setup(){
        v = new Vending(1, 1);
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


}