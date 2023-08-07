package screenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShot {

    private static String path = "C://ScreenShots//";

    public static void makeScreenShot(WebDriver webdriver, String filePart) {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String fileWithPath = path + generateFileName(filePart);
        File DestFile = new File(fileWithPath);
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateFileName(String filePart) {
        LocalDateTime time = LocalDateTime.now();
        String timePrefix = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(time);
        return "screenshot_" + filePart + timePrefix + ".png";
    }
}
