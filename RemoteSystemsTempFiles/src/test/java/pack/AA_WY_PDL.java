	package pack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*import Test.CO_ILP.Need;
import Test.CO_ILP.scenario;*/
import pack.*;
import pack.Void;
import bsh.*;
//import scala.collection.Iterator;
//import scala.collection.Set;

//import Pages.HomePage;
//import Pages.LoginPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;
import java.io.FileReader;

public class AA_WY_PDL extends AA_PDL{

	
	
	

	@Test(priority=0,groups = "kiran_WY_PDL")  


	  public void BorrRegistration_NewLoan() throws Exception 
		{
			String FileName= "AA_BorrRegistration_NewLoan_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.No 01 : BorrowerRegistration_NewLoan_"+Header, "New Loan");
					
					
					Login.Login(UserName,Password,StoreId);				
					//RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
				}		
			}
		}
		
		
	
	@Test(priority=1,groups = "kiran_WY_PDL")

		public void BorrowerNewLoan_Rule() throws Exception 
		{
			String FileName= "AA_BorrowerRegistration_NewLoanRule_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{	
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:02:BorrowerRegistration_NewLoan_Rule"+Header, "New Loan_Maximum Open Loan");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					NewLoanRule.NewLoanRule(SSN, FileName);
				}
			}
		}

@Test(priority=2,groups = "kiran_WY_PDL")

	  	public void NewLoan_Biweekly_Duedate() throws Exception 
		{
			String FileName= "AA_NewLoan_BiweeklyDue_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:03:NewLoan_Biweekly_Duedate_"+Header, "Biweekly_Duedate");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);			
					NewLoan.NewLoan_WY(SSN, FileName);
					Biweekly_duedate.Biweekly_duedate(SSN, FileName);
					
				}
			}
			//Login.Login("CSR353","1234","353");
		}
		 
@Test (priority=3,groups = "kiran_WY_PDL")

	  	public void NewLoan_Monthly_Duedate() throws Exception
	   {
			String FileName= "AA_NewLoan_MonthlyDue_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(" S.NO:04:AA_NewLoan_MonthlyDue_Txn_Testdata"+Header, "AA_NewLoan_MonthlyDue_Txn_Testdata");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					Monthly_duedate.Monthly_duedate(SSN, FileName);
					
				}
			}
			//Login.Login("CSR353","1234","353");
		}

@Test (priority=4,groups = "kiran_WY_PDL") // Semi monthly has issue with loandate and duedate, so Not executing scenario.scenario , Not Ran in Staging

		public void NewLoan_SemiMonthly_Duedate() throws Exception
	       {
			String FileName= "AA_NewLoan_SemiDue_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:05:NewLoan_SemiMonthly_Duedate_"+Header, "SemiMonthly_Duedate");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					semimonthly_duedate.semimonthly_duedate(SSN, FileName);
					//WebDriverWait wait = new WebDriverWait(driver, 10);
					//wait(100);
					// RegistrationPage.RegistrationPage(SSN);
				}
			}
			//Login.Login("CSR353","1234","353");
		}
	 
@Test(priority=5,groups = "kiran_WY_PDL")

		public void NewLoan_Weekly_Duedate() throws Exception 
		{
			String FileName= "AA_NewLoan_WeeklyDue_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:06:NewLoan_"+Header, "Weekly_Duedate");
					


					Login.Login(UserName,Password,StoreId);			
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					Weekly_duedate.Weekly_duedate(SSN, FileName);

	              }
			}

		}

@Test(priority=6,groups = "kiran_WY_PDL")

		public void VerifyLoanAmount() throws Exception 
		{
			String FileName= "AA_BorrowerRegistration_VerifyLoanAmount_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);	
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"_S.NO:07:"+"_"+PayFrequency+"_"+CollateralType,"Login_Home screen_Borrower_Registration_verify whether loan amount is based on Customer Income or not");
					
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan_CustomerIncome.NewLoan_CustomerIncome(SSN, FileName);

				}
			}

		}

@Test(priority=7,groups = "kiran_WY_PDL")

		public void Newloan_MultipullDisb() throws Exception
		{
			String FileName= "AA_Newloan_MultipullDisb_Types.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName); 	
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:08:AA_Newloan_MultipullDisb_Type"+Header, "AEA_Newloan_MultipullDisb_Type");
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan_MultipulDisbTypes.NewLoan_MultipulDisbTypes(SSN, FileName);
				}
			}
		}

@Test(priority=8,groups = "kiran_WY_PDL")

		public void NewLoan_Void() throws Exception {

		
			String FileName= "AA_VoidLoan_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	

					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;

					
					test = reports.startTest("S.NO:09:AA_Void_"+Header, "Loan_Txn");
									
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					Void.Void(SSN, FileName);
				
				}
			}
			
		}


@Test(priority=9,groups = "kiran_WY_PDL")

		public void NewLoan_VoidEncryptionKey() throws Exception 
		{
			String FileName= "AA_NewLoan_VoidEncryptionKey_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				//System.out.println(RunFlag);
				if(RunFlag.equals("Y"))
				{	
					//driver.get(appUrl);
					//test.log(LogStatus.INFO, "Application is launched");
					//driver.manage().window().maximize();
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"_S.No:10"+"_"+PayFrequency+"_"+CollateralType,"Loan_void on next day with encryption key");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName); 
					LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,3);
					EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
					
					
				}
			}
			//Login.Login("CSR353","1234","353");

		}

@Test (priority=10,groups = "kiran_WY_PDL") 

		public void Rescind() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_RescindLoan_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				
				if(RunFlag.equals("Y"))
				{	

					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:11:AA_Rescind_"+Header, "Loan_Txn");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					Rescind.Rescind(SSN, FileName);
					
				}
			}


		}

