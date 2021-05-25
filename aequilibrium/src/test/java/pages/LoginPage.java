package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author 
 * 
 */
public class LoginPage {


    @FindBy(css = "[data-test='username']")
    public WebElement userNameTextField;
    
    @FindBy(id = "password")
    public WebElement passwordTextField;
    
    @FindBy(id = "login-button")
    public WebElement loginBtn;
    
    @FindBy(css = "[data-test='error']")
    public WebElement errorMessage;
    
    public void Login(String userName, String password)
    {
    	userNameTextField.sendKeys(userName);
    	passwordTextField.sendKeys(password);
    	loginBtn.click();
    }

    
}
