package parser;


import org.testng.annotations.*;
import shop.Cart;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.File;

import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;


public class JsonParserTest {

    public static final String EXPECTED_RESULT = "{\"cartName\":\"Test_Cart\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}";
    private JsonParser jsonParser;
    private Cart cart;

    @BeforeTest(alwaysRun = true)
    public void init() {
       jsonParser = new JsonParser();
       cart = new Cart("Test_Cart");
    }

    @Test(enabled = false)
    public void testWriteToFile() throws IOException {
        jsonParser.writeToFile(cart);
        String actualResult = Files.readString(Paths.get("src/main/resources/" + cart.getCartName() + ".json"));
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    @Test(groups = { "JsonParserTests1" })
    void testReadFromFile() {
        String fileName = "src/main/resources/andrew-cart.json";
        Cart readedCart = jsonParser.readFromFile(new File(fileName));
        assertEquals("Cart name '" + readedCart.getCartName() + "' doesn't match with expected " + "'andrew-cart'",
                "andrew-cart", readedCart.getCartName()
                );
    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Name1"},
                {"Name2"},
                {"Name3"}
        };
    }

    @Parameters({ "names" })
    @Test(groups = { "JsonParserTests2" })//, dataProvider =  "test1" )
    void testNoSuchFileException(String name) {
        assertThrows(NoSuchFileException.class, () -> {
            jsonParser.readFromFile(new File("src/main/resources/" + name + ".json"));
        });
    }

    @AfterTest(alwaysRun = true)
    public void clearData() {
        try {
            Files.delete(Paths.get("src/main/resources/" + cart.getCartName() + ".json"));
        } catch (Exception ignored) {
        }
    }
}
