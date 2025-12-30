package com.comcast.crm.org.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;

	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// verify header Info
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;

	// Verify OrgName
	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgNameVerify;

	// Verify PhoneNumber
	@FindBy(id = "dtlview_Phone")
	private WebElement orgPhoneNumberVerify;

	// Verify Industry DropDown
	@FindBy(id = "dtlview_Industry")
	private WebElement industryDD;

	// Verify Type DropDown
	@FindBy(id = "dtlview_Type")
	private WebElement typeDD;
	
	// Getters method
	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getOrgNameVerify() {
		return orgNameVerify;
	}

	public WebElement getOrgPhoneNumberVerify() {
		return orgPhoneNumberVerify;
	}
	
	public WebElement getIndustryDDVerify() {
		return industryDD;
	}
	
	public WebElement getTypeDDVerify() {
		return typeDD;
	}

}
