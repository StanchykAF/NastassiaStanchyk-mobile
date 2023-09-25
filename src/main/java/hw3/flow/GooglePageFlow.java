package hw3.flow;

import hw3.pageObjects.WebPageObject;
import hw3.setup.BaseTest;
import hw3.utils.TestContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePageFlow extends BaseTest {

    public void openPage() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getDriver().get(WebPageObject.HOMEPAGE_URL); // open google.
        pageLoaded();
        if (TestContext.getInstance().get("platformName", String.class).equals("iOS")) {
            getPo().getWelement("googleAppSuggestionDenyBtn").click();
        }
    }

    public void searchForTerm(String term) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        pageLoaded();
        getPo().getWelement("searchField").clear();
        getPo().getWelement("searchField").sendKeys(term);
        if (TestContext.getInstance().get("platformName", String.class).equals("Android")) {
            getPo().getWelement("searchField").sendKeys(Keys.RETURN);
        } else {
            new WebPageObject(getDriver()).getSearchSuggestions().stream()
                    .filter(suggestion -> suggestion.getText().equalsIgnoreCase(term))
                    .findFirst()
                    .ifPresent(WebElement::click);
            pageLoaded();
            getPo().getWelement("closeGoogleWidgetSuggestionBtn").click();
        }
    }

    public boolean isSearchResultRelevant(String query) {
        pageLoaded();
        return new WebPageObject(getDriver()).getSearchResults().stream()
                .allMatch(res -> {
                    System.out.println("\nResult:\n" + res.getText());
                    return res.getText().contains(query);
                });
    }

    private void pageLoaded() {
        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 20).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }
}
