package Task30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingUser {
    private WebDriver driver;
    private static final String LOADING_DATA_DINAMICALLY_URL = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";
    private static final By GET_NEW_USER_BUTTON = By.cssSelector("[class='btn btn-default']");
    private static final By USER_DATA = By.xpath("//div[contains(text(),'First')]");
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(LOADING_DATA_DINAMICALLY_URL);
    }


    @Test
    public void waitingUserTest() {
        driver.findElement(GET_NEW_USER_BUTTON).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(USER_DATA));
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

}
