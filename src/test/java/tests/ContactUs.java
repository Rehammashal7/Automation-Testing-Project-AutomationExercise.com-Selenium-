package tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pages.ContactUsForm;
import pages.HomePage;
import utilities.JsonDataReader;

public class ContactUs extends TestBase {

    HomePage homeObject;
    ContactUsForm contactObject;
    JSONObject contactData;

    @BeforeClass
    public void setupData() throws Exception {
        contactData = JsonDataReader.getJsonData(
                "src/test/java/testdata/ContactUsData.json");
    }

    @Test
    public void testContactUS() throws Exception {

        homeObject = new HomePage(driver);
        contactObject = new ContactUsForm(driver);

        JSONObject user =
                contactData.getJSONObject("contactUser");

        homeObject.contactUsBtn.click();

        Assert.assertEquals(
                contactObject.contactPageMessage.getText(),
                "GET IN TOUCH"
        );

        String filePath =
                System.getProperty("user.dir")
                + "\\images\\boo.jpg";

        contactObject.ContactUSForm(
                user.getString("name"),
                user.getString("email"),
                user.getString("subject"),
                user.getString("message"),
                filePath
        );

        contactObject.simpleAlert =
                driver.switchTo().alert();

        contactObject.simpleAlert.accept();

        Assert.assertEquals(
                contactObject.FormSentMessage.getText(),
                "Success! Your details have been submitted successfully."
        );
    }
}