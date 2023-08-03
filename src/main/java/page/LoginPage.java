package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(linkText = "Log in")
    private WebElement loginButton;

    @FindBy(id = "passp-field-login")
    private WebElement usernameField;

    @FindBy(css = "[data-t='field:input-passwd']")
    private WebElement passwordFied;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage typeUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordFied.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public LoginPage clickLogin() {
        loginButton.click();
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
        return loginButton.isDisplayed();
    }
}


