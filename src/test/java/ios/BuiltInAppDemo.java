package ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BuiltInAppDemo {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "16.2");
        caps.setCapability("deviceName", "iPhone 14 Pro");
        caps.setCapability("bundleId", "com.apple.MobileAddressBook");
        driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
    }

    @Test
    public void clickTest() {
        driver.findElementByAccessibilityId("Add").click();
        driver.findElementByAccessibilityId("First name").sendKeys("Sarah");
        driver.findElementByAccessibilityId("Last name").sendKeys("Conor");
        driver.findElementByAccessibilityId("Done").click();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
