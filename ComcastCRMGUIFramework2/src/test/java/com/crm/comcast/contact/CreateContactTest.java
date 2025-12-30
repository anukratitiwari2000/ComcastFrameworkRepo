package com.crm.comcast.contact;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.org.objectrepository.ContactInfoPage;
import com.comcast.crm.org.objectrepository.ContactPage;
import com.comcast.crm.org.objectrepository.CreateNewContactPage;
import com.comcast.crm.org.objectrepository.CreateNewOrganizationPage;
import com.comcast.crm.org.objectrepository.HomePage;
import com.comcast.crm.org.objectrepository.OrganizationInfoPage;
import com.comcast.crm.org.objectrepository.OrganizationPage;
import com.comcast.crm.org.objectrepository.SerachOrganizationInContactPage;
import com.comcast.generic.webdriverutility.UtilityClassObject;
import com.crm.comcast.baseutility.BaseClass;

/**
 * author Anukrati
 */
//@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)

public class CreateContactTest extends BaseClass {

	@Test(groups = "SmokeTest")
	public void createContactTest() throws EncryptedDocumentException, IOException, InterruptedException {

		/* Fill the data on last name textField from excel file*/
		UtilityClassObject.getTest().log(Status.INFO, "read the data from excelfile");
		String lastName = excelUtility.getDataFromExcel("contact", 1, 3); //+ javaUtility.getRandomNumber();

		/* Click on Contacts link*/
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		HomePage homePage = new HomePage(driver);
		homePage.getContactLink().click();

		// Click on create Contact button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact page");
		ContactPage contactPage = new ContactPage(driver);
		contactPage.getContactBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "create a contact ");
		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		createNewContactPage.getlastName().sendKeys(lastName);

		// Click on Save Button
		createNewContactPage.getSaveBtn().click();
		Thread.sleep(2000);

		// Verify Header Msg Expected
		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);

		String headerInfo = contactInfoPage.getHeaderInfo().getText();

		boolean status = headerInfo.contains(lastName);
		Assert.assertEquals(status, true);

		// verify LastName
		String actLastName = contactInfoPage.getContactNameVerify().getText();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actLastName, lastName);
		// Assert.assertEquals(actLastName, lastName);
	}

	@Test(groups = "RegressionTest")
	public void CreateContactWithSupportDate() throws InterruptedException, EncryptedDocumentException, IOException {
		// TestScript Data from Excel File
		String lastName = excelUtility.getDataFromExcel("contact", 1, 2) + javaUtility.getRandomNumber();

		// Click on Contacts link
		HomePage homePage = new HomePage(driver);
		homePage.getContactLink().click();

		// Click on create Contact button
		ContactPage contactPage = new ContactPage(driver);
		contactPage.getContactBtn().click();

		String startDate = javaUtility.getSystemDateYYYYMMDD();
		String endDate = javaUtility.getRequireDate(30);

		// Fill the data on required filed
		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		createNewContactPage.getlastName().sendKeys(lastName);

		// Select start Date
		createNewContactPage.selectStartDate();
		createNewContactPage.getStartDate().sendKeys(startDate);

		// Select start Date
		createNewContactPage.selectEndDate();
		createNewContactPage.getEndDate().sendKeys(endDate);

		// Click on Save Button
		createNewContactPage.getSaveBtn().click();
		Thread.sleep(2000);

		// Verify start date
		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);

		String actStartDate = contactInfoPage.getStartDateVerify().getText();

		boolean status = actStartDate.contains(startDate);
		Assert.assertEquals(status, true);

		// verify End date
		String actEndDate = contactInfoPage.getEndDateVerify().getText();

		boolean status2 = actEndDate.contains(endDate);
		Assert.assertEquals(status2, true);
	}

	@Test(groups = "RegressionTest")
	public void CreateContactWithOrgTest() throws InterruptedException, EncryptedDocumentException, IOException {
		// TestScript Data from Excel File
		String lastName = excelUtility.getDataFromExcel("contact", 7, 2) + javaUtility.getRandomNumber();
		String orgName = excelUtility.getDataFromExcel("contact", 7, 3) + javaUtility.getRandomNumber();
		String shippingAdd = excelUtility.getDataFromExcel("contact", 7, 4);

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

		// Click on Contacts link
		homePage.getContactLink().click();

		// Click on create Contact button
		ContactPage contactPage = new ContactPage(driver);
		contactPage.getContactBtn().click();

		// Fill the data on required filed
		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		createNewContactPage.getlastName().sendKeys(lastName);

		// Click on select organization button
		createNewContactPage.getSelectOrganizationBtn().click();

		// Switch to window

		// Switch to child Window
		webdriverUtility.switchNewBrowserTab(driver, "module=Accounts&action");

		// search and select the organization name
		SerachOrganizationInContactPage serachOrganizationInContactPage = new SerachOrganizationInContactPage(driver);
		// Search Organization
		serachOrganizationInContactPage.getSerachOrganization().sendKeys(orgName);
		// click on search button
		serachOrganizationInContactPage.getSearchBtn().click();

		// Dynamic WebElement
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// Switch to parent window
		webdriverUtility.switchNewBrowserTab(driver, "module=Contacts&action");

		// Click on save button
		createNewOrganizationPage.getSaveBtn().click();
		Thread.sleep(2000);

		// verify header
		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
		String headerInfo1 = contactInfoPage.getHeaderInfo().getText();

		boolean status3 = headerInfo1.contains(lastName);
		Assert.assertEquals(status3, true);

		// verify LastName
		String actLastName = contactInfoPage.getContactNameVerify().getText();

		SoftAssert softAssert2 = new SoftAssert();
		softAssert2.assertEquals(actLastName, lastName);

		// verify orgName with contact
		String actOrgName1 = contactInfoPage.getSelectOrgNameVerify().getText();
		boolean status4 = actOrgName1.trim().equals(orgName);
		Assert.assertEquals(status4, true);

	}

}
