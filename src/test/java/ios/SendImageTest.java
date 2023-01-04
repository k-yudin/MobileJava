package ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SendImageTest {

    public IOSDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "16.2");
        caps.setCapability("deviceName", "iPhone 14 Pro");
        caps.setCapability("bundleId", "com.apple.mobileslideshow");
        driver = new IOSDriver(new URL("http://localhost:4723"), caps);
    }

    @Test
    public void sendImage() throws IOException {
        File image = new File("src/test/resources/image.jpg").getAbsoluteFile();
        driver.pushFile(image.getName(), image);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
