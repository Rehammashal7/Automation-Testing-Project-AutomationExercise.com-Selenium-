package tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import pages.HomePage;
import pages.LoginPage;
import utilities.JsonDataReader;

public class Login_happyScenario extends TestBase {

    LoginPage loginObject;
    HomePage homeObject;

    @Test
    public void testLogin_CorrectUsernameAndMatchingPassword()
            throws Exception {

        JSONObject loginData =
                JsonDataReader.getJsonData(
                        "src/test/java/testdata/LoginData.json");

        String email = loginData
                .getJSONObject("validUser")
                .getString("email");

        String password = loginData
                .getJSONObject("validUser")
                .getString("password");

        loginObject = new LoginPage(driver);
        homeObject = new HomePage(driver);

        homeObject.openLoginPage();

        Assert.assertEquals(
                loginObject.loginMessage.getText(),
                "Login to your account"
        );

        loginObject.userCanLogin(email, password);

        Assert.assertTrue(loginObject.logoutBtn.isEnabled());

        loginObject.userCanlogout();
    }
}