package Task30;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import page.LoginPage;
import page.MailPage;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    public static final String USERNAME = "sea123alena";
    public static final String PASSWORD = "Bazarevsky2";

    private LoginPage loginPage;
    private MailPage mailPage;

    @BeforeEach
    public void login() {
        loginPage = new LoginPage();
    }

    @Test
    public void loginTest() {
        mailPage = loginPage.loginToYandex(USERNAME, PASSWORD);
        Assertions.assertTrue(mailPage.isInboxDisplayed());
    }

    @Test
    public void logoutFromMailTest() {
        mailPage = loginPage.loginToYandex(USERNAME, PASSWORD);
        loginPage = mailPage.clickLogout();
        Assertions.assertTrue(loginPage.isLoginButtonDisplayed());
    }
}


