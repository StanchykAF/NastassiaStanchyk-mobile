package hw3.scenarios;

import hw3.flow.GooglePageFlow;
import hw3.setup.BaseTest;
import org.testng.annotations.Test;

import static hw2.utils.PropertiesReader.readProperty;

public class WebMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that on page should be some relevant results")
    public void searchTest() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        String searchQuery = readProperty("search.term");
        GooglePageFlow googlePageFlow = new GooglePageFlow();
        googlePageFlow.openPage();
        googlePageFlow.searchForTerm(searchQuery);
        System.out.println("Page title: " + getDriver().getTitle());
        System.out.println("Search query: " + searchQuery);
        assert getDriver().getTitle().toLowerCase().contains(searchQuery.toLowerCase()) : "This page doesn't contain search results for EPAM";
        assert googlePageFlow.isSearchResultRelevant(searchQuery) :
                "There is no EPAM link on the page";
    }
}
