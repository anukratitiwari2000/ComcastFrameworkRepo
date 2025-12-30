package practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.org.objectrepository.LoginPage;
import com.crm.comcast.baseutility.BaseClass;

public class SearchContactTest extends BaseClass {
	/**
	 * Scenario : login()==>navigateContact==>createContact()==>verify
	 */
	@Test
	public void searchContactTest(){
		/*Step 1-login to App*/
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp("url", "username", "password");
	}

}
