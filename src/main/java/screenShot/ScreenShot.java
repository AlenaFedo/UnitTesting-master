package screenShot;

import driver.WebDriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShot {

    private static final String PATH = "target/screenshots/";

    public static void makeScreenShot(String filePart) {
        TakesScreenshot scrShot = ((TakesScreenshot) WebDriverSingleton.getDriver());
        File drcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String fileWithPath = PATH + generateFileName(filePart);
        File destFile = new File(fileWithPath);
        try {
            FileUtils.copyFile(drcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateFileName(String filePart) {
        LocalDateTime time = LocalDateTime.now();
        String timePrefix = DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmmss").format(time);
        return "screenshot_" + filePart + timePrefix + ".png";
    }
}
