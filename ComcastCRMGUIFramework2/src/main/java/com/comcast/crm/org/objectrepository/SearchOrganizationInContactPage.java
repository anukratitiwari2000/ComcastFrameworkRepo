package com.comcast.crm.org.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchOrganizationInContactPage {
	WebDriver driver;

	public SearchOrganizationInContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// search
	@FindBy(name = "search_text")
	private WebElement serachOrganization;

	// Verify lastName
	@FindBy(name = "search")
	private WebElement searchBtn;

	public WebElement getSerachOrganization() {
		return serachOrganization;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}


}
