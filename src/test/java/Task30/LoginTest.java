package Task30;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import page.LoginPage;
import page.MailPage;
import org.junit.jupiter.api.Test;
import screenShot.ScreenShot;

public class LoginTest extends BaseTest {

    private static final String USERNAME = "sea123alena";
    private static final String PASSWORD = "Bazarevsky2";
    private String homePage = "HomePage";
    private MailPage mailPage;

    @BeforeEach
    public void login() {
        loginPage = new LoginPage();
    }

    @Test
    public void loginTest(){
        ScreenShot.makeScreenShot(homePage);
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


