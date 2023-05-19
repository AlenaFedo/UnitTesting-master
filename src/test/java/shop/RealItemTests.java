package shop;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

class RealItemTests {

    private RealItem item;

    @BeforeMethod
    public void init() {
        item = new RealItem();
        item.setWeight(1000);
    }

    @Test
    void testRealItem() {
        assertTrue(item.toString().contains("Weight: 1000"));
    }
}