@Test(priority=11,groups = "kiran_WY_PDL")

		public void Rescind_AgeStore() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_RescindLoan_Agestore_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				//System.out.println(RunFlag);
				if(RunFlag.equals("Y"))
				{	
					//driver.get(appUrl);
					//test.log(LogStatus.INFO, "Application is launched");
					//driver.manage().window().maximize();
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest("S.NO:12:RescindLoan_"+Header, "NewLoan_Agestore_Rescind");
					

					
					Login.Login(UserName,Password,StoreId);
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,1);
					Rescind.Rescind(SSN, FileName);


				}
			}

		}

@Test(priority=12,groups = "kiran_WY_PDL")

		public void Partialpayment_void() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_Partialpayment_void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				//System.out.println(RunFlag);
				if(RunFlag.equals("Y"))
				{	
					//driver.get(appUrl);
					//test.log(LogStatus.INFO, "Application is launched");
					//driver.manage().window().maximize();
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"S.NO:13:_Partialpayment_void"+"_"+PayFrequency+"_"+CollateralType,"Loan_Age the store up to some days before due date_Partial Payment_Void");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-4);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName); 
					Partialpayment_Void.Partialpayment_Void(SSN, FileName);
					
				}
			}
			

		}

		@Test(priority=13,groups = "kiran_WY_PDL")

		public void Partialpayment_agestorevoid() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_Partialpayment_Agestorevoid_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{	

					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"S.NO:14:_Partialpayment_Agestorevoid"+"_"+PayFrequency+"_"+CollateralType,"Loan_Age the store up to some days before due date_Partial Payment_age the store up to 1 day_Void with encryption");
					
					
						
			 		Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);			
					NewLoan.NewLoan_WY(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-4);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-1);
					PartialPaymentVoidEncryptionKey.PartialPaymentVoidEncryptionKey(SSN, FileName);

				}
			}

		}
		
		
@Test(priority=14,groups = "kiran_WY_PDL")

		public void NewLoanMultiDisb_Void() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_NewLoanMultiDIsb_Void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName); 	
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				//System.out.println(RunFlag);
				if(RunFlag.equals("Y"))
				{	
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:15:NewLoanMultiDisb_Void_"+Header, "Void New Loan");
					
					
					
					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan_MultipulDisbTypes.NewLoan_MultipulDisbTypes(SSN, FileName);
					Void.Void(SSN, FileName);
				}
			}
		}

@Test(priority=15,groups = "kiran_WY_PDL")

		public void NewLoanMultipledisbursement_AgestoreVoid() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_NewLoanMultiDIsb_AgeStore_Void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
			
				if(RunFlag.equals("Y"))
				{	
					
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
				
					test = reports.startTest(Header+"_S.No:16"+"_"+PayFrequency+"_"+CollateralType,"loan with multiple disbursement (cash& check)_void with cash(Next day with encryption)");
					
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan_MultipulDisbTypes.NewLoan_MultipulDisbTypes(SSN, FileName);
					LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,1);
					EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
					
				}
			}
			//Login.Login("CSR353","1234","353");

		}



@Test(priority=17,groups = "kiran_WY_PDL") 
		
		public void NewLoan_AgeStore_BuyBack() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_NewLoan_Agestore_BuybackLoan_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName); 	
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				//System.out.println(RunFlag);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:18:AEA_NewLoan_Agestore_BuybackLoan_Txn"+Header, "AEA_NewLoan_Agestore_BuybackLoan_Txn");
					
					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-4);
					Buyback.Buyback(SSN, FileName);
				}
			}
		}

@Test(priority=18,groups = "kiran_WY_PDL") 

		public void BuyBack_Void() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_BuybackLoan_Void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName); 	
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);			
				if(RunFlag.equals("Y"))
				{	
					
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:19:AA_BuybackLoan_"+Header, "Void_Txn");
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,0);
					Buyback.Buyback(SSN, FileName); 
					BuybackVoid.BuybackVoid(SSN, FileName);
				}
			}
		}


@Test (priority=19,groups = "kiran_WY_PDL")


		public void Byback_agestore_void() throws Exception
		{
			String FileName= "AA_Byback_Agestore_void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"S.NO:20:_AA_Byback_Agestore_void"+"_"+PayFrequency+"_"+CollateralType,"Loan_Age the store_Perform the Buyback_Void on next day");
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,0);
					Buyback.Buyback(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,1);
					AgeStore_Buyback_encryptionKeyVoid.AgeStore_Buyback_encryptionKeyVoid(SSN, FileName, 1);
					Byback_AgestoreVoid.Byback_AgestoreVoid(SSN, FileName);
				}
			}
		}

@Test(priority=20,groups = "kiran_WY_PDL")//Completed

		public void VerifyBuyBack_TotalDue() throws Exception
		{
			String FileName= "AA_VerifyBuyBack_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{	
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:21:VerifyBuyBack_"+Header, "VerifyBuyBack");
					
					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,0);
					Buyback.Buyback(SSN, FileName);
				}
			}
		}

@Test(priority=21,groups = "kiran_WY_PDL") //Completed//  	As per product config Min term is 7 days for any pay frequency, but loan issued for 4 days.

		public void PartialPayment_BuyBack() throws Exception 
		{

			
			String FileName= "AA_PartialPayment_BuyBack_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{	

					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:22:AA_PartialPayment_BuyBack_"+Header, "NewLoan_AgeStore_PartialPayment_AgeStore_BuyBack");
					
					
					Login.Login(UserName,Password,StoreId);
				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-4);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, +4);
					Buyback.Buyback(SSN, FileName);
				}
			}
		}

