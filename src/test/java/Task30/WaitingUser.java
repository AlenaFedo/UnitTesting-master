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

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        String SITE_NAME = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";
        driver.get(SITE_NAME);
    }


    @Test
    public void waitingUser() {
        driver.findElement(By.cssSelector("[class='btn btn-default']")).click();

        By user = By.xpath("//div[contains(text(),'First')]");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(user));
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

}
