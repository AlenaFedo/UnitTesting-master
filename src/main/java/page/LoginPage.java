package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public static final By LOGIN_BUTTON = By.linkText("Log in");
    public static final By USERNAME_FIELD = By.id("passp-field-login");
    public static final By PASSWORD_FIELD = By.className("Textinput-Control");
    public static final By SUBMIT_BUTTON = By.cssSelector("[type='submit']");
    public static final By INBOX = By.xpath("//a[contains(@aria-label, 'Inbox')]");
    public static final By USER_NAME = By.linkText("sea123alena");

    public static final String USERNAME = "sea123alena";
    public static final String PASSWORD = "Bazarevsky2";
    //private WebDriver driver;

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


    public void loginToYandex(String userName, String password){
        clickLogin();
        typeUsername(userName);
        clickSubmit();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        typePassword(password);
        clickSubmit();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(USER_NAME));
     }

    public boolean isInboxDisplayed(){
        return driver.findElement(INBOX).isDisplayed();
    }

}