@Test(priority=22,groups = "kiran_WY_PDL")//Completed

		public void PartialPayment_BuyBack_Void() throws Exception {

			// Start test. Mention test script name
			String FileName= "AA_PartialPayment_BuyBack_Void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				//System.out.println(RunFlag);
				if(RunFlag.equals("Y"))
				{	
					//driver.get(appUrl);
					//test.log(LogStatus.INFO, "Application is launched");
					//driver.manage().window().maximize();
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					// System.out.println(Password);
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					//System.out.println(SSN);
					test = reports.startTest("S.NO:23:AA_PartialPayment_BuyBack_Void_"+Header, "NewLoan_AgeStore_PartialPayment_AgeStore_BuyBack_Void");
					
					Login.Login(UserName,Password,StoreId);
									
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					//AgeStore.AgeStore(SSN, FileName,-4);
					LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,3);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, +4);
					Buyback.Buyback(SSN, FileName);
				    BuybackVoid.BuybackVoid(SSN, FileName);
					
				}
			}
			
		}

@Test(priority=23,groups = "kiran_WY_PDL")//Completed
		
	    public void PartialPayment_BuyBackChange_Void() throws Exception {

			
			String FileName= "AA_PartialPayment_BuyBackChange_Void_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName); 
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:24:AA_PartialPayment_BuyBackChange_Void_"+Header, "NewLoan_AgeStore_PartialPayment_AgeStore_BuyBackChange_Void");
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,3);
					//AgeStore.AgeStore(SSN, FileName,-2);
					LoanPartialPayment.LoanPartialPayment(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName,-2);							     
					BuybackChange.BuybackChange(SSN, FileName);
					BuybackVoid.BuybackVoid(SSN, FileName);
				}
			}
		}

@Test(priority=24,groups = "kiran_WY_PDL")
		
		public void NewLoan_PreNoteDiposit_6daysBeforeDueDate() throws Exception 
		{
			String FileName= "AA_NewLoan_PreNoteDeposit_6DaysBeforeDueDate_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"_S.No:25"+"_"+PayFrequency+"_"+CollateralType,"Loan_Age the store to six bussiness days before Due date_Process Pre Note Deposit process from Admin Portal_PreNote deposit should post");
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -6);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName,-7);
				}
			}
		}

//@Test(priority=25,groups = "kiran_WY_PDL")	
		
		public void NewLoan_Duedate_Holiday() throws Exception
		{
			String FileName= "AA_NewLoan_Duedate_Holiday_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName); 
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{ 
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row); 
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:26:NewLoan_Duedate_Holiday_"+Header, "Txn");
					
					Login.Login(UserName,Password,StoreId);
					
					 RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
			/*		AgeStore.AgeStore(SSN, FileName, -4);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, 0);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);*/
				}
			}
		}

@Test(priority=26,groups = "kiran_WY_PDL")

	    public void Prenotedeposit_Verification() throws Exception 
		{
			String FileName= "AA_Prenotedeposit_Verification_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:28:AA_Prenotedeposit_Verification_Txn_Testdata"+Header, "AA_Newloan_Prenotedeposit_Verification_Txn");
					
					
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -7);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
					AgeStore.AgeStore(SSN, FileName, 0);
					PrenoteClear_BeforeDuedate.PrenoteClear_BeforeDuedate(SSN, FileName,0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, -7);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
				}
			}
		}
		
@Test(priority=29,groups = "kiran_WY_PDL")

		public void NewLoan_Deposit_Return_Prenotedeposit() throws Exception 
		{
			String FileName= "AA_NewLoan_Deposit_ReturnPosting_Prenotedeposit_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_path_kiran") + FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{ 
					AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
					UserName = prop.getProperty("UserName_WY_PDL_kiran");
					Password = prop.getProperty("Password_WY_PDL_kiran");
					StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row); 
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("S.NO:30:NewLoan_Deposit_Return_Prenotedeposit_"+Header, "New Loan");
					
					
					Login.Login(UserName,Password,StoreId);
					
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
					NewLoan.NewLoan_WY(SSN, FileName);
					AgeStore.AgeStore(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);						     
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					NACHA.NACHA(SSN, FileName, 0);
					ACHReturnPosting.ACHReturnPosting(SSN, FileName);
					AgeStore_ACHEffectiveDate.AgeStore_ACHEffectiveDate(SSN, FileName, -7);
					ACHEffectivedate_6DaysBeforeDuedate.ACHEffectivedate_6DaysBeforeDuedate(SSN, FileName, 0);
					Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
				}
			}
		}
	   


/////////////////////////////////////////////////////////////////////////////





//@Test(priority=38,groups = "kiran_WY_PDL_New")
public void NewLoan_PartialPayment() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_Newloan_PartialPayment_Txn_TestData.xls";
	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:38" + "_" + PayFrequency + "_" + CollateralType,
					"New Loan _ Age store up to some days before due datE _ Partial Payment");

			//test = reports.startTest("AEA_Newloan_PartialPayment_Txn_" + Header, "AEA_Newloan_PartialPayment_Txn");

			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -6);
			LoanPartialPayment.LoanPartialPayment(SSN, FileName);

		}
	}
	// Login.Login("CSR353","1234","353");

}

//@Test (priority=39,groups = "kiran_WY_PDL_New")

public void CheckingPartialPmt_SomeDaysAfterDueDate() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_CheckingPartialPmt_SomeDaysAfterDueDate_Txn_Testdata.xls";
	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:39" + "_" + PayFrequency + "_" + CollateralType,
					"New Loan _ Age store up to some days after due date _ Check Partial Payment transaction is displayed or not");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 5);
			CheckPartialPayment.CheckPartialPayment(SSN, FileName);

		}
	}

}

//@Test(priority=40,groups = "kiran_WY_PDL_New")

public void PartialPayment_MultipleTenderTypes() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes.xls";
	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:40" + "_" + PayFrequency + "_" + CollateralType,
					"Loan _ partial payment with multiple tender types _ check updates");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -5);
			LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender(SSN, FileName);
			check_updates.check_updates(SSN, FileName);

		}
	}
	// Login.Login("CSR353","1234","353");

}




//@Test(priority=41,groups = "kiran_WY_PDL_New")

