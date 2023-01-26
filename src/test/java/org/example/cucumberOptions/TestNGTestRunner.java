package org.example.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "org.example.stepDefinitions",
        tags = "@OffersPage",
        plugin = {"html:target/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"}
)

//MVN commands
//mvn test - To run our TestRunner
//mvn test -Dtest="TestNGTestRunner" - To run TestNGTestRunner class only
//mvn test -Dcucumber.filter.tags="@PlaceOrder" - To run specific tags
//mvn test -Dcucumber.features="path/checkout.feature" - To run specific feature file
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
