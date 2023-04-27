package shop;
import org.junit.jupiter.api.*;

class VirtualItemTests {
    private VirtualItem item;

    @BeforeEach
    public void init() {
        item = new VirtualItem();
        item.setSizeOnDisk(85000);
    }

    @Test
    void testVirtualItem() {
        Assertions.assertTrue(item.toString().contains("Size on disk: 85000"));
    }

}