public void PartialPayment_MultipleTenderTypes_MO() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_MO.xls";
	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:41" + "_" + PayFrequency + "_" + CollateralType,
					"Advance _ Partial Pay with 2 tender types as MO with different numbers _ Transaction should be processed");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -5);
			LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_MO(SSN, FileName);
			check_updates.check_updates(SSN, FileName);

		}
	}
	// Login.Login("CSR353","1234","353");

}





//@Test(priority=42,groups = "kiran_WY_PDL_New")

public void PartialPayment_MultipleTenderTypes_MO_Same() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_MO_same.xls";
	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:42" + "_" + PayFrequency + "_" + CollateralType,
					"Advance _ Partial Pay with 2 tender types as MO with same numbers _ Transaction should not  be processed");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -5);
			LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_MO_Same(SSN, FileName);
			//check_updates.check_updates(SSN, FileName);

		}
	}
	// Login.Login("CSR353","1234","353");

}



//@Test(priority=43,groups = "kiran_WY_PDL_New")

public void PartialPayment_MultipleTenderTypes_CCK() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_MO.xls";
	String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_CCK.xls";

	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:42" + "_" + PayFrequency + "_" + CollateralType,
					"Advance _ Partial Pay with 2 tender types as CCK with different numbers _ Transaction should be processed");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -5);
			LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_CCK(SSN, FileName);
			//check_updates.check_updates(SSN, FileName);

		}
	}
	// Login.Login("CSR353","1234","353");

}


//@Test(priority=44,groups = "kiran_WY_PDL_New")

public void PartialPayment_MultipleTenderTypes_CCK_Same() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_MO_same.xls";
	String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_CCK_same.xls";

	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:44" + "_" + PayFrequency + "_" + CollateralType,
					"Advance _ Partial Pay with 2 tender types as CCK with same numbers _ Transaction should  not be processed");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -5);
			LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_CCK_Same(SSN, FileName);
			//check_updates.check_updates(SSN, FileName);

		}
	}
	// Login.Login("CSR353","1234","353");

}



//@Test(priority=45,groups = "kiran_WY_PDL_New")

public void PartialPayment_MultipleTenderTypes_CashasTwoTenders() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPayment_MultipleTenderTypes_MO_same.xls";
	String FileName = "AA_PartialPayment_MultipleTenderTypes_CashasTwoTenders.xls";

	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID = TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:44" + "_" + PayFrequency + "_" + CollateralType,
					"Advance _ Partial Pay with 2 tender types as Cash  _ Transaction should not be processed");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -5);
			LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_Cash(SSN, FileName);
			//check_updates.check_updates(SSN, FileName);

		}
	}
	// Login.Login("CSR353","1234","353");

}





//@Test(priority=46,groups = "kiran_WY_PDL_New")
public void NewLoan_PartialPayment_Void() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_NewLoan_PartialPayment_Void_Txn_TestData.xls";
	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:46" + "_" + PayFrequency + "_" + CollateralType,
					"New Loan _ Age store up to some days before due datE _ Partial Payment_Void");

			//test = reports.startTest("AEA_Newloan_PartialPayment_Txn_" + Header, "AEA_Newloan_PartialPayment_Txn");

			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -4);
			LoanPartialPayment.LoanPartialPayment(SSN, FileName);
			PartialPayment_Void_WY.PartialPayment_Void_WY(SSN, FileName);

		}
	}
	// Login.Login("CSR353","1234","353");

}


//@Test(priority=47,groups = "kiran_WY_PDL_New")
public void NewLoan_PartialPayment_VoidEncryption() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_NewLoan_PartialPayment_VoidEncryption_Txn_TestData.xls";
	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:47" + "_" + PayFrequency + "_" + CollateralType,
					"New Loan _ Age store up to some days before due datE  _ Partial Payment_ Age the store to  1 day_Void with encryption");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -4);
			LoanPartialPayment.LoanPartialPayment(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -3);
			PartialPayment_Void_WY.EncryptionKey_Void(SSN, FileName);


		}
	}
	// Login.Login("CSR353","1234","353");

}


//@Test(priority=48,groups = "kiran_WY_PDL_New")
public void NewLoan_PartialPaymentMO2tender_CheckTenderDetailsVoidScreen() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_NewLoan_PartialPaymentMO2tender_CheckTenderDetailsVoidScreen_Txn_TestData.xls";
	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:48" + "_" + PayFrequency + "_" + CollateralType,
					"New Loan _ Age store up to some days before due datE  _ Partial Payment with Mo as tendertypes with 2 different numbers_ Age the store to  1 day_Void and check tender details");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -4);
			LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_MO(SSN, FileName);
			PartialPayment_Void_WY.PartialPayment_Void_WY_CheckTenderDetails_OriginalTender(SSN, FileName);

	

		}
	}
	// Login.Login("CSR353","1234","353");

}





//@Test(priority=49,groups = "kiran_WY_PDL_New")
public void NewLoan_PartialPaymentMO2tender_Voidwithcash() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_NewLoan_PartialPaymentMO2tender_Voidwithcash_Txn_TestData.xls";
	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:49" + "_" + PayFrequency + "_" + CollateralType,
					"New Loan _ Age store up to some days before due datE  _ Partial Payment with Mo as tendertypes with 2 different numbers_Void with Cash");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -4);
			LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_MO(SSN, FileName);
			PartialPayment_Void_WY.PartialPayment_Void_WY_CheckTenderDetails(SSN, FileName);

	

		}
	}
	// Login.Login("CSR353","1234","353");

}




//@Test(priority=50,groups = "kiran_WY_PDL_New")
public void NewLoan_PartialPaymentMO2tender_VoidwithEncryption() throws Exception {

	// Start test. Mention test script name
	String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:50" + "_" + PayFrequency + "_" + CollateralType,
					"New Loan _ Age store up to some days before due datE  _ Partial Payment with Mo as tendertypes with 2 different numbers_Process void on next processing day_Void with Cash only displayed");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -4);
			LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_MO(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -3);
			PartialPayment_Void_WY.EncryptionKey_Void(SSN, FileName);

	

		}
	}
	// Login.Login("CSR353","1234","353");

}



