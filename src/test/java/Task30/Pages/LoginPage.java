package Task30.Pages;

import Task30.WebDriverSingleton;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Task30.Locators.*;

public class LoginPage {

    public static final String USERNAME = "sea123alena";
    public static final String PASSWORD = "Bazarevsky2";
    private WebDriver driver;

    public LoginPage() {
        driver = WebDriverSingleton.getInstance();
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


    public void loginToYandex() throws InterruptedException {
        clickLogin();
        typeUsername(USERNAME);
        clickSubmit();
        Thread.sleep(5000);//implicity waiting
        typePassword(PASSWORD);
        clickSubmit();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(USER_NAME));
        Assertions.assertTrue(driver.findElement(INBOX).isDisplayed());
    }

}


