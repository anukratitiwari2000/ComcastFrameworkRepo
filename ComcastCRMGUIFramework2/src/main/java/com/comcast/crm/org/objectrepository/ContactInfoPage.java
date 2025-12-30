package com.comcast.crm.org.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;

	public ContactInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// verify header Info
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;

	// Verify lastName
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameVerify;

	// Verify selected organization
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement selectOrgNameVerify;

	// verify start Date
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDateVerify;

	// Verify end Date
	@FindBy(id = "dtlview_Support End Date")
	private WebElement endDateVerify;

	// Getters method
	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getContactNameVerify() {
		return lastNameVerify;
	}

	public WebElement getStartDateVerify() {
		return startDateVerify;
	}

	public WebElement getEndDateVerify() {
		return endDateVerify;
	}

	public WebElement getLastNameVerify() {
		return lastNameVerify;
	}

	public WebElement getSelectOrgNameVerify() {
		return selectOrgNameVerify;
	}

}
