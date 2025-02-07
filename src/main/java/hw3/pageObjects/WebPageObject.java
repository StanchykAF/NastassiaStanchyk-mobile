package hw3.pageObjects;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class WebPageObject {

    public static final String HOMEPAGE_URL = "https://google.com/";

    @FindBy(xpath = "//textarea[@name='q']")
    WebElement searchField;

    @FindBy(xpath = "//div[@id='rso']/div")
    List<WebElement> searchResults;

    @FindBy(xpath = "//div[@id='stUuGf']/div/div[2]/div/div/div[4]/g-raised-button[2]/div")
    WebElement googleAppSuggestionDenyBtn;

    @FindBy(xpath = "//li[@role='presentation']/div[@role='option']")
    List<WebElement> searchSuggestions;

    @FindBy(xpath = "//div[@id='stUuGf']/div/div[2]/div/div/div[3]/span")
    WebElement closeGoogleWidgetSuggestionBtn;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }
}
