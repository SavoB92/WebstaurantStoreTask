package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ProductDescriptionPage extends CommonMethods {

    @FindBy(xpath = "//input[@id='buyButton']")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//a[text()='View Cart']")
    public WebElement viewCartBtn;
    public  ProductDescriptionPage(){
        PageFactory.initElements(driver, this);
    }
}
