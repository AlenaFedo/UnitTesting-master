package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverSingleton {

    private final static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            WebDriverManager.getInstance(ChromeDriver.class).setup();
            driver.set(new ChromeDriver());
        }
        return driver.get();
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}