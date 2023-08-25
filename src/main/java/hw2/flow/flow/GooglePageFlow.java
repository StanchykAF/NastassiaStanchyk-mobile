package hw2.flow.flow;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import hw2.pageObjects.WebPageObject;
import hw2.setup.BaseTest;

public class GooglePageFlow extends BaseTest {

    public void openPage() {
        getDriver().get(WebPageObject.HOMEPAGE_URL); // open google.
        pageLoaded();
    }

    public void searchForTerm(String term) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPo().getWelement("searchField").clear();
        getPo().getWelement("searchField").sendKeys(term);
        getPo().getWelement("searchField").sendKeys(Keys.RETURN);
        pageLoaded();
    }

    public boolean isSearchResultRelevant(String query) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        return getPo().getWelement("searchResults").getText().contains(query);
    }

    private void pageLoaded() {
        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }
}
