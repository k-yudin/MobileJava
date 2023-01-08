package ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RealDeviceTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "15.1");
        caps.setCapability("deviceName", "Konstantin Yudin’s iPad");
        caps.setCapability("xcodeOrgId", "kyudin@mail.com");
        caps.setCapability("xcodeSigningId", "iPhone Developer");
        caps.setCapability("udid", "40b6b6bf3b1530f59d69f0ff3e80ae31f73d0dbf");
        caps.setCapability("appium:useNewWDA", true);
        caps.setCapability("appium:derivedDataPath", "/Users/kyudin/Library/Developer/Xcode/DerivedData/WebDriverAgent-eecgabsjhqcpozfkvfxzogkzcaly");
        caps.setCapability("app", "/Users/kyudin/Downloads/UIKitCatalog.app");
        driver = new IOSDriver(new URL("http://localhost:4723"), caps);
    }

    @Test
    public void clickAppButton() {
        driver.findElementByAccessibilityId("Buttons").click();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
