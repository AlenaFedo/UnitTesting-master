package Task30;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    @Test
    public void task() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\SeleniumTasks\\SeleniumJavaTraining\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://mail.yandex.com/");

        //Button Login
        Assertions.assertTrue(driver.findElement(By.xpath("//a[contains(@class,'Button2_view_default Button2_size_m')]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.cssSelector(".Button2_type_link.Button2_view_default")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.linkText("Log in")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href='https://passport.yandex.com/auth?retpath=https%3A%2F%2Fmail.yandex.com']")).isDisplayed());

        //Buy
        Assertions.assertTrue(driver.findElement(By.cssSelector(".Button2_size_m.ActionButton_VXdGh2PasdGWTKaK2Xlzy")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//a[contains(@class,'Button2_view_action Button2_size_m')]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.linkText("Buy")).isDisplayed());

        Assertions.assertTrue(driver.findElement(By.xpath("//span[@class = 'Button2-Text' and text()='Products' ]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//span[@class = 'Button2-Text' and text()='Solutions' ]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//span[@class = 'Button2-Text' and text()='Plans' ]")).isDisplayed());

        Assertions.assertTrue(driver.findElement(By.linkText("Get started")).isDisplayed());

        driver.quit();
    }
}
