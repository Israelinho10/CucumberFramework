package org.example.stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageObjects.LandingPage;
import org.example.pageObjects.OffersPage;
import org.example.pageObjects.PageObjectManager;
import org.example.utils.TestContextSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {

    private static String webBrowser = "chrome";
    private String offerPageProductName = "";

    public PageObjectManager pageObjectManager;

    private final TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("User searched for same shortname (.+) in offers page$")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName){
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(shortName);
        offerPageProductName = offersPage.getProductName().trim();
        System.out.println(offerPageProductName + " is extracted from Offer page");
    }

    public void switchToOffersPage() {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.switchWindowToChild();
    }

    @And("Validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_Landing_Page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName, "LandingPageProductName and OfferPageProductName are not the same");
        System.out.println("LandingPageProductName and OfferPageProductName are the same");
    }
}
