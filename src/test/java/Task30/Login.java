package Task30;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class Login {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\SeleniumTasks\\SeleniumJavaTraining\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }


    @Test
    public void task() {
        driver.get("https://mail.yandex.com/");

        WebElement login = driver.findElement(By.xpath("//a[contains(@class,'Button2_view_default Button2_size_m')]"));
        login.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id ='passp-field-login']"));
        userName.sendKeys("sea123alena");

        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        WebElement password = driver.findElement(By.xpath("//input[@id ='passp-field-passwd']"));
        password.sendKeys("Bazarevsky1");

        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//a[contains(@aria-label, 'Inbox')]")).isDisplayed());
    }

    @AfterEach
    public void clenUp(){
        driver.quit();
    }
}


