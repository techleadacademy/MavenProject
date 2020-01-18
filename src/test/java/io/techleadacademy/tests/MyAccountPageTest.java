package io.techleadacademy.tests;

import io.techleadacademy.pages.HomePage;
import io.techleadacademy.pages.MyAccountPage;
import io.techleadacademy.pages.RegisterPage;
import io.techleadacademy.testData.NewUserInfo;
import io.techleadacademy.util.DateUtils;
import io.techleadacademy.util.Screenshots;
import io.techleadacademy.util.SeleniumUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyAccountPageTest extends MyAccountPage {

    @Test
    public void verifyMyAccount() throws InterruptedException {
        NewUserInfo info = new NewUserInfo();
        RegisterPage reg = new RegisterPage();
        HomePage homePage = new HomePage();

        Screenshots.captureScreenShot("shot1");
        reg.registerNewUser();

        Thread.sleep(2000);
        Screenshots.captureScreenShot("account");
        String expected = "My Account";
        String actual = homePage.getTitle();
        Assert.assertEquals(actual, expected, "Expected: " + expected + " | Actual: " + actual);

        String expected1 = "Hi, " + info.getFirstName() + " " + info.getLastName();
        String actual1 = SeleniumUtils.getText(greetingTitle);
        Assert.assertEquals(expected1, actual1, "Expected: " + expected1 + " | Actual: " + actual1);

        String expected2 = new DateUtils().getCurrentFormattedDate();
        String actual2 = SeleniumUtils.getText(dateOfGreetingSection);
        Assert.assertEquals(expected2, actual2, "Expected: " + expected2 + " | Actual: " + actual2);

    }

}
