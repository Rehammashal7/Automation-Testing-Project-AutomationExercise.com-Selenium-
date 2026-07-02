package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends PageBase {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".title.text-center")
    public WebElement allProductsMsg;

    @FindBy(css=".features_items .product-image-wrapper")
    public List<WebElement> productsList;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
    WebElement viewProductBtn;

    public void openFirstProduct() {
        viewProductBtn.click();
    }
}