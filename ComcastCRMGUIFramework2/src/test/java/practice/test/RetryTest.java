package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.baseutility.BaseClass;

@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryListenerImp.class)
public class RetryTest extends BaseClass{
	public void activateSim() {
		System.out.println("execute activateSim");
		String actTitle = driver.getTitle();
		Assert.assertEquals("", "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
}
