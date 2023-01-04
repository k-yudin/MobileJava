package android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ClipboardTest {

    AndroidDriver<WebElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", "/Users/kyudin/Downloads/selendroid.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
    }

    @Test
    public void clipboardTest() {
        String text = "Hello!";
        driver.setClipboardText(text);
        MobileElement nameText = (MobileElement) driver.findElementByAccessibilityId("my_text_fieldCD");
        nameText.clear();
        nameText.sendKeys(driver.getClipboardText());

        Assert.assertEquals(text, nameText.getText());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
