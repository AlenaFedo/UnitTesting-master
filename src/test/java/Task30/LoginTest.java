package Task30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static Task30.Locators.*;

public class LoginTest {

    public static final String USERNAME = "sea123alena";
    public static final String PASSWORD = "Bazarevsky1";
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");
    }


    @Test
    public void loginTest() {

        WebElement login = driver.findElement(LOGIN_BUTTON);
        login.click();

        WebElement userName = driver.findElement(USERNAME_FIELD);
        userName.sendKeys(USERNAME);

        driver.findElement(SUBMIT_BUTTON).click();

        WebElement password = driver.findElement(PASSWORD_FIELD);
        password.sendKeys(PASSWORD);

        driver.findElement(SUBMIT_BUTTON).click();

        Assertions.assertTrue(driver.findElement(INBOX).isDisplayed());
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}


