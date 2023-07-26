package page;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        driver = WebDriverSingleton.getDriver();
    }
}
