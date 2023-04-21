package driveryFactory;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cammonFunctions.Functionlibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil {
	String inputpath ="D:\\Selenium\\DDT_Framework\\FileInput\\logindata.xlsx";
	String outputpath ="D:\\Selenium\\DDT_Framework\\OutputFile\\DataDrivenResult.xlsx";
	ExtentReports report;
	ExtentTest test;
	@Test
	public void starttest()throws Throwable
	{
		//create object for excel file util
		ExcelFileUtil xl =new ExcelFileUtil(inputpath);
		// cont no of rows in login sheet
		int rc=xl.rowcount("Login");
		report =new ExtentReports("./Extenreports/Login.html");

		Reporter.log("no of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			test = report.startTest("validate Login");
			test.assignAuthor("siri");
			//read user name and password cell data
			String username =xl.getcelldata("Login", i, 0);
			String password =xl.getcelldata("Login", i, 1);
			//calling login method 
			boolean res =Functionlibrary.verify_Login(username,password);
			if(res)
			{
				//if res is true write as login success into result cell
				xl.setcelldata("Login", i, 2, "Login success",outputpath);
				xl.setcelldata("Login ",i,3,"pass",outputpath);
				test.log(LogStatus.PASS, "Login success");
			}
			else 
			{
				File screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("./screenshot/iteration/"+i+"loginpage.png"));
				//if res is true write as login success into result cell
				xl.setcelldata("Login", i, 2, "Login Fail",outputpath);
				xl.setcelldata("Login", i, 3, "Fail",outputpath);
				test.log(LogStatus.FAIL ,"Login Fail");
			}
			report.endTest(test);
			report.flush();



		}
	}
}







