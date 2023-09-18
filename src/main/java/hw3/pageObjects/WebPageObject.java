package hw3.pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject {

    public static final String HOMEPAGE_URL = "https://google.com/";

    //    @FindBy(xpath = "//input[@name='q']")
    @FindBy(xpath = "//textarea[@name='q']")
    WebElement searchField;

    @FindBy(xpath = "//div[@id='rso']")
    WebElement searchResults;

    @FindBy(xpath = "//div[@id='stUuGf']/div/div[2]/div/div/div[4]/g-raised-button[2]/div")
    WebElement googleAppSuggestionDenyBtn;


    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }
}
