package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsForm extends PageBase {

	public ContactUsForm(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css="#contact-page > div.row > div.col-sm-8 > div > h2")
	public WebElement contactPageMessage;
	
	@FindBy(name="name")
	WebElement userName;
	
	@FindBy(name="email")
	WebElement emailTxt;
	
	@FindBy(name="subject")
	WebElement subjectTxt;
	
	@FindBy(id="message")
	WebElement messageTxt;
	
	@FindBy(name="upload_file")
	WebElement uploadFile;
	
	@FindBy(name="submit")
	WebElement submitBtn;
	
	@FindBy(css="#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success")
	public WebElement FormSentMessage;
	
	public Alert simpleAlert ;
	
	public void ContactUSForm(String name,String email,String subject,String message,String filePath) {
		
		userName.sendKeys(name);
		emailTxt.sendKeys(email);
		subjectTxt.sendKeys(subject);
		messageTxt.sendKeys(message);
		uploadFile.sendKeys(filePath);
		
		submitBtn.click();
		
		
	}

}
