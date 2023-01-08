import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public static AppiumDriver driver;

    public static void androidSetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("platformVersion", "7.1");
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ToDo.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
    }

    public static void iOSSetUpParallel(String port, String deviceName, String udid, String wdaLocalPort) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "16.2");
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("udid", udid);
        caps.setCapability("wdaLocalPort", wdaLocalPort);
        caps.setCapability("app", "/Users/kyudin/Downloads/DailyCheck.app");
        driver = new IOSDriver(new URL("http://localhost:"+port), caps);
    }

    public static void iOSSetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("deviceName", "iPhone X");
        caps.setCapability("isHeadless", true);
        caps.setCapability("showXcodeLog", true);
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/DailyCheck.zip");
        driver = new IOSDriver(new URL("http://localhost:4723"), caps);
    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
