package ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class PickerViewTest {

    public IOSDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "16.2");
        caps.setCapability("deviceName", "iPhone SE (3rd generation)");
        caps.setCapability("app", "/Users/kyudin/Downloads/UIKitCatalog.app");

        driver = new IOSDriver(new URL("http://localhost:4723"), caps);
    }

    @Test
    public void pickerViewTest() {
        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByAccessibilityId("Red color component value").sendKeys("30");
        driver.findElementByAccessibilityId("Green color component value").sendKeys("200");
        driver.findElementByAccessibilityId("Blue color component value").sendKeys("100");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
