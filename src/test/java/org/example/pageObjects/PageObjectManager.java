package org.example.pageObjects;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public LandingPage landingPage;
    public OffersPage offersPage;

    public CheckoutPage checkoutPage;

    public LandingPage getLandingPage(){
        landingPage = new LandingPage(driver);
        return landingPage;
    }

    public OffersPage getOffersPage(){
        offersPage = new OffersPage(driver);
        return offersPage;
    }

    public CheckoutPage getCheckoutPage(){
        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }
}