//@Test(priority=51,groups = "kiran_WY_PDL_New")
public void NewLoan_PartialPaymentCCK2tender_CheckTenderDetailsVoidScreen() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_CheckTenderDetailsVoidScreen_Txn_TestData.xls";
	String FileName = "AA_NewLoan_PartialPaymentCCK2tender_CheckTenderDetailsVoidScreen_Txn_TestData.xls";

	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:51" + "_" + PayFrequency + "_" + CollateralType,
					"New Loan _ Age store up to some days before due datE  _ Partial Payment with CCK as tendertypes with 2 different numbers_ Age the store to  1 day_Void and check tender details");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -4);
			LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_CCK(SSN, FileName);
			PartialPayment_Void_WY.PartialPayment_Void_WY_CheckTenderDetails_OriginalTender(SSN, FileName);

	

		}
	}
	// Login.Login("CSR353","1234","353");

}





//@Test(priority=52,groups = "kiran_WY_PDL_New")
public void NewLoan_PartialPaymentCCK2tender_Voidwithcash() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_Voidwithcash_Txn_TestData.xls";
	String FileName = "AA_NewLoan_PartialPaymentCCK2tender_Voidwithcash_Txn_TestData.xls";

	// TestData = new Excel(System.getProperty("user.dir") +
	// prop.getProperty("AA_Store_Test_data_WY_PDL_path_pradeep") +
	// FileName);
	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {
			// driver.get(appUrl);
			// test.log(LogStatus.INFO, "Application is launched");
			// driver.manage().window().maximize();
			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:52" + "_" + PayFrequency + "_" + CollateralType,
					"New Loan _ Age store up to some days before due datE  _ Partial Payment with CCK as tendertypes with 2 different numbers_Void with Cash");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -4);
			LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_CCK(SSN, FileName);
			PartialPayment_Void_WY.PartialPayment_Void_WY_CheckTenderDetails(SSN, FileName);

	

		}
	}
	// Login.Login("CSR353","1234","353");

}




//@Test(priority=53,groups = "kiran_WY_PDL_New")
public void NewLoan_PartialPaymentCCK2tender_VoidwithEncryption() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_NewLoan_PartialPaymentCCK2tender_VoidwithEncryption_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:53" + "_" + PayFrequency + "_" + CollateralType,
					"New Loan _ Age store up to some days before due datE  _ Partial Payment with CCK as tendertypes with 2 different numbers_Process void on next processing day_Void with Cash only displayed");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -4);
			LoanPartialPayment_MultiTender.LoanPartialPayment_MultiTender_CCK(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -3);
			PartialPayment_Void_WY.EncryptionKey_Void(SSN, FileName);

	

		}
	}
	// Login.Login("CSR353","1234","353");

}



//@Test(priority=73,groups = "kiran_WY_PDL_New")
public void Loan_Agethestoreto6Businessdays_ProcessPreNoteDep_PreNoteDep() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_Loan_Agethestoreto6Businessdays_ProcessPreNoteDep_PreNoteDep_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:73" + "_" + PayFrequency + "_" + CollateralType,
					"Loan _ Age the store to six bussiness days before Due date _ Process Pre Note Deposit process from Admin Portal_ PreNote deposit should post");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -6);
			PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -6);
			Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);


	

		}
	}
	// Login.Login("CSR353","1234","353");

}



//@Test(priority=74,groups = "kiran_WY_PDL_New")
public void Loan_Agethestoreto6Businessdays_ProcessPreNoteDep_PreNoteDep_Weekly() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_Loan_Agethestoreto6Businessdays_ProcessPreNoteDep_PreNoteDep_Weekly_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:74" + "_" + PayFrequency + "_" + CollateralType,
					"Loan _ Age the store to six bussiness days before Due date _ Process Pre Note Deposit process from Admin Portal_ PreNote deposit should post");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -7);
			PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
			Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);


	

		}
	}
	// Login.Login("CSR353","1234","353");

}



//@Test(priority=75,groups = "kiran_WY_PDL_New")
public void Loan_Agethestoreto6Businessdays_ProcessPreNoteDep_SKipDepo_PreNoteDep_Depnotpost() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_Loan_Agethestoreto6Businessdays_ProcessPreNoteDep_SKipDepo_PreNoteDep_Depnotpost_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:75" + "_" + PayFrequency + "_" + CollateralType,
					"Loan _ Age the store to six bussiness days before Due date _ Process Pre Note Deposit process from Admin Portal _ PreNote deposit should post _ Miss the Deposit _ Age the store to six bussiness days before next Due date_ Process Pre Note Deposit process from Admin Portal _ PreNote deposit should Not post");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -6);
			PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -6);
			Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);						     
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			ACHEffectiveDate_AgeStore.ACHEffectiveDate_AgeStore(SSN, FileName, -6);
			PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate_SkipDepo(SSN, FileName, -6);
			Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);

	

		}
	}
	// Login.Login("CSR353","1234","353");

}


