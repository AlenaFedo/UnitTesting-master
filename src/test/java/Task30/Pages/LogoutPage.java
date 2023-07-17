package Task30.Pages;

import Task30.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Task30.Locators.USERNAME_FIELD;
import static Task30.Locators.USER_NAME;

public class LogoutPage {

    private WebDriver driver;
    private static final By LOGOUT = By.xpath("//a[contains(@aria-label, 'Log out')]");
    public LogoutPage() {
        driver = WebDriverSingleton.getInstance();
    }
    public LogoutPage clickLogout() {
        driver.findElement(USER_NAME).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(LOGOUT));

        driver.findElement(LOGOUT).click();
        return this;
    }
}
