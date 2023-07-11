package Task30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressBar {
    private WebDriver driver;
    private static final String PROGRESS_BAR_PAGE = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    private static final By DOWNLOAD_BUTTON = By.id("cricle-btn");
    private static final By PERCENT_TEXT = By.className("percenttext");
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PROGRESS_BAR_PAGE);
    }

    @Test
    public void progressBarTest() {
        driver.findElement(DOWNLOAD_BUTTON).click();
        WebElement percentText = driver.findElement(PERCENT_TEXT);
        new WebDriverWait(driver, 50, 100).until(ExpectedConditions.textToBePresentInElement(percentText, "50%"));
        driver.navigate().refresh();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

}
