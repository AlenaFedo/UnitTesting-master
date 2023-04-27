package shop;

import org.junit.jupiter.api.*;
import parser.JsonParser;


import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTest {

    private Cart cart;
    private RealItem item;

    @BeforeEach
    void setUp() {
        JsonParser parser = new JsonParser();
        cart = parser.readFromFile(new File("src/main/resources/andrew-cart.json"));
        item = new RealItem();
        item.setPrice(10);
        cart.addRealItem(item);
    }

    @Test
    void testCalculationWhileAddingItem() {
        assertEquals(25, cart.getTotalPrice());
    }
    @Test
    void testCalculationWhileDeletingItem() {
        cart.deleteRealItem(item);
        assertEquals(25, cart.getTotalPrice());
    }
}
