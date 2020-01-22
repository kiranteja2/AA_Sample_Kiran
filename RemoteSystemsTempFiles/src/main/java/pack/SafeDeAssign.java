package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class SafeDeAssign extends AA_PDL {
	public static void SafeDeAssign(String SSN,String FileName) throws Exception{

		////Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL/"+FileName);
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/PDL_Regression_Prod/"+FileName);
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
				String ProductID=TestData.getCellData(sheetName,"ProductID",row);
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				//String UserName = TestData.getCellData(sheetName,"UserName",row);
				//String Password = TestData.getCellData(sheetName,"Password",row);
				//String StoreId = TestData.getCellData(sheetName,"StoreId",row);

				Login.Login(UserName, Password, StoreId);
				Thread.sleep(2000);
				driver.switchTo().defaultContent();				
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Cash Management");
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.linkText("Safe")).click();
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "Clicked on Assign");	
				driver.findElement(By.linkText("Deassign")).click();
				test.log(LogStatus.PASS, "Clicked on DeAssign");
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				//name="safeDeassignRequestBean.noOf100Dollars"
				driver.findElement(By.name("safeDeassignRequestBean.noOf100Dollars")).sendKeys("0");
				test.log(LogStatus.PASS, "safeAssignRequestBean.noOf100Dollars entered is  0");
				driver.findElement(By.name("safeDeassignRequestBean.password")).sendKeys(Password);
				test.log(LogStatus.PASS, "Password is Entered ");
				driver.findElement(By.name("safedeassign")).click();
				test.log(LogStatus.PASS, "Clicked on Safe DeAssigen Button");

				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();

				}
				catch (NoAlertPresentException e) {

				}
				try{
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(2000);
					if(AA_TN_PDL.Field(driver) != null )
					{
					driver.findElement(By.name("safeDeassignRequestBean.password")).clear();
					driver.findElement(By.name("safeDeassignRequestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is Entered ");
					driver.findElement(By.name("safedeassign")).click();
					test.log(LogStatus.PASS, "Clicked on Safe DeAssigen Button");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(2000);
					//	name="safeRequestBean.safeOverShort"
					String SafeOverShortAmt = driver.findElement(By.name("safeRequestBean.safeOverShort")).getAttribute("value");	
					// safeRequestBean.amount
					driver.findElement(By.name("safeRequestBean.amount")).sendKeys(SafeOverShortAmt);
					test.log(LogStatus.PASS, "safeRequestBean amount is entered as :: "+SafeOverShortAmt);
					//safeRequestBean.primary
					driver.findElement(By.name("safeRequestBean.primary")).sendKeys("Counterfeit Bill");
					test.log(LogStatus.PASS, "Primary reason for Deassign is entered as :: Counterfeit Bill");
					// safeRequestBean.notes
					driver.findElement(By.name("safeRequestBean.notes")).sendKeys("Safe DeAssign for Counterfeit Bill");
					test.log(LogStatus.PASS, "Notes entered is ::Safe DeAssign for Counterfeit Bill");
					driver.findElement(By.name("bt_AddDrawer")).click();
					test.log(LogStatus.PASS, "Clicked on Add O/S  Button");
					driver.findElement(By.name("transactionDataBean.password")).clear();
					driver.findElement(By.name("transactionDataBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is Entered ");
					driver.findElement(By.xpath("//input[@value='Finish Safe O/S' and @type='button']")).click();
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();

					}
					catch (NoAlertPresentException e) {

					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@value='Ok' and @type='submit']")).click();
				}
				}

				catch (NoAlertPresentException e) {

				}
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				Thread.sleep(2000);
		/*		try { 
					driver.findElement(By.xpath("//input[@value='Ok' and @type='submit']")).click();

				}
				catch (NoAlertPresentException e) {

				}*/
			
				// finishdeposit
			}
			
		}
}
