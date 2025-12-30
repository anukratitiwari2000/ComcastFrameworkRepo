package com.comcast.crm.org.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;

	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Last Name
	@FindBy(name = "lastname")
	private WebElement lastName;

	// Select startDate
	@FindBy(name = "support_start_date")
	private WebElement startDate;

	// Select endDate
	@FindBy(name = "support_end_date")
	private WebElement endDate;
	
	//select Organization
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrganizationBtn;
	


	// Save Button
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getlastName() {
		return lastName;
	}
	
	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}
	
	public WebElement getSelectOrganizationBtn() {
		return selectOrganizationBtn;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void selectStartDate() {
		getStartDate().clear();
		
		
	}
	
	public void selectEndDate() {
		getEndDate().clear();
		
	}
	
	
}
