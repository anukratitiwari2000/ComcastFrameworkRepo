package com.comcast.crm.org.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click on organization link
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	
	// administrator
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;

	// SignOut Link
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	// Click on Contacts link
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getAdministrator() {
		return administrator;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public void logOut() {
		Actions act = new Actions(driver);
		act.moveToElement(administrator).perform();
		signOut.click();

	}

}
