package Task30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Alerts {
    private WebDriver driver;
    private Wait<WebDriver> wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String SITE_NAME = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
        driver.get(SITE_NAME);

        wait = new FluentWait<WebDriver>(driver);
    }


    @Test
    public void alert1() {
        driver.findElement(By.cssSelector("[class='btn btn-default']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @Test
    public void confirmBoxAccept() {
        driver.findElement(By.cssSelector("[onclick='myConfirmFunction()']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
    @Test
    public void confirmBoxDismiss() {
        driver.findElement(By.cssSelector("[onclick='myConfirmFunction()']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }
    @Test
    public void alert3() {
        driver.findElement(By.cssSelector("[onclick='myPromptFunction()']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Test3");//?????????????????????????
        alert.accept();
     }
    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

}
