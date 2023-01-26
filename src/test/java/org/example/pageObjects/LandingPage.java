package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LandingPage {
    private final By search = By.xpath("//input[@type='search']");
    private final By productName = By.cssSelector("h4.product-name");
    private final By topDeals = By.linkText("Top Deals");
    private final By increment = By.cssSelector("a.increment");
    private final By addToCart = By.cssSelector(".product-action button");
    public WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public String getSearchText(String name){
        return driver.findElement(search).getText();
    }

    public void incrementQuantity(int quantity){
        int i = quantity;
        while(i>1){
            driver.findElement(increment).click();
            i--;
        }
    }

    public void addToCart(){
        driver.findElement(addToCart).click();
    }

    public void waitSearchItem(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3)); //30 represents 30 secs
        wait.until(ExpectedConditions.numberOfElementsToBe(addToCart,1));
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public void selectTopDealsPage(){
        driver.findElement(topDeals).click();
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }
}
