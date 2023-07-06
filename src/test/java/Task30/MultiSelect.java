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

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        String SITE_NAME = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
        driver.get(SITE_NAME);
    }


    @Test
    public void multiSelect() {
        WebElement list = driver.findElement(By.id("multi-select"));
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
