package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.SearchResultPage;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class SearchAndCartManagement extends CommonMethods {

    @Given("user is on WebstaurantStore homepage")
    public void user_is_on_webstaurant_store_homepage() {
        openBrowserAndLaunchApplication();
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String searchContext) {
        sendText(searchContext, searchPage.searchBar);
        click(searchPage.searchButton);
    }

    @Then("they should see only items with {string} in the title")
    public void they_should_see_only_items_with_in_the_title(String expectedTitleContains)  {
        int noOfPages = Integer.parseInt(searchResultPage.lastPage.getText());
            List<String> errorMessages = new ArrayList<>();
            for (int i = 1; i <= noOfPages; i++) {
                List<WebElement> searchResults = searchResultPage.searchResultTable;
                for (WebElement item : searchResults) {
                    String itemTitle = item.getText();
                    if (!itemTitle.contains(expectedTitleContains)) {
                        errorMessages.add("Failure on page " + i + ": Item title '" + itemTitle + "' does not contain the word '" + expectedTitleContains + "'.");
                    }
                }
                if (i < noOfPages) {
                    click(searchResultPage.nextButton);
                }
            }

            if (!errorMessages.isEmpty()) {
                Assert.fail("Some items do not contain the expected word:\n" + String.join("\n", errorMessages));
            }
        }


    @When("the user navigates to the last page")
    public void the_user_navigates_to_the_last_page() {
        click(searchResultPage.lastPage);
    }
private String lastItemTitle;
    @When("the user adds the last item found to the cart")
    public void the_user_adds_the_last_item_found_to_the_cart() {
        List<WebElement> searchResult = searchResultPage.searchResultTable;
        WebElement lastElement = searchResult.get(searchResult.size() - 1);
       lastItemTitle = lastElement.getText();
        click(lastElement);
        click(productDescPage.addToCartBtn);
    }
    @When("the user clicks on view cart button")
    public void the_user_clicks_on_view_cart_button() {
        click(productDescPage.viewCartBtn);
    }
    @Then("the last item should be in the cart")
    public void the_last_item_should_be_in_the_cart() {
     String itemInCartTitle=cartPage.cartItems.get(0).getText();
     Assert.assertEquals("The item in the cart does not match the last item added.", lastItemTitle, itemInCartTitle);
       }

    @When("the user empties the cart")
    public void the_user_empties_the_cart() {
      click(cartPage.emptyCarButton);
      click(cartPage.emptyCartPopup);
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        String emptyCartMsg = cartPage.emptyCartMessage.getText();
        Assert.assertEquals("Expected the cart to be empty.", "Your cart is empty.", emptyCartMsg);
    }

}
