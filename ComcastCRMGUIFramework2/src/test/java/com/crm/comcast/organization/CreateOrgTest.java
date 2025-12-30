package com.crm.comcast.organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.org.objectrepository.CreateNewOrganizationPage;
import com.comcast.crm.org.objectrepository.HomePage;
import com.comcast.crm.org.objectrepository.OrganizationInfoPage;
import com.comcast.crm.org.objectrepository.OrganizationPage;
import com.crm.comcast.baseutility.BaseClass;

public class CreateOrgTest extends BaseClass {

	@Test(groups = "SmokeTest")
	public void CreateOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {

		// TestScript Data from Excel File
		String orgName = excelUtility.getDataFromExcel("Organization", 1, 2) + javaUtility.getRandomNumber();
		String shippingAdd = excelUtility.getDataFromExcel("Organization", 1, 3);

		// Click on OrgLink
		HomePage homePage = new HomePage(driver);
		homePage.getOrgLink().click();

		// Click on create Organization button on org page
		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage.getOrgBtn().click();

		// Enter all details in create organization page
		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.getOrgName().sendKeys(orgName);
		createNewOrganizationPage.getShippingAdd().sendKeys(shippingAdd);

		// Click on save button
		createNewOrganizationPage.getSaveBtn().click();
		Thread.sleep(2000);

		// Verify Header Msg Expected
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);

		String headerInfo = organizationInfoPage.getHeaderInfo().getText();

		boolean status = headerInfo.contains(orgName);
		Assert.assertEquals(status, true);

		// verify orgName
		String actOrgName = organizationInfoPage.getOrgNameVerify().getText();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actOrgName, orgName);

	}

	@Test(groups = "RegressionTest")
	public void createOrgWithPhoneNumber() throws EncryptedDocumentException, IOException {
		// TestScript Data from Excel File
		String orgName = excelUtility.getDataFromExcel("Organization", 1, 2) + javaUtility.getRandomNumber();
		String shippingAdd = excelUtility.getDataFromExcel("Organization", 1, 3);
		String phoneNo = excelUtility.getDataFromExcel("Organization", 7, 4);

		// Click On Organizations link
		HomePage homePage = new HomePage(driver);
		homePage.getOrgLink().click();
		;

		// Click on Create Organization button
		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage.getOrgBtn().click();

		// Elements locators on create Organization page
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("ship_street")).sendKeys(shippingAdd);
		driver.findElement(By.id("phone")).sendKeys(phoneNo);

		// Click on Save Button
		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.getSaveBtn().click();

		// Verify Phone Number
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		String actPhoneNumber = organizationInfoPage.getOrgPhoneNumberVerify().getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actPhoneNumber, phoneNo);

	}

	@Test(groups = "RegressionTest")
	public void createOrgWithType() throws InterruptedException, EncryptedDocumentException, IOException {
		// TestScript Data from Excel File
		String orgName = excelUtility.getDataFromExcel("Organization", 1, 2) + javaUtility.getRandomNumber();
		String shippingAdd = excelUtility.getDataFromExcel("Organization", 1, 3);
		String industry = excelUtility.getDataFromExcel("Organization", 4, 4);
		String type = excelUtility.getDataFromExcel("Organization", 4, 5);

		// Click on OrgLink
		HomePage homePage = new HomePage(driver);
		homePage.getOrgLink().click();

		// Click on create Organization button on org page
		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage.getOrgBtn().click();

		// Enter all details in create organization page
		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.getOrgName().sendKeys(orgName);
		createNewOrganizationPage.getShippingAdd().sendKeys(shippingAdd);
		// Select Industry and Type DropDown in create organization page
		WebElement industryFromDD = createNewOrganizationPage.getIndustry();
		webdriverUtility.select(industryFromDD, industry);
		WebElement typeFromDD = createNewOrganizationPage.getType();
		webdriverUtility.select(typeFromDD, type);

		// Click on save button
		createNewOrganizationPage.getSaveBtn().click();
		Thread.sleep(2000);

		// Verify industry dropdown
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);

		String actIndustryName = organizationInfoPage.getIndustryDDVerify().getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actIndustryName, industry);

		// verify type Type DropDown
		String actType = organizationInfoPage.getTypeDDVerify().getText();
		SoftAssert softAssert2 = new SoftAssert();
		softAssert.assertEquals(actType, type);

	}

	@Test(groups = "RegressionTest")
	public void deleteOrgTest() throws InterruptedException, EncryptedDocumentException, IOException {
		// TestScript Data from Excel File
		String orgName = excelUtility.getDataFromExcel("Organization", 10, 2) + javaUtility.getRandomNumber();
		String shippingAdd = excelUtility.getDataFromExcel("Organization", 10, 3);
		String searchDD = excelUtility.getDataFromExcel("Organization", 10, 4);

		// Click on OrgLink
		HomePage homePage = new HomePage(driver);
		homePage.getOrgLink().click();

		// Click on create Organization button on org page
		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage.getOrgBtn().click();

		// Enter all details in create organization page
		CreateNewOrganizationPage createNewOrgPage = new CreateNewOrganizationPage(driver);
		createNewOrgPage.getOrgName().sendKeys(orgName);
		createNewOrgPage.getShippingAdd().sendKeys(shippingAdd);

		// Click on save button

		createNewOrgPage.getSaveBtn().click();
		Thread.sleep(2000);

		// Verify Header Msg Expected
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);

		String headerInfo = organizationInfoPage.getHeaderInfo().getText();

		boolean status = headerInfo.contains(orgName);
		Assert.assertEquals(status, true);

		// verify orgName
		String actOrgName = organizationInfoPage.getOrgNameVerify().getText();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actOrgName, orgName);

		// Go back to Organization Page
		homePage.getOrgLink().click();

		// Search for Organization
		organizationPage.getSearchText().sendKeys(orgName);
		webdriverUtility.select(organizationPage.getSearchDD(), searchDD);
		organizationPage.getSearchBtn().click();

		// In dynamic WebTable select and Delete org
		driver.findElement(By.xpath("//a[text()='" + orgName + "']/../../td[8]/a[text()='del']")).click();

		// Handle the popUp
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
