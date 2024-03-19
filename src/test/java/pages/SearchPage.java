package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class SearchPage extends CommonMethods {
    @FindBy(xpath = "//ul[@id='awesomplete_list_1']/preceding-sibling::input")
    public WebElement searchBar;

    @FindBy(xpath = "(//button[@value='Search'])[1]")
    public WebElement searchButton;



    public SearchPage() {
        PageFactory.initElements(driver, this);
    }
}
