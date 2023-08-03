package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends BasePage {

    @FindBy(css = "a.user-account_left-name >.user-account__name")
    private WebElement userName;

    @FindBy(xpath = "//a[contains(@aria-label, 'Inbox')]")
    private WebElement inbox;

    @FindBy(xpath = "//a[contains(@aria-label, 'Log out')]")
    private WebElement logout;

    public MailPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLogout() {
        userName.click();
        logout.click();
        return new LoginPage();
    }

    public boolean isInboxDisplayed() {
        return inbox.isDisplayed();
    }
}