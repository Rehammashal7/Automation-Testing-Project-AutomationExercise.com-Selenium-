package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetails extends PageBase {

    public ProductDetails(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".product-information h2")
    public WebElement productName;

    @FindBy(xpath = "//*[contains(text(),'Category')]")
    public WebElement category;

    @FindBy(xpath = "//*[contains(text(),'Rs.')]")
    public WebElement price;

    @FindBy(xpath = "//*[contains(text(),'Availability')]")
    public WebElement availability;

    @FindBy(xpath = "//*[contains(text(),'Condition')]")
    public WebElement condition;

    @FindBy(xpath = "//*[contains(text(),'Brand')]")
    public WebElement brand;
}