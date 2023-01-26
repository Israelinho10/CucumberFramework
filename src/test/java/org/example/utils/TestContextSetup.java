package org.example.utils;

import lombok.Data;
import org.example.pageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContextSetup {
    public String landingPageProductName;
    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.getWebDriver());
        genericUtils = new GenericUtils(testBase.driver);
    }
}
