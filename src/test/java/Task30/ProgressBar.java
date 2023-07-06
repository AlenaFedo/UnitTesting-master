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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProgressBar {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String SITE_NAME = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
        driver.get(SITE_NAME);
    }

    @Test
    public void multiSelect() {
        driver.findElement(By.id("cricle-btn")).click();
        waitingMore50percents();
        driver.navigate().refresh();
    }

    private void waitingMore50percents() {
        Integer counter = 0;

        while (counter < 50) {
            WebElement percent = driver.findElement(By.className("percenttext"));
            String percentText = percent.getText();
            percentText = percentText.replace("%", "");
            counter = Integer.parseInt(percentText);
        }
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

}
