package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetails;
import pages.ProductsPage;

public class ProductDetailsTest extends TestBase {

    HomePage homeObject;
    ProductsPage productsObject;
    ProductDetails detailsObject;

    @Test
    public void verifyProductDetails() {

        homeObject = new HomePage(driver);
        productsObject = new ProductsPage(driver);
        detailsObject = new ProductDetails(driver);

        // Step 3
        Assert.assertEquals(
                homeObject.homeBtn.getCssValue("color"),
                "rgba(255, 165, 0, 1)"
        );

        // Step 4
        homeObject.productsBtn.click();

        // Step 5
        Assert.assertTrue(
                productsObject.allProductsMsg.isDisplayed()
        );

        // Step 6
        Assert.assertTrue(
                productsObject.productsList.size() > 0
        );

        // Step 7
        productsObject.openFirstProduct();

        // Step 8 + 9
        Assert.assertTrue(detailsObject.productName.isDisplayed());
        Assert.assertTrue(detailsObject.category.isDisplayed());
        Assert.assertTrue(detailsObject.price.isDisplayed());
        Assert.assertTrue(detailsObject.availability.isDisplayed());
        Assert.assertTrue(detailsObject.condition.isDisplayed());
        Assert.assertTrue(detailsObject.brand.isDisplayed());
    }
}