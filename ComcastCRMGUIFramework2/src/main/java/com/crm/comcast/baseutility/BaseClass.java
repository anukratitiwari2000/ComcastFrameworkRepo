package com.crm.comcast.baseutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.org.objectrepository.HomePage;
import com.comcast.crm.org.objectrepository.LoginPage;
import com.comcast.generic.databaseutility.DataBaseUtility;
import com.comcast.generic.javautility.JavaUtility;
import com.comcast.generic.webdriverutility.UtilityClassObject;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	
	// Object Creation
	public FileUtility fileUtility = new FileUtility();
	public DataBaseUtility dataBaseUtility = new DataBaseUtility();
	public ExcelUtility excelUtility = new ExcelUtility();
	public JavaUtility javaUtility = new JavaUtility();
	public WebDriverUtility webdriverUtility = new WebDriverUtility();
	

	@BeforeSuite(groups = { "SmokeTest", "RegressionTest" })
	public void configBS() {
	
		System.out.println("Connect to DB,Report Config");
		dataBaseUtility.getDbConnection();
	}

	// @Parameters("BROWSER")
	@BeforeClass(groups = { "SmokeTest", "RegressionTest" })
	public void configBC() throws Throwable {
		System.out.println("Launch the browser");
		// String BROWSER=browser;
		//String BROWSER = fileUtility.getDataFromPropertiesFile("browser");
		String BROWSER = System.getProperty("browser",fileUtility.getDataFromPropertiesFile("browser"));
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "SmokeTest", "RegressionTest" })
	public void configBM() throws IOException {
		System.out.println("Login to an application");
		LoginPage loginPage = new LoginPage(driver);
		/*String URL = fileUtility.getDataFromPropertiesFile("url");
		String USERNAME = fileUtility.getDataFromPropertiesFile("username");
		String PASSWORD = fileUtility.getDataFromPropertiesFile("password");*/
		
		/*when we pass data using CMD line so we have to use method System.getProperty
		 * in case we forgot to pass data during Maven parameter CMD so we also
		 * property file method to get data */
		String URL = System.getProperty("url",fileUtility.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username",fileUtility.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password",fileUtility.getDataFromPropertiesFile("password"));
		
		loginPage.loginToApp(URL, USERNAME, PASSWORD);
		

	}

	@AfterMethod(groups = { "SmokeTest", "RegressionTest" })
	public void configAM() {
		System.out.println("Logout the application");
		HomePage homePage = new HomePage(driver);
		homePage.logOut();
	}

	@AfterClass(groups = { "SmokeTest", "RegressionTest" })
	public void configAC() {
		System.out.println("Close the Browser");
		driver.quit();

	}

	@AfterSuite(groups = { "SmokeTest", "RegressionTest" })
	public void configAS() {
		System.out.println("Close the connection of DB,Report Backup");
		// dataBaseUtility.closeDbConnection();

	}

}
