package parser;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;
import shop.Cart;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.params.ParameterizedTest;
import java.io.File;


public class JsonParserTest {

    public static final String EXPECTED_RESULT = "{\"cartName\":\"Test_Cart\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}";
    private JsonParser jsonParser;
    private Cart cart;

    @BeforeEach
    public void init() {
       jsonParser = new JsonParser();
       cart = new Cart("Test_Cart");
    }

    @Test
    public void testWriteToFile() throws IOException {
        jsonParser.writeToFile(cart);
        String actualResult = Files.readString(Paths.get("src/main/resources/" + cart.getCartName() + ".json"));
        Assertions.assertEquals(EXPECTED_RESULT, actualResult);
    }

    @Test
    @Tag("JsonParserTest")
    void testReadFromFile() {
        String fileName = "src/main/resources/andrew-cart.json";
        Cart readedCart = jsonParser.readFromFile(new File(fileName));
        Assertions.assertEquals("andrew-cart", readedCart.getCartName(),
                "Cart name " + readedCart.getCartName() + "doesn't match with expected " + "'andrew-cart'");
    }

    @ParameterizedTest
    @ValueSource(strings = {"skjdfhksjd", "sjkdfhk", "ksjdhfk"})
    @Tag("JsonParserTest")
    void testNoSuchFileException(String name) {
        Assertions.assertThrows(NoSuchFileException.class, () -> {
            jsonParser.readFromFile(new File("src/main/resources/" + name + ".json"));
        });
    }

    @AfterEach
    public void clearData() {
        try {
            Files.delete(Paths.get("src/main/resources/" + cart.getCartName() + ".json"));
        } catch (Exception ignored) {
        }
    }
}
