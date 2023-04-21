package cammonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmpPage {
WebDriver driver;
//constructor
public AddEmpPage(WebDriver driver)
{
	this.driver=driver;
}
//define repository
@FindBy(xpath = "//b[normalize-space()='PIM']")
WebElement Clickpim;
@FindBy(name="btnAdd")
WebElement CliclAddBtn;
@FindBy(name = "firstName")
WebElement EnterFname;
@FindBy(name = "middleName")
WebElement EnterMname;
@FindBy(name = "lastName")
WebElement EnterLname;
@FindBy(xpath = "//input[@id='employeeId']")
WebElement BeforEid;
@FindBy(xpath = "//input[@id='btnSave']")
WebElement ClickSaveBtn;
@FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
WebElement AfterEid;
public boolean verify_Emp(String fname,String mname,String lname)
{
	Actions ac = new Actions(driver);
	ac.moveToElement(Clickpim).click().perform();
	ac.moveToElement(this.CliclAddBtn).click().perform();
	this.EnterFname.sendKeys(fname);
	this.EnterMname.sendKeys(mname);
	this.EnterLname.sendKeys(lname);
	//capture eid
	String ExpectedEid =this.BeforEid.getAttribute("value");
	ac.moveToElement(this.ClickSaveBtn).click().perform();
	String ActualEid =this.AfterEid.getAttribute("value");
	if (ExpectedEid.equals(ActualEid)) 
	{
		Reporter.log("Add Employee success::"+ExpectedEid+"   "+ActualEid,true);
		return true;
	}
	else 
	{
		Reporter.log("Add Employee Fail::"+ExpectedEid+"   "+ActualEid,true);
		return false;
		
		
	}
		
		
	}
	
	
}









 