/*
//@Test (priority=5)
	
	 public void PreNoteDeposit_Clear_CustomerActive_Deposit() throws Exception {
	
		// Start test. Mention test script name
		String FileName= "AA_PreNoteDeposit_Clear_CustomerActive_Deposit_Txn_Testdata.xls";
		Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/TN_PDL_SmokeTest_Prod/"+FileName);    			
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
				String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				String UserName = TestData.getCellData(sheetName,"UserName",row);
				String Password = TestData.getCellData(sheetName,"Password",row);
		       // System.out.println(Password);
		        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String SSN = TestData.getCellData(sheetName,"SSN",row);	
		        String Header = StateID+ "_" + ProductID;
		        //System.out.println(SSN);
		        test = reports.startTest("PreNoteDeposit_Clear_CustomerActive_Deposit_"+Header, "Loan_Pre Note DEP_PreNote Clr_Change BNK status to Inactive before due date_again Change BNK status to ACT on due dt_Custmr should come for DEPosit on due date");
		       appUrl = AppURL;
		        
		       	//this.SetCurrentDate(SSN, FileName);
		        this.Login(UserName,Password,StoreId);
		        BorrowerRegistrationpage Bor = new BorrowerRegistrationpage();
				Bor.RegistrationPage_NewLoan_FLPDL(driver, test, AppURL, SSN, FileName);
		        this.NewLoan(SSN, FileName);
		        this.AgeStore(SSN, FileName, -7);
		        this.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
		        this.AgeStore(SSN, FileName, -1);
		        this.PrenoteClear_BeforeDuedate(SSN, FileName, -1);
		        this.EditBorrower_Inactive(SSN, FileName);
		        this.AgeStore(SSN, FileName, 0);
		        this.EditBorrower_Active(SSN, FileName);
		        this.DrawerDeassign(SSN, FileName);
		        this.StatementGeneration_EODProcessing(SSN, FileName); 
		        this.StoreInfo(SSN, FileName);
		        this.Safeassign(SSN, FileName);
		        this.Drawerassign(SSN, FileName);
		        this.ActiveCustomerEodS_Recoredtatus(SSN, FileName);
		        this.IETaskKiller();
		              
		}
	}

}

*/
//@Test(priority=76,groups = "kiran_WY_PDL_New") //  07-16-2020 , select first paydate as next paydate
public void Loanwithin5daysduedate_SKipDepo_PreNoteDep_Deppost() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_Loanwithin5daysduedate_SKipDepo_PreNoteDep_Deppost_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:76" + "_" + PayFrequency + "_" + CollateralType,
					"Loan (Due date with in five bussiness days) _ PreNote deposit should post _ Miss the Deposit _ Age the store to six bussiness days before next Due date_ Process Pre Note Deposit process from Admin Portal _ PreNote deposit should Not post");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);						     
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			ACHEffectiveDate_AgeStore.ACHEffectiveDate_AgeStore(SSN, FileName, -6);
			PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate_SkipDepo(SSN, FileName, -6);
			Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
			Prenote_deposit_History.Prenote_deposit_History_SkipDep(SSN, FileName);

	

		}
	}
	// Login.Login("CSR353","1234","353");

}




//@Test(priority=77,groups = "kiran_WY_PDL_New")// 07-16-2020 , (REPAYNACHA Issue-10-07-2019) select first paydate as next paydate
public void Loanwithin5daysduedate_Deposit_Return_PreNoteDep_Deppost() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_Loanwithin5daysduedate_Deposit_Return_PreNoteDep_Deppost_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:77" + "_" + PayFrequency + "_" + CollateralType,
					"Loan (Due date with in five bussiness days) _ Process the Deposit _ Return the deposit_ Process Pre Note Deposit process from Admin Portal _ PreNote deposit should Not post");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			//UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);						     
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
			ACHReturnPosting.ACHReturnPosting(SSN, FileName);
			ACHEffectiveDate_AgeStore.ACHEffectiveDate_AgeStore(SSN, FileName, -6);
			PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate_SkipDepo(SSN, FileName, -6);
			Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
			Prenote_deposit_History.Prenote_deposit_History_SkipDep(SSN, FileName);

	

		}
	}
	// Login.Login("CSR353","1234","353");

}




@Test(priority=78,groups = "kiran_WY_PDL_New")// 07-16-2020 , select first paydate as next paydate // //not completed Issue
public void Loan_PerformACHOptoutBeforePreNoteDate_PreNotedepnotpost() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_Loan_PerformACHOptoutBeforePreNoteDate_PreNotedepnotpost_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:78" + "_" + PayFrequency + "_" + CollateralType,
					"Loan _ Perform ACH Opt Out before PreNote date _ PreNote deposit should not post");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -8);
			ACHRevoke.ACHRevoke(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -7);
			PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -7);
			Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
			Prenote_deposit_History.Prenote_deposit_History_SkipDep(SSN, FileName);

			


		}
	}
	// Login.Login("CSR353","1234","353");

}



//@Test(priority=79,groups = "kiran_WY_PDL_New")//not completed Issue
public void Loan_PerformACHOptoutBeforePreNoteDate_ACHOptinonPreNoteDate_PreNotedepnotpost() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_Loan_PerformACHOptoutBeforePreNoteDate_ACHOptinonPreNoteDate_PreNotedepnotpost_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:79" + "_" + PayFrequency + "_" + CollateralType,
					"Loan _ Perform ACH Opt Out before PreNote date _ Perform ACH Opt In on PreNote date _ Process Pre Note Deposit process from Admin Portal _ PreNote deposit should post");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -9);
			ACHRevoke.ACHRevoke(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -6);
			PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -6);
			Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
			Prenote_deposit_History.Prenote_deposit_History_SkipDep(SSN, FileName);

	

		}
	}
	// Login.Login("CSR353","1234","353");

}



//@Test(priority=80,groups = "kiran_WY_PDL_New")//not completed Issue
public void Loan_PerformACHOptoutBeforePreNoteDate_ACHOptinafterPreNoteDate_DeponDueDate() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_Loan_PerformACHOptoutBeforePreNoteDate_ACHOptinafterPreNoteDate_DeponDueDate_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:80" + "_" + PayFrequency + "_" + CollateralType,
					"Loan _ Perform ACH Opt Out before PreNote date _ ACH Opt In after PreNote date _ Customer should go for Deposit on his Due date");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -9);
			ACHRevoke.ACHRevoke(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -6);
			PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -6);
			Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
			Prenote_deposit_History.Prenote_deposit_History_SkipDep(SSN, FileName);

	

		}
	}
	// Login.Login("CSR353","1234","353");

}



//@Test(priority=81,groups = "kiran_WY_PDL_New")//not completed Issue
public void Loan_PerformACHOptoutBeforePreNoteDate_ACHOptonafterPreNoteDate_DeponDueDate_CheckNewBankDetails() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_Loan_PerformACHOptoutBeforePreNoteDate_ACHOptonafterPreNoteDate_DeponDueDate_CheckNewBankDetails_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:81" + "_" + PayFrequency + "_" + CollateralType,
					"Loan with ACH_ Before due date process Ach Revoke _ On Due Date Ach Authorize _ Perform Ach Deposit_ Check whether deposit is done with New Bank details .");


			Login.Login(UserName,Password,StoreId);
			
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -9);
			ACHRevoke.ACHRevoke(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, -6);
			PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName, -6);
			Prenote_deposit_History.Prenote_deposit_History(SSN, FileName);
			Prenote_deposit_History.Prenote_deposit_History_SkipDep(SSN, FileName);

	

		}
	}
	// Login.Login("CSR353","1234","353");

}





//@Test(priority=99,groups = "kiran_WY_PDL_New")//not completed Issue
public void Loan_Deposit_Return() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_Loan_Deposit_Return_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:99" + "_" + PayFrequency + "_" + CollateralType,
					"loan with check _ deposit _ return with return reason id other than R01,R09 then should not allow for future deposit");


			Login.Login(UserName,Password,StoreId);
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);						     
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
			AgeStore.AgeStore(SSN, FileName, 2);
			ACHReturnPosting.ACHReturnPosting(SSN, FileName);
			//ACHReturnPostingWithoutR01R09.ACHReturnPostingWithoutR01R09(SSN, FileName);
			Redeposit_Count_Check_History.Redeposit_Count_Check_History(SSN, FileName);

		}
	}

}




//@Test(priority=117,groups = "kiran_WY_PDL_New")//not completed Issue
public void Loan_Deposit_PrePayment_Return_Redeposit_Clear_RefundwithCashandCheckDisplayed() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_Loan_Deposit_PrePayment_Return_Redeposit_Clear_RefundwithCashandCheckDisplayed_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:117" + "_" + PayFrequency + "_" + CollateralType,
					"Loan _ Age the store upto duedate _ perform deposit_ age perform the Prepayment_ Return posting _ Redeposit _ Process Clear_ Process refund for the excess amount paid options in store should be only cash and check");


			Login.Login(UserName,Password,StoreId);
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			//UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);						     
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
			AgeStore.AgeStore(SSN, FileName, 2);
			ACHPaymet_ExcludeNSFFee.ACHPaymet_ExcludeNSFFee(SSN, FileName);
			ACHReturnPosting.ACHReturnPosting(SSN, FileName);
			ACHEffectiveDate_AgeStore.ACHEffectiveDate_AgeStore(SSN, FileName, 0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			//UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);						     
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			REPAY_NACHA.REPAY_NACHA_ReDep(SSN, FileName, 0);
			ACH_Clear_Admin.ACH_Clear_Admin(SSN, FileName);

		}
	}
	// Login.Login("CSR353","1234","353");

}




//@Test(priority=118,groups = "kiran_WY_PDL_New")//not completed Issue
public void Loan_ReturnPosting_WO60days() throws Exception {

	// Start test. Mention test script name
	//String FileName = "AA_NewLoan_PartialPaymentMO2tender_VoidwithEncryption_Txn_TestData.xls";
	String FileName = "AA_Loan_ReturnPosting_WO60days_Txn_TestData.xls";

	TestData = new Excel(
			System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_WY_PDL_New_path_kiran") + FileName);
	int lastrow = TestData.getLastRow("NewLoan");
	String sheetName = "NewLoan";
	// int lastrow=TestData.getLastRow("Borrower");
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {
		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		// System.out.println(RunFlag);
		if (RunFlag.equals("Y")) {

			AppURL = prop.getProperty("AppURL_WY_PDL_kiran");
			UserName = prop.getProperty("UserName_WY_PDL_kiran");
			Password = prop.getProperty("Password_WY_PDL_kiran");
			// System.out.println(Password);
			StoreId = prop.getProperty("StoreID_WY_PDL_kiran");
			String ProductID = TestData.getCellData(sheetName, "ProductID", row);
			String StateID =TestData.getCellData(sheetName, "StateID", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);
			String PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
			String CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
			String Header = StateID + "_" + ProductID;
			// System.out.println(SSN);
			test = reports.startTest(Header + "_S.No:118" + "_" + PayFrequency + "_" + CollateralType,
					"Loan _ Return Posting _ WO Check whether Write off is done 60days from return date.");


			Login.Login(UserName,Password,StoreId);
			RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_WYPDL(driver, test, Header, SSN, FileName);
			NewLoan.NewLoan_WY(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 0);
			DrawerDeassign.DrawerDeassign(SSN, FileName);
			StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
			//UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
			StoreInfo.StoreInfo(SSN, FileName);						     
			Safeassign.Safeassign(SSN, FileName);
			Drawerassign.Drawerassign(SSN, FileName);
			REPAY_NACHA.REPAY_NACHA(SSN, FileName,0);
			ACHReturnPosting.ACHReturnPosting(SSN, FileName);
			AgeStore.AgeStore(SSN, FileName, 61);
			WO_HistoryCheck.Prenote_deposit_History(SSN, FileName);



		}
	}
	// Login.Login("CSR353","1234","353");

}




@AfterMethod(alwaysRun = true)

public void getResult(ITestResult result) throws Exception {
if (result.getStatus() == ITestResult.FAILURE) {
	test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
	// test.log(LogStatus.FAIL, "Test Case Failed is
	// "+result.getThrowable());

	String screenshotPath = getScreenhot(driver, result.getName());
	// To add it in the extent report
	test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
} else if (result.getStatus() == ITestResult.SKIP) {
	test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
} else if (result.getStatus() == ITestResult.SUCCESS) {

	test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
}
reports.flush();
// driver.quit();

}

public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
// TakesScreenshot ts = (TakesScreenshot) driver;
// File source = ts.getScreenshotAs(OutputType.FILE);

File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
// after execution, you could see a folder "FailedTestsScreenshots"
// under src folder
String destination = System.getProperty("user.dir") + "/ExecutionReports/WY_PDL/FailedTestsScreenshots/"
		+ screenshotName + dateName + ".png";
File finalDestination = new File(destination);
FileUtils.copyFile(source, finalDestination);
return destination;
}

