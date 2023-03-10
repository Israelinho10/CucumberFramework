package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {
    public WebDriver driver;

    public By cartBag = By.cssSelector("[alt='Cart']");
    public By checkoutButton = By.xpath("//button[contains(text(),'PROCEED')]");
    public By promoBtn = By.cssSelector(".promoBtn");
    public By placeOrderButton = By.xpath("//button[contains(text(),'Place')]");

    public By productNameTable = By.cssSelector("p.product-name");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkoutItems(){
        //ADDED A COMMENT HERE
        //ADDED A SECOND COMMENT
        System.out.println("ERROR");
        driver.findElement(cartBag).click();
        driver.findElement(checkoutButton).click();
    }

    public boolean verifyPromoBtn(){
        return driver.findElement(promoBtn).isDisplayed();
    }

    public boolean verifyPlaceOrder(){
        return driver.findElement(placeOrderButton).isDisplayed();
    }

    public String getProductName(){
        return driver.findElement(productNameTable).getText();
    }

}
