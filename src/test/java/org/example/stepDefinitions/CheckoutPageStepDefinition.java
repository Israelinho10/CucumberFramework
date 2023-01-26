package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.CheckoutPage;
import org.example.pageObjects.LandingPage;
import org.example.utils.TestContextSetup;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPageStepDefinition {
    private final TestContextSetup testContextSetup;
    public CheckoutPage checkoutPage;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @And("Verify user has ability to enter promo codee and place the order")
    public void verify_user_has_ability_enter_promo(){
        Assert.assertTrue(checkoutPage.verifyPromoBtn());
        Assert.assertTrue(checkoutPage.verifyPlaceOrder());
    }

    @Then("User proceeds to Checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout(String name){
        checkoutPage.checkoutItems();
        Assert.assertTrue(checkoutPage.getProductName().contains(name));
    }

}
