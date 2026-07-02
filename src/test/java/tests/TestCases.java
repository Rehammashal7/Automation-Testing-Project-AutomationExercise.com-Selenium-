package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.TestCasesPage;

public class TestCases  extends TestBase{
	
	HomePage homeObject;
	TestCasesPage testCaseObject;
	
	@Test
	public void test_TestCasesPage() throws InterruptedException {
		homeObject=new HomePage(driver);
		testCaseObject=new TestCasesPage(driver);
		
		
		homeObject.testCasesBtn.click();
		Assert.assertEquals(testCaseObject.testCasesMessage.getText(),"TEST CASES");
		
	
	
	
	}
	
	

}
