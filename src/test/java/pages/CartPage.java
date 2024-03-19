package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class CartPage extends CommonMethods {

    @FindBy(xpath = "//div[@class='cartItems']/div[2]/ul/li/div/div[2]/span/a")
    public List<WebElement> cartItems;


    @FindBy(xpath = "//button[text()='Empty Cart']")
    public WebElement emptyCarButton;

    @FindBy(xpath = " //button[text()='Empty']")
    public  WebElement emptyCartPopup;

    @FindBy(xpath = " //p[text()='Your cart is empty.']")
    public WebElement emptyCartMessage;

    public CartPage(){
        PageFactory.initElements(driver, this);
    }
}
