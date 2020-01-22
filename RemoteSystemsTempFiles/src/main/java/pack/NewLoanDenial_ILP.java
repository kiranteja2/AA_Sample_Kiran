package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class NewLoanDenial_ILP extends AA_PDL{
	public static void NewLoanDenial_ILP(String SSN,String FileName) throws Exception{

		int lastrow=TestData.getLastRow("NewLoan");

		System.out.println("NewLoan "+lastrow);

		String sheetName="NewLoan";

		for(int row=2;row<=lastrow;row++)

		{

			String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))

			{

				String TxnType=TestData.getCellData(sheetName,"TxnType",row);

				String TenderType = TestData.getCellData(sheetName,"TenderType",row);

				String TenderType1 = TestData.getCellData(sheetName,"TenderType1",row);

				String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);	

				String ProductID=TestData.getCellData(sheetName,"ProductID",row);

				String ProductName = TestData.getCellData(sheetName,"ProductName",row);




				String SSN1 = SSN.substring(0, 3);

				String SSN2 = SSN.substring(3,5);

				String SSN3 = SSN.substring(5,9);


				Login.Login(UserName,Password,StoreId);


				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();

				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				Thread.sleep(1000);

				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.findElement(By.linkText("New Loan")).click();

				test.log(LogStatus.PASS, "Clicked on New Loan");

				driver.switchTo().frame("main");

				driver.findElement(By.name("ssn1")).sendKeys(SSN1);

				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);

				driver.findElement(By.name("ssn2")).sendKeys(SSN2);

				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);

				driver.findElement(By.name("ssn3")).sendKeys(SSN3);

				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);

				driver.findElement(By.name("submit1")).click();

				test.log(LogStatus.PASS, "Click on submit Button");

				for(String winHandle : driver.getWindowHandles()){

					driver.switchTo().window(winHandle);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("button")).click();

				test.log(LogStatus.PASS, "Click on GO Button");

				for(String winHandle : driver.getWindowHandles()){

					driver.switchTo().window(winHandle);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				String errormsg=null;
	
/*				if(driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[3]/font/b")).isDisplayed())

				{
					errormsg=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[3]/font/b")).getText();
					test.log(LogStatus.PASS,"Loan is Denial status is ::"  +errormsg);
				}
				else{
					test.log(LogStatus.FAIL,"loan is not Denial");
				}

*/

				if(driver.findElement(By.name("ShareScreenBtn")).isEnabled())
				{
			
					int rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")).size();

					test.log(LogStatus.INFO, "Rows count :: "+rows);

					for (int a=2;a<=rows;a++)
					{
						String prod = driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[2]")).getText();
						test.log(LogStatus.INFO, "Product name is :: "+prod);

						try{

							String prodElig = driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+a+"]/td[3]")).getText();
			
						
							if(prodElig.trim().equalsIgnoreCase("Eligible"))
							{
							test.log(LogStatus.INFO,"<FONT color=green style=Arial>Messsage provided in Eligible status box is::"+ prodElig);

							}
							else{
								test.log(LogStatus.INFO,"<FONT color=red style=Arial>Messsage provided in Eligible status box is::"+ prodElig);
	
							}
						}
						catch(Exception e){

						}
				
					}



				}


			}
		}
	}
}


