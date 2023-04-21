package cammonFunctions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtil;

public class Functionlibrary extends AppUtil {
	public static boolean verify_Login(String user,String pass)
	{
		driver.get(conpro.getProperty("Url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(conpro.getProperty("objuser"))).sendKeys(user);
		driver.findElement(By.xpath(conpro.getProperty("objpass"))).sendKeys(pass);
		driver.findElement(By.xpath(conpro.getProperty("objLogin"))).click();
		String Expected = "dashboard";
		String Actual = driver.getCurrentUrl();
		if(Actual.contains(Expected))
		{
			Reporter.log("Login success::"+Expected+"      "+Actual,true);
			return true;
		}
		else 
		{
			String error_message =driver.findElement(By.xpath(conpro.getProperty("objerror"))).getText();
			Reporter.log(error_message+"     "+Expected+"    "+Actual,true);
			return false;



		}


	}
}



