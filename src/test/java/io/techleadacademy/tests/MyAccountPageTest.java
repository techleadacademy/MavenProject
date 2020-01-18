package io.techleadacademy.tests;

import io.techleadacademy.pages.HomePage;
import io.techleadacademy.pages.MyAccountPage;
import io.techleadacademy.pages.RegisterPage;
import io.techleadacademy.testData.NewUserInfo;
import io.techleadacademy.util.DateUtils;
import io.techleadacademy.util.SeleniumUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyAccountPageTest extends MyAccountPage {

    @Test
    public void verifyMyAccount() throws InterruptedException {
        NewUserInfo info = new NewUserInfo();
        RegisterPage reg = new RegisterPage();
        HomePage home = new HomePage();

        SeleniumUtils.highlightElement(home.myAccount_Btn);
        home.clickSignUp();
        reg.registerNewUser();

        Thread.sleep(2000);

        String expected = "My Account";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Expected: " + expected + " | Actual: " + actual);

        String expected1 = "Hi, " + info.getFirstName() + " " + info.getLastName();
        String actual1 = driver.findElement(By.xpath("//h3[@class='text-align-left']")).getText();
        Assert.assertEquals(expected1, actual1, "Expected: " + expected1 + " | Actual: " + actual1);

        String expected2 = new DateUtils().getCurrentFormattedDate();
        String actual2 = driver.findElement(By.xpath("//span[@class='h4']")).getText();
        Assert.assertEquals(expected2, actual2, "Expected: " + expected2 + " | Actual: " + actual2);

    }
}
