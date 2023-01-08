package android;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CallSMSTest {

    private static final String PHONE_NUMBER = "5551237890";
    private static final String APPIUM = "http://localhost:4723";
    private static final String APP_ANDROID = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk";

    private By VERIFY_SCREEN = MobileBy.AccessibilityId("Verify Phone Number");
    private By SMS_WAITING = MobileBy.xpath("//android.widget.TextView[contains(@text, 'Waiting to receive')]");
    private By SMS_VERIFIED = MobileBy.xpath("//android.widget.TextView[contains(@text, 'verified')]");

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("app", APP_ANDROID);
        driver = new AndroidDriver(new URL(APPIUM), caps);
    }

    @Test
    public void sendSMSMakePhoneCall() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElementByAccessibilityId("Login Screen").click();
        driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.CALL);
        Thread.sleep(2000);
        driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.ACCEPT);
        driver.findElementByAccessibilityId("username").sendKeys("abcd");
        Thread.sleep(2000);
        driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.CANCEL);
        driver.navigate().back();

        wait.until(ExpectedConditions.presenceOfElementLocated(VERIFY_SCREEN)).click();
        wait.until((ExpectedConditions.presenceOfElementLocated(SMS_WAITING)));
        driver.sendSMS(PHONE_NUMBER, "Your code is: 12345678");
        wait.until(ExpectedConditions.presenceOfElementLocated(SMS_VERIFIED));
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
