package hw3.setup;

import hw3.pageObjects.PageObject;
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
    public AppiumDriver getDriver() { return appiumDriver; }

    public IPageObject getPo() {
        return po;
    }

    @Parameters({"automationName", "platformName","appType","deviceName","browserName","app"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String automationName, String platformName, String appType, String deviceName,
                      @Optional("") String browserName,
                      @Optional("") String app) throws Exception {
        System.out.println("Before: app type - "+appType);
        setAppiumDriver(automationName, platformName, deviceName, browserName, app);
        setPageObject(appType, appiumDriver);

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String automationName, String platformName, String deviceName, String browserName,
                                 String app){
//        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
//        capabilities.setCapability("automationName",automationName);
//        capabilities.setCapability("platformName",platformName);
//        capabilities.setCapability("deviceName",deviceName);

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", platformName);
        if(app.endsWith(".apk")) {
            caps.setCapability("appium:app", "storage:filename=" + app);  // The filename of the mobile app
        }
        caps.setCapability("appium:deviceName", deviceName);
        caps.setCapability("appium:deviceOrientation", "portrait");
        caps.setCapability("appium:platformVersion", "13.0");
        caps.setCapability("appium:automationName", automationName);
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "1.22.3");
        sauceOptions.setCapability("username", System.getProperty("username"));
        sauceOptions.setCapability("accessKey", System.getProperty("accessKey"));
        sauceOptions.setCapability("build", "appium-build-2LITO");
        sauceOptions.setCapability("name", "<your test name>");
        caps.setCapability("sauce:options", sauceOptions);

        caps.setCapability("browserName", browserName);
        caps.setCapability("chromedriverDisableBuildCheck","true");

        try {
//            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
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
