package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Signup / Login")
	WebElement loginOrRegisterBtn;
	
	@FindBy(linkText = "Home")
	public WebElement homeBtn;
	
	@FindBy(linkText="Contact us")
	public WebElement contactUsBtn;
	
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	public WebElement productsBtn;
	
	
	@FindBy(linkText="Test Cases")
	public WebElement testCasesBtn;
	
	public void openLoginPage() {
		loginOrRegisterBtn.click();
	}
	
	public void openRegisterPage() {
		loginOrRegisterBtn.click();
	}
	
	public void openHomePage() {
		homeBtn.click();
	}
}
