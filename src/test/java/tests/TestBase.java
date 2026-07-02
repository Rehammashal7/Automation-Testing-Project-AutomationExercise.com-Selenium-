package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	WebDriver driver;
	String baseURL = "https://automationexercise.com/";
  
	@BeforeTest
	public void openWebsite() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterTest
	public void closeWebsite() {
		driver.quit();
	}

}
