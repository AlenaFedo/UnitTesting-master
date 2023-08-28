package Task30;

import driver.WebDriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import page.LoginPage;

public class BaseTest {

    public static final String SITE_NAME = "https://mail.yandex.com/";
    protected LoginPage loginPage;

    @BeforeEach
    public void init(){
        WebDriver driver = WebDriverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.get(SITE_NAME);
        loginPage = new LoginPage();
    }

    @AfterEach
    public void finish() {
        WebDriverSingleton.tearDown();
    }
}
