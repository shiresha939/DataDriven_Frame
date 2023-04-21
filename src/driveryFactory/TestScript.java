package driveryFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import cammonFunctions.AddEmpPage;
import config.AppUtilPom;
import utilities.ExcelFileUtil;

public class TestScript  extends AppUtilPom{
	String inputpath ="D:\\Selenium\\DDT_Framework\\FileInput\\Employee.xlsx";
	String outputpath ="D:\\Selenium\\DDT_Framework\\OutputFile\\DataDrivenResult.xlsx";


	@Test
	public void startTest() throws Throwable
	{
		AddEmpPage emp =PageFactory.initElements(driver, AddEmpPage.class);
		//create object for Excelfile Until
		ExcelFileUtil xl =new ExcelFileUtil(inputpath);
		//count no of rows in empdata Sheet
		int rc = xl.rowcount("EmpData");
		Reporter.log("no of rows are::"+rc,true);
		for (int i=1;i<=rc;i++)
		{
			String FirstName =xl.getcelldata("EmpData", i, 0);
			String MiddleName =xl.getcelldata("EmpData", i,1);
			String LastName =xl.getcelldata("EmpData", i, 2);
			boolean res =emp.verify_Emp(FirstName, MiddleName, LastName);
			if(res)
			{
				//write as pass ino status cell
				xl.setcelldata("EmpData", i, 3, "pass", outputpath);
			}
			else
			{
				xl.setcelldata("Empdata", i, 3, "Fail", outputpath);	
			}

		}
	}

}



