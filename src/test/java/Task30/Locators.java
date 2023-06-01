package Task30;

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
        //WebElement login = driver.findElement(By.xpath("//a[contains(@class,'Button2_view_default Button2_size_m')]"));
        //WebElement login = driver.findElement(By.cssSelector(".Button2_type_link.Button2_view_default"));
        // WebElement login = driver.findElement(By.linkText("Log in"));
        //WebElement login = driver.findElement(By.cssSelector("[href='https://passport.yandex.com/auth?retpath=https%3A%2F%2Fmail.yandex.com']"));

        //login.click();

        //Buy
        //WebElement buy = driver.findElement(By.cssSelector(".Button2_view_action Button2_size_m"));
        //WebElement buy = driver.findElement(By.xpath("//a[contains(@class,'Button2_view_action Button2_size_m')]"));
        // WebElement buy = driver.findElement(By.linkText("Buy"));


        WebElement products = driver.findElement(By.linkText("Products"));
        WebElement solutions = driver.findElement(By.linkText("Solutions"));
        WebElement plans = driver.findElement(By.linkText("Plans"));

        WebElement getStarted = driver.findElement(By.linkText("Get started"));


    }
}
