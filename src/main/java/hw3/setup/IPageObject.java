package hw3.setup;

import org.openqa.selenium.WebElement;

public interface IPageObject {

    WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
}
