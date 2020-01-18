package io.techleadacademy.tests;

import io.techleadacademy.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends RegisterPage {
    @Test(groups = {"smoke"})
    public void verifyRegisterPageTitle() throws InterruptedException {
        String expected = driver.getTitle();
        //navigateToRegisterPage();
        Thread.sleep(3000);
        registerNewUser();

        String actual =driver.getTitle();
        Assert.assertNotEquals(expected, actual, "Expected: " + expected + " | Actual: " + actual);

    }
}
