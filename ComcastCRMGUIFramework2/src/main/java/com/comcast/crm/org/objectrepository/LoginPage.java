package com.comcast.crm.org.objectrepository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generic.webdriverutility.WebDriverUtility;
/**
 * author Anukrati
 * contains login page elements & business libraries like login() 
 */
/*Rule1-Create Java Class*/
public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "user_name")
	private WebElement usernameEdit;

	@FindBy(name = "user_password")
	private WebElement passwordEdit;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	

	public WebElement getUsername() {
		return usernameEdit;
	}

	public WebElement getPassword() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToApp(String url,String username,String password) {
		WebDriverUtility webDriverUtiltiy=new WebDriverUtility();
		webDriverUtiltiy.waitForpageLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}


}
