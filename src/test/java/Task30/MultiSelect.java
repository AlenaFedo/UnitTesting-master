package Task30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MultiSelect {
    private WebDriver driver;
    private static final String MULTISELECT_PAGE_URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    private static final By STATES_LIST = By.id("multi-select");

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(MULTISELECT_PAGE_URL);
    }


    @Test
    public void multiSelectTest() {
        WebElement list = driver.findElement(STATES_LIST);
        Select select = new Select(list);
        List<String> allStates = select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
        Collections.shuffle(allStates);
        List<String> randomStates = allStates.subList(0, 3);
        randomStates.forEach(select::selectByValue);
        List<String> actualStates = select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
        Assertions.assertTrue(randomStates.containsAll(actualStates));
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

}
