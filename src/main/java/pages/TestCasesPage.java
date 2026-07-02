package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends PageBase {

	public TestCasesPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css="#form > div > div.row > div > h2")
	public WebElement testCasesMessage;
	
	
	
	
	

}
