package Task30;

import org.openqa.selenium.By;


public class Locators {

    public static final By LOGIN_BUTTON = By.xpath("//a[contains(@class,'Button2_view_default Button2_size_m')]");
    public static final By USERNAME_FIELD = By.id("passp-field-login");
    public static final By PASSWORD_FIELD = By.xpath("//input[@id ='passp-field-passwd']");
    public static final By SUBMIT_BUTTON = By.xpath("//button[contains(@class,'submit')]");
    public static final By INBOX = By.xpath("//a[contains(@aria-label, 'Inbox')]");

}
