package runner;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author 
 * 
 */

@CucumberOptions(features = {"src/test/java/features"} , plugin = {
		"pretty",
		"json:target/cucumber.json",
		"html:target/site/cucumber-pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
        glue = "steps",
        tags = "")
public class TestRunner extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
    
    @Test
    public void testSample() {
            System.out.println("Start!!");
    }
}
