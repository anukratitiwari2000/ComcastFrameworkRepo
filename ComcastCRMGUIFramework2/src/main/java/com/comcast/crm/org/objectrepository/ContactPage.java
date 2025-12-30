package com.comcast.crm.org.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	// Click on create Contact button
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement contactBtn;

	public WebElement getContactBtn() {
		return contactBtn;
	}


}
