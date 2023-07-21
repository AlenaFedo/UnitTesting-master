package Task30;

import org.junit.jupiter.api.Assertions;
import page.LoginPage;
import page.MailPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseTest{
    private WebDriver driver;
    public static final String USERNAME = "sea123alena";
    public static final String PASSWORD = "Bazarevsky2";

    @Test
    public void loginToYandexMailTest(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginToYandex(USERNAME, PASSWORD);
        Assertions.assertTrue(loginPage.isInboxDisplayed());
    }
    @Test
    public void logoutFromMailTest(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginToYandex(USERNAME, PASSWORD);

        Assertions.assertTrue(loginPage.isInboxDisplayed());
        MailPage logoutPage = new MailPage();
        logoutPage.clickLogout();
        Assertions.assertTrue(logoutPage.isLoginButtonDisplayed());
    }
}


