package com.comcast.crm.org.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//Click On Create Product button
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement productBtn;
	
	//Create Product
	@FindBy(name="productname")
	private WebElement createProduct;
	
	
}
