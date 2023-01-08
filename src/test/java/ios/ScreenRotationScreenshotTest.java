package ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ScreenRotationScreenshotTest {

    private static final String APP_IOS = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.app.zip";
    private static final String APPIUM = "http://localhost:4723";

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "16.2");
        caps.setCapability("deviceName", "iPhone 14");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("app", APP_IOS);
        driver = new IOSDriver(new URL(APPIUM), caps);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testScreenMethods() throws IOException {
        ScreenOrientation currentOrientation = driver.getOrientation();
        System.out.println(currentOrientation);
        if (currentOrientation != ScreenOrientation.LANDSCAPE) {
            driver.rotate(ScreenOrientation.LANDSCAPE);
        }
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);
        File screenFile = driver.getScreenshotAs(OutputType.FILE);
        File savedFile = new File("/Users/kyudin/Downloads/screen.png");
        FileUtils.copyFile(screenFile, savedFile);
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
}
