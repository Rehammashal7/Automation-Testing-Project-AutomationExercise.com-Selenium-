package tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pages.HomePage;
import pages.LoginPage;
import utilities.JsonDataReader;

public class Login_NegativeScenario extends TestBase {

    LoginPage loginObject;
    HomePage homeObject;
    JSONObject loginData;

    @BeforeClass
    public void setupData() throws Exception {
        loginData = JsonDataReader.getJsonData(
                "src/test/java/testdata/LoginData.json");
    }

    @Test(priority = 1)
    public void testLogin_CorrectUsernameAndNotMatchingPassword()
            throws Exception {

        loginObject = new LoginPage(driver);
        homeObject = new HomePage(driver);

        String email = loginData
                .getJSONObject("invalidPasswordUser")
                .getString("email");

        String password = loginData
                .getJSONObject("invalidPasswordUser")
                .getString("password");

        homeObject.openLoginPage();

        Assert.assertEquals(
                loginObject.loginMessage.getText(),
                "Login to your account"
        );

        loginObject.userCanLogin(email, password);

        Assert.assertEquals(
                loginObject.errorMessage.getText(),
                "Your email or password is incorrect!"
        );
    }

    @Test(
        priority = 2,
        dependsOnMethods = {
            "testLogin_CorrectUsernameAndNotMatchingPassword"
        }
    )
    public void testLogin_InCorrectUsername()
            throws Exception {

        loginObject = new LoginPage(driver);
        homeObject = new HomePage(driver);

        String email = loginData
                .getJSONObject("invalidEmailUser")
                .getString("email");

        String password = loginData
                .getJSONObject("invalidEmailUser")
                .getString("password");

        homeObject.openLoginPage();

        Assert.assertEquals(
                loginObject.loginMessage.getText(),
                "Login to your account"
        );

        loginObject.userCanLogin(email, password);

        Assert.assertEquals(
                loginObject.errorMessage.getText(),
                "Your email or password is incorrect!"
        );
    }
}