@AfterMethod
@AfterTest(alwaysRun = true)
public void tearDown() {
// Ending Test
reports.endTest(test);

// writing everything into HTML report
reports.flush();
}

@AfterClass(alwaysRun = true)
public void quit() {
// Closing browser
driver.quit();

}

public void takeScreenShot(WebDriver driver, String filePath) {
File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
try {
	FileUtils.copyFile(scrFile, new File(filePath));
} catch (IOException e) {
	e.printStackTrace();
}
}

@BeforeClass(alwaysRun = true)
public synchronized void initialize() {
// Create an instance of ExtentsReports class and pass report storage
// path as a parameter
// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
try {
	BufferedReader reader;
	reader = new BufferedReader(

			new FileReader("C:/AA_Batch/AA_PDL/src/test/java/pack/Config.properties"));

	prop = new Properties();
	prop.load(reader);
	reader.close();

}

catch (Exception e) {

	System.out.println("Object proprties file not found");
}

String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
// Date D = new Date();
String className = this.getClass().getName();
String className1[] =className.split("k.");
String Name =className1[1];
//test.log(LogStatus.PASS, "Class name is::"+className);
String kfilename = prop.getProperty("QC_Store_extent_report_file_name") +Name+"_"+ timestamp + ".html";

reports = new ExtentReports(
		System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + kfilename, true);
/*
 * reports = new ExtentReports(System.getProperty("user.dir") +
 * "/ExecutionReports/CO_ILP/AA_CO_ILP_Generic Scenarios_" + timestamp +
 * ".html", true); reports.addSystemInfo("Browser Version", "IE 11.0");
 */
}

@BeforeTest(alwaysRun = true)
public void setup_Grid() throws IOException, InterruptedException {

try {
	BufferedReader reader;
	reader = new BufferedReader(

			new FileReader("C:/AA_Batch/AA_PDL/src/test/java/pack/Config.properties"));

	prop = new Properties();
	prop.load(reader);
	reader.close();

}

catch (Exception e) {

	System.out.println("Object proprties file not found");
}

Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
Thread.sleep(5000); // Allow OS to kill the process
System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
driver = new InternetExplorerDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
/*
 * String Node = "http://192.168.2.123:5555/wd/hub"; DesiredCapabilities
 * cap = DesiredCapabilities.internetExplorer();
 * 
 * 
 * System.setProperty("webdriver.ie.driver",System.getProperty(
 * "user.dir")+"/IEDriverServer.exe");
 * 
 * driver = new RemoteWebDriver(new URL(Node), cap);
 */
/*
 * System.setProperty("webdriver.ie.driver",System.getProperty(
 * "user.dir")+"/IEDriverServer.exe"); driver = new
 * InternetExplorerDriver();
 */
}

public boolean IsElementExits(String Value) {
int secondsToWait = 5;

try {
	new WebDriverWait(driver, secondsToWait)
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Value)));
	return true;
} catch (org.openqa.selenium.TimeoutException e) {
	return false;
}
}

public boolean isAlertPresent() {
try {
	driver.switchTo().alert();
	return true;
} catch (NoAlertPresentException ex) {
	return false;
}
}

public static WebElement Field(WebDriver driver) {

try {
	Thread.sleep(500);
	WebElement element = (new WebDriverWait(driver, 9)).until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table")));
	return element;
} catch (Exception e) {
	return null;
}
}

public void proc(String ReturnFormat) throws ClassNotFoundException, SQLException {
Connection conn = null;

// Object of Statement. It is used to create a Statement to execute the
// query
Statement stmt = null;

// Object of ResultSet => 'It maintains a cursor that points to the
// current row in the result set'
ResultSet resultSet = null;

Class.forName("oracle.jdbc.driver.OracleDriver");
System.out.println("before conn");

// Open a connection
try {

	conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2",
			"QFUNDX_LOCAL_AUTOMATION", "QFUNDX_LOCAL_AUTOMATION");

} catch (SQLException e1) {

	System.out.println("Connection Failed! Check output console" + e1);
	e1.printStackTrace();
}

// Execute a query
stmt = conn.createStatement();
System.out.println("after conn");

try {
	String A = null;

	String content;

	String fw = "E:\\AdminLogin.txt";
	// String content = "\r\n";

	// content=A;
	// fw = "E:\\AdminLogin.txt";

	appendUsingFileWriter(fw, ReturnFormat);
	// appendUsingFileWriter(fw,"\r\n");
	// appendUsingFileWriter(fw,content);

	// String str = content.readLine();

	fw.replaceAll("[0-9,a-z,A-Z]{17,21}", A);

	// fw.close();

	System.out.println("after query");

	if (resultSet != null) {
		try {
			resultSet.close();
		} catch (Exception e) {
		}
	}

	if (stmt != null) {
		try {
			stmt.close();
		} catch (Exception e) {
		}
	}

	if (conn != null) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}
} catch (Exception e2) {

	System.out.println(" console" + e2);
	e2.printStackTrace();
}

}

private static void appendUsingFileWriter(String filePath, String text) {
File file = new File(filePath);
FileWriter fr = null;
try {
	// Below constructor argument decides whether to append or override
	fr = new FileWriter(file);
	fr.write(text);

} catch (IOException e) {
	e.printStackTrace();
} finally {
	try {
		fr.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}

}
