package config;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
	public static WebDriver driver;
	public static Properties conpro;
	@BeforeTest
	public static void setup()throws Throwable
	{
		conpro=new Properties();
		conpro.load(new FileInputStream("D:\\Selenium\\DDT_Framework\\PropertyFile\\Environment.properties"));
		if (conpro.getProperty("Browser").equalsIgnoreCase("chorme")) 
		{
			driver=new ChromeDriver();
		}
		else if (conpro.getProperty("Browser").equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else 
		{
			Reporter.log("Browser key value not matching",true);
		}
	}
		@AfterTest
	public static void teardown()
	{
		driver.quit();
		
	
			
	}
	}
		
		
			
		
