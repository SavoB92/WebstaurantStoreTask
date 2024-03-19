package utils;


import pages.CartPage;
import pages.ProductDescriptionPage;
import pages.SearchPage;
import pages.SearchResultPage;

public class PageInitializer {
    public static SearchPage searchPage;
    public static SearchResultPage searchResultPage;

    public  static ProductDescriptionPage productDescPage;

    public  static CartPage cartPage;

    public static void initializePageObjects(){
//declaring the object
        searchPage = new SearchPage();
        searchResultPage = new SearchResultPage();
        productDescPage=new ProductDescriptionPage();
        cartPage=new CartPage();
    }
}
