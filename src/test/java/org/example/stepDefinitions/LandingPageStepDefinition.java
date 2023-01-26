package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pageObjects.LandingPage;
import org.example.utils.TestContextSetup;
import org.testng.Assert;

public class LandingPageStepDefinition {

    public LandingPage landingPage;
    private final TestContextSetup testContextSetup;

    private final String landingPageTitle = "GreenKart";

    public LandingPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_landing_page(){
        Assert.assertTrue(landingPage.getTitleLandingPage().contains(landingPageTitle));
    }

    @When("User searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(String shortName){
        landingPage.searchItem(shortName);
        landingPage.waitSearchItem();
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Landing page");
    }

    @And("Added {string} items of the selected product to cart")
    public void added_items_product(String quantity){
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }
}
