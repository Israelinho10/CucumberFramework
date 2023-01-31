package org.example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public WebDriver getWebDriver() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String url = prop.getProperty("QAUrl");
        String browser_properties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");
        String browser = browser_maven!=null ? browser_maven : browser_properties;

        if(driver==null){
            WebDriverManager.getInstance(browser.toLowerCase()).setup();
            if(browser.equalsIgnoreCase("CHROME")){
                driver = new ChromeDriver();
            } else if(browser.equalsIgnoreCase("FIREFOX")){
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.get(url);
            driver.manage().window().maximize();
        }

        return driver;
    }

    public void closeWebDriver(){
        driver.quit();
    }
}
