package Task30;

import org.openqa.selenium.By;


public class Locators {

    public static final By LOGIN_BUTTON = By.linkText("Log in");
    public static final By USERNAME_FIELD = By.id("passp-field-login");
    public static final By PASSWORD_FIELD = By.className("Textinput-Control");
    public static final By SUBMIT_BUTTON = By.cssSelector("[type='submit']");
    public static final By INBOX = By.xpath("//a[contains(@aria-label, 'Inbox')]");
    public static final String SITE_NAME = "https://mail.yandex.com/";
    public static final By USER_NAME = By.linkText("sea123alena");
}
