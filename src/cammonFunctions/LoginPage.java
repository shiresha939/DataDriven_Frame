package cammonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
//define repository for login
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement Enteruser;
	
	@FindBy(name="txtPassword")
	WebElement Enterpass;
	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement ClickLogin;
	//method for login
	public void verify_Login(String username,String password)
	{
		Enteruser.sendKeys(username);
		Enterpass.sendKeys(password);
		ClickLogin.click();
	}
	
	
	

}
