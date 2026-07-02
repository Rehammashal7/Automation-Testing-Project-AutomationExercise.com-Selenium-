package tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;
import utilities.JsonDataReader;

public class Register_happyScenario extends TestBase {

    HomePage homeObject;
    RegisterPage registerObject;
    JSONObject registerData;

    @BeforeClass
    public void setupData() throws Exception {
        registerData = JsonDataReader.getJsonData(
                "src/test/java/testdata/RegisterData.json");
    }

    @Test(priority = 1)
    public void testRegister_ValidMandatoryAndOptionalFieldsWithNewEmail()
            throws Exception {

        homeObject = new HomePage(driver);
        registerObject = new RegisterPage(driver);

        JSONObject user = registerData.getJSONObject("fullRegisterUser");

        Assert.assertEquals(
                homeObject.homeBtn.getCssValue("color"),
                "rgba(255, 165, 0, 1)"
        );

        homeObject.openRegisterPage();
        Assert.assertEquals(
                registerObject.registerMessage.getText(),
                "New User Signup!"
        );

        registerObject.userCanRegister(
                user.getString("name"),
                user.getString("email")
        );

        Assert.assertEquals(
                registerObject.enterAccountMessage.getText(),
                "ENTER ACCOUNT INFORMATION"
        );

        registerObject.userCanEnterAccountInformation(
                user.getString("password"),
                user.getInt("days"),
                user.getString("month"),
                user.getString("year"),
                user.getString("firstName"),
                user.getString("lastName"),
                user.getString("company"),
                user.getString("address1"),
                user.getString("address2"),
                user.getString("country"),
                user.getString("state"),
                user.getString("city"),
                user.getString("zipCode"),
                user.getString("mobileNumber")
        );

        Assert.assertTrue(
                registerObject.successMessage
                        .getText()
                        .equalsIgnoreCase("Account Created!")
        );
    }

    @Test(priority = 2)
    public void testRegister_ValidMandatoryFieldsWithNewEmail()
            throws Exception {

        homeObject = new HomePage(driver);
        registerObject = new RegisterPage(driver);

        JSONObject user = registerData.getJSONObject("mandatoryUser");

        homeObject.openRegisterPage();

        registerObject.userCanRegister(
                user.getString("name"),
                user.getString("email")
        );

        registerObject.userCanEnterAccountInformation(
                user.getString("password"),
                user.getString("firstName"),
                user.getString("lastName"),
                user.getString("address1"),
                user.getString("country"),
                user.getString("state"),
                user.getString("city"),
                user.getString("zipCode"),
                user.getString("mobileNumber")
        );

        Assert.assertTrue(
                registerObject.successMessage
                        .getText()
                        .equalsIgnoreCase("Account Created!")
        );
    }
}