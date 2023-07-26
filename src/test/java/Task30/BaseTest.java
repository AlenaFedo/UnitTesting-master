package Task30;

import driver.WebDriverSingleton;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import page.LoginPage;
import page.MailPage;


public class BaseTest {
    public static final String USERNAME = "sea123alena";
    public static final String PASSWORD = "Bazarevsky2";
    public static final String SITE_NAME = "https://mail.yandex.com/";
    private LoginPage loginPage;
    private MailPage mailPage;
    WebDriver driver;

    @BeforeEach
    public void init() {
        driver = WebDriverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.get(SITE_NAME);
        loginPage = new LoginPage();
    }

    //@AfterEach
    public void finish() {
        WebDriverSingleton.tearDown();
    }
}
