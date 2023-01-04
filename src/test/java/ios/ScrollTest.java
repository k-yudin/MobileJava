package ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class ScrollTest {

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
    public void scrollTest() {
        HashMap<String, Object> scrollObject= new HashMap();
        scrollObject.put("direction", "down");
        scrollObject.put("value", "Web View");
        driver.executeScript("mobile:scroll", scrollObject);
        driver.findElementByAccessibilityId("Web View").click();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
