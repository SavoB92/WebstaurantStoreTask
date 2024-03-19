package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class SearchResultPage extends CommonMethods {
    @FindBy(xpath = "//div[@id='product_listing']/div/div/a/span")
    public List<WebElement> searchResultTable;

    @FindBy(xpath = "(//a[contains(@aria-label,'go to page ')])[last()]")
    public WebElement nextButton;

    @FindBy(xpath = "//a[contains(@aria-label,'last page')]")
    public  WebElement lastPage;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }
}
