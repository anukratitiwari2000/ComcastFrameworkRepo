package com.comcast.crm.org.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganizationPage {
	WebDriverUtility webDriverUtility = new WebDriverUtility();
	WebDriver driver;

	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Organization Name
	@FindBy(name = "accountname")
	private WebElement orgName;

	// Shipping Address
	@FindBy(name = "ship_street")
	private WebElement shippingAdd;

	// Phone number
	@FindBy(id = "phone")
	private WebElement phone;

	// Industry DropDown
	@FindBy(name = "industry")
	private WebElement industry;

	// Type DropDown
	@FindBy(name = "accounttype")
	private WebElement type;

	// Save Button
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getShippingAdd() {
		return shippingAdd;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
