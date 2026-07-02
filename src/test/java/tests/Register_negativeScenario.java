package tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pages.HomePage;
import pages.RegisterPage;
import utilities.JsonDataReader;

public class Register_negativeScenario extends TestBase {

    HomePage homeObject;
    RegisterPage registerObject;
    JSONObject registerData;

    @BeforeClass
    public void setupData() throws Exception {
        registerData = JsonDataReader.getJsonData(
                "src/test/java/testdata/RegisterData.json");
    }

    @Test
    public void testRegister_ValidFieldsWithExistEmail()
            throws Exception {

        homeObject = new HomePage(driver);
        registerObject = new RegisterPage(driver);

        JSONObject user = registerData.getJSONObject("existingUser");

        homeObject.openRegisterPage();

        registerObject.userCanRegister(
                user.getString("name"),
                user.getString("email")
        );

        Assert.assertEquals(
                registerObject.errorMessage.getText(),
                "Email Address already exist!"
        );
    }
}