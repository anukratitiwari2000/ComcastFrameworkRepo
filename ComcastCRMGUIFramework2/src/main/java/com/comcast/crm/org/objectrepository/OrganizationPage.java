package com.comcast.crm.org.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
WebDriver driver;
	
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	// Click on create Organization button
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement orgBtn;

	@FindBy(name="search_text")
	private WebElement searchText;

	@FindBy(name="search_field")
	private WebElement searchDD;

	@FindBy(name="submit")
	private WebElement searchBtn;
	
	public WebElement getOrgBtn() {
		return orgBtn;
	}

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	
	
}
