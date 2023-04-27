package shop;
import org.junit.jupiter.api.*;

class RealItemTests {

    private RealItem item;

    @BeforeEach
    public void init() {
        item = new RealItem();
        item.setWeight(1000);
    }

    @Test
    void testRealItem() {
        Assertions.assertTrue(item.toString().contains("Weight: 1000"));
    }
}
