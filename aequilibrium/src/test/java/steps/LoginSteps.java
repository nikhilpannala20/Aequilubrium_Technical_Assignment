package steps;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.GherkinKeyword;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.Base;

public class LoginSteps  extends Base {

    private  Base base;
    public LoginPage loginPage;
    
    public LoginSteps(Base base) {
        this.base = base;
        loginPage = PageFactory.initElements(Driver, LoginPage.class);
    }
    
    @Given("I navigate to Swag Labs website") 
    public void i_navigate_to_Swag_Labs_website() throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("Given"), "I navigate to Swag Labs website");
        base.openBaseURL();
    }
    
    @When("I enter username as {string}")
    public void i_enter_username_as(String username) throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("When"), "I enter username as "+username);
    	if(username.equals("empty")) {
    		username = "";
    	}
    	loginPage.userNameTextField.sendKeys(username);
    }
    
    @And("password as {string}")
    public void password_as(String password) throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("When"), "password as "+password);
    	if(password.equals("empty")) {
    		password = "";
    	}
    	loginPage.passwordTextField.sendKeys(password);
    	Thread.sleep(5000);
    }
    
    @And("I click on Login button")
    public void i_click_on_Login_button() throws Throwable {
    	scenarioDef.createNode(new GherkinKeyword("When"), "I click on Login button");
    	loginPage.loginBtn.click();
    	Thread.sleep(5000);
    }
    
    @Then("I should be able to login successfully")
    public void i_should_be_able_to_login_successfully() throws Throwable {
    	scenarioDef.createNode(new GherkinKeyword("Then"), "I should be able to login successfully");
    	Assert.assertTrue(Driver.getCurrentUrl().contains("inventory.html"));
    }
    
    @Then("I should see error message as {string}")
    public void i_should_see_error_message_as(String errorMessage) throws Throwable {
    	scenarioDef.createNode(new GherkinKeyword("Then"), "I should see error message as "+errorMessage);
    	Assert.assertTrue(loginPage.errorMessage.getText().contains(errorMessage));
    }
}
