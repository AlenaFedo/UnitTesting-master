package page;

import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends BasePage{

    public static final By USER_NAME = By.linkText("sea123alena");
    public static final By LOGIN_BUTTON = By.linkText("Log in");
     private static final By LOGOUT = By.xpath("//a[contains(@aria-label, 'Log out')]");

    public MailPage clickLogout() {
        driver.findElement(USER_NAME).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(LOGOUT));

        driver.findElement(LOGOUT).click();
        return this;
    }

    public boolean isLoginButtonDisplayed(){
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }
}
