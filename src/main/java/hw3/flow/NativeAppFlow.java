package hw3.flow;

import hw3.dto.User;
import hw3.setup.BaseTest;
import hw3.utils.TestContext;
import org.openqa.selenium.WebElement;

public class NativeAppFlow extends BaseTest {

    public void registration(User user) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPo().getWelement("registerBtn").click();
        getPo().getWelement("regEmail").sendKeys(user.getEmail());
        getPo().getWelement("regUsername").sendKeys(user.getUsername());
        getPo().getWelement("regPassword").sendKeys(user.getPassword());
        getPo().getWelement("regConfirmPassword").sendKeys(user.getPassword());
        if (TestContext.getInstance().get("platformName", String.class).equals("Android")) {
            getDriver().hideKeyboard();
        } else {
            // Additional clicking on register new account button for iOS app
            getPo().getWelement("registerNewAccountBtn").click();
        }
        getPo().getWelement("registerNewAccountBtn").click();
    }

    public void login(User user) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPo().getWelement("loginEmail").sendKeys(user.getEmail());
        getPo().getWelement("loginPwd").sendKeys(user.getPassword());
        getPo().getWelement("signInBtn").click();
    }

    public String getPageTitle() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        WebElement actionBar = getPo().getWelement("actionBar");
        return TestContext.getInstance().get("platformName", String.class).equals("Android") ?
                actionBar.getText() : actionBar.getAttribute("value");
    }
}
