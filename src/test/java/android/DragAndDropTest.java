package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DragAndDropTest {

    AppiumDriver driver;
    AndroidTouchAction actions;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", "/Users/kyudin/Downloads/ApiDemos.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
    }

    @Test
    public void dragAndDrop() {
        AndroidElement views = (AndroidElement) driver.findElementByAccessibilityId("Views");
        actions = new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();

        AndroidElement dragAndDrop = (AndroidElement) driver.findElementByAccessibilityId("Drag and Drop");
        actions.tap(ElementOption.element(dragAndDrop)).perform();

        AndroidElement drag = (AndroidElement) driver.findElement(By.id("drag_dot_1"));
        AndroidElement drop = (AndroidElement) driver.findElement(By.id("drag_dot_2"));

        actions.longPress(ElementOption.element(drag))
                .waitAction().moveTo(ElementOption.element(drop))
                .release()
                .perform();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
