package page;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    public static final String SITE_NAME = "https://mail.yandex.com/";
    public BasePage(){
        driver = WebDriverSingleton.getInstance();

        driver.manage().window().maximize();
        driver.get(SITE_NAME);
    }
}
