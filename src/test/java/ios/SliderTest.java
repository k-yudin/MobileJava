package ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SliderTest {

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
        driver.findElementByAccessibilityId("Sliders").click();
        IOSElement slider = (IOSElement) driver.findElement(By.xpath("//XCUIElementTypeSlider"));
        slider.setValue("0%");
        slider.setValue("1%");
        slider.setValue("0.5%");

        Assert.assertEquals(slider.getAttribute("value"), "48%");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
