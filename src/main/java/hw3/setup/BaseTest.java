package hw3.setup;

import hw3.pageObjects.PageObject;
import hw3.utils.TestContext;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    static IPageObject po;

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    public IPageObject getPo() {
        return po;
    }

    @Parameters({"platformVersion", "appiumVersion", "automationName", "platformName", "appType", "deviceName",
            "browserName", "app"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformVersion, String appiumVersion, String automationName, String platformName,
                      String appType, String deviceName,
                      @Optional("") String browserName, @Optional("") String app) throws Exception {
        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformVersion, appiumVersion, automationName, platformName, deviceName, browserName, app);
        setPageObject(appType, appiumDriver);
        TestContext.getInstance().set("platformName", platformName);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("After");
        appiumDriver.closeApp();
        appiumDriver.quit();
    }

    private void setAppiumDriver(String platformVersion, String appiumVersion, String automationName,
                                 String platformName, String deviceName, String browserName, String app) {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", platformName);
        if (app.endsWith(".apk") || app.endsWith(".ipa")) {
            caps.setCapability("appium:app", "storage:filename=" + app);  // The filename of the mobile app
        }
        caps.setCapability("appium:deviceName", deviceName);
        caps.setCapability("appium:platformVersion", platformVersion);
        caps.setCapability("appium:automationName", automationName);
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", appiumVersion);
        sauceOptions.setCapability("username", System.getProperty("USERNAME"));
        sauceOptions.setCapability("accessKey", System.getProperty("ACCESS_KEY"));
        sauceOptions.setCapability("build", "appium-build-2LITO");
        sauceOptions.setCapability("name", "<your test name>");
        caps.setCapability("sauce:options", sauceOptions);

        caps.setCapability("browserName", browserName);
        caps.setCapability("chromedriverDisableBuildCheck", "true");

        try {
            URL url = new URL(System.getProperty("ts.appium"));
            appiumDriver = new AppiumDriver(url, caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        po = new PageObject(appType, appiumDriver);
    }
}
