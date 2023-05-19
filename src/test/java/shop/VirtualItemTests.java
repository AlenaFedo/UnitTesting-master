package shop;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

class VirtualItemTests {
    private VirtualItem item;

    @BeforeMethod
    public void init() {
        item = new VirtualItem();
        item.setSizeOnDisk(85000);
    }

    @Test
    void testVirtualItem() {
        assertTrue(item.toString().contains("Size on disk: 85000"));
    }

}
