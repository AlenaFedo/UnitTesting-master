package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends BasePage{

    public static final By USER_NAME = By.cssSelector("a.user-account_left-name >.user-account__name");
    public static final By LOGIN_BUTTON = By.linkText("Log in");
    public static final By INBOX = By.xpath("//a[contains(@aria-label, 'Inbox')]");
    private static final By LOGOUT = By.xpath("//a[contains(@aria-label, 'Log out')]");

    public LoginPage clickLogout() {
        driver.findElement(USER_NAME).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(LOGOUT));

        driver.findElement(LOGOUT).click();
        return new LoginPage();
    }
    public boolean isInboxDisplayed(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(INBOX));
        return driver.findElement(INBOX).isDisplayed();
    }
}
