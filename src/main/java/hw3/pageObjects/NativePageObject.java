package hw3.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign In']")
    WebElement signInBtn;
    @AndroidFindBy(id = "android:id/button1")
    WebElement okBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Register new account']")
    WebElement registerBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeTextField")
    WebElement regEmail;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeTextField")
    WebElement regUsername;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]/XCUIElementTypeSecureTextField")
    WebElement regPassword;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeSecureTextField")
    WebElement regConfirmPassword;
    @AndroidFindBy(className = "android.widget.CheckedTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='I read agreaments and agree wit it']")
    WebElement confirmCheckbox;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Register new account']")
    WebElement registerNewAccountBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeTextField")
    WebElement loginEmail;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeSecureTextField")
    WebElement loginPwd;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='platkovsky.alexey.epamtestapp:id/action_bar']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Budget']")
    WebElement actionBar;


    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
