package Task30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Alerts {
    private WebDriver driver;
    private Wait<WebDriver> wait;

    private static final String ALERT_PAGE_URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    private static final By ALERT_BOX_CLICK_ME_BUTTON = By.cssSelector("[class='btn btn-default']");
    private static final By CONFIRM_BOX_CLICK_ME_BUTTON = By.cssSelector("[onclick='myConfirmFunction()']");
    private static final By CLICK_FOR_PROMPT_BOX_BUTTON = By.cssSelector("[onclick='myPromptFunction()']");

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ALERT_PAGE_URL);

        wait = new FluentWait<WebDriver>(driver);
    }


    @Test
    public void alertTest() {
        driver.findElement(ALERT_BOX_CLICK_ME_BUTTON).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @Test
    public void confirmBoxAcceptTest() {
        driver.findElement(CONFIRM_BOX_CLICK_ME_BUTTON).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
    @Test
    public void confirmBoxDismissTest() {
        driver.findElement(CONFIRM_BOX_CLICK_ME_BUTTON).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }
    @Test
    public void sendTextTest() {
        driver.findElement(CLICK_FOR_PROMPT_BOX_BUTTON).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Test3");//?????????????????????????
        alert.accept();
     }
    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

}
