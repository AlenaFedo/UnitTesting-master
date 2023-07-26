package page;

import org.openqa.selenium.By;

public class MailPage extends BasePage {

    private static final By USER_NAME = By.cssSelector("a.user-account_left-name >.user-account__name");
    private static final By INBOX = By.xpath("//a[contains(@aria-label, 'Inbox')]");
    private static final By LOGOUT = By.xpath("//a[contains(@aria-label, 'Log out')]");

    public LoginPage clickLogout() {
        driver.findElement(USER_NAME).click();
        driver.findElement(LOGOUT).click();
        return new LoginPage();
    }

    public boolean isInboxDisplayed() {
        return driver.findElement(INBOX).isDisplayed();
    }
}
