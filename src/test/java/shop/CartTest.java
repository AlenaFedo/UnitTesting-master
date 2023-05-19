package shop;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parser.JsonParser;
import java.io.File;

import static org.testng.AssertJUnit.assertEquals;


class CartTest {

    private Cart cart;
    private RealItem item;

    @BeforeMethod
    void setUp() {
        JsonParser parser = new JsonParser();
        cart = parser.readFromFile(new File("src/main/resources/andrew-cart.json"));
        item = new RealItem();
        item.setPrice(10);
        cart.addRealItem(item);
    }

    @Test
    void testCalculationWhileAddingItem() {
        assertEquals(38457.479999999996, cart.getTotalPrice());
    }

    @Test
    void testCalculationWhileDeletingItem() {
        cart.deleteRealItem(item);
        assertEquals(38457.479999999996, cart.getTotalPrice());
    }
}
