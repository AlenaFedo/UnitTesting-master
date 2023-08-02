package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(linkText = "Log in")
    private WebElement login_button;
    @FindBy(id = "passp-field-login")
    private WebElement username_field;
    @FindBy(css = "[data-t='field:input-passwd']")
    private WebElement password_fied;
    @FindBy(css = "[type='submit']")
    private WebElement submit_button;
    @FindBy(linkText = "sea123alena")
    private  WebElement user_name;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage typeUsername(String username) {
        username_field.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        password_fied.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        submit_button.click();
        return this;
    }

    public LoginPage clickLogin() {
        login_button.click();
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
        return login_button.isDisplayed();
    }
}


