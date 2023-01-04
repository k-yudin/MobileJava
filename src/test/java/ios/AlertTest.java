package ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AlertTest {

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
    public void okCancelAlertTest() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Okay / Cancel").click();
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void simpleAlertTest() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Simple").click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void sendTextAlertTest() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Text Entry").click();
        driver.switchTo().alert().sendKeys("Hello!!!");
        driver.switchTo().alert().accept();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
