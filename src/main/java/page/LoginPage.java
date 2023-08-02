package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private static final By LOGIN_BUTTON = By.linkText("Log in");
    private static final By USERNAME_FIELD = By.id("passp-field-login");
    private static final By PASSWORD_FIELD = By.cssSelector("[data-t='field:input-passwd']");
    private static final By SUBMIT_BUTTON = By.cssSelector("[type='submit']");
    private static final By USER_NAME = By.linkText("sea123alena");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage typeUsername(String username) {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        driver.findElement(SUBMIT_BUTTON).click();
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public MailPage loginToYandex(String userName, String password) {
        clickLogin();
        typeUsername(userName);
        clickSubmit();
        typePassword(password);
        clickSubmit();
        return new MailPage();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }
}


