package io.techleadacademy.tests;

import io.techleadacademy.pages.RegisterPage;
import io.techleadacademy.util.Retry;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

public class RegisterPageTest extends RegisterPage {
    @Test(retryAnalyzer = Retry.class)
    public void verifyRegisterPageTitle() throws InterruptedException {
        String expected = driver.getTitle();
        //navigateToRegisterPage();
        Thread.sleep(3000);
        registerNewUser();

        String actual =driver.getTitle();
        Assert.assertEquals(expected, actual, "Expected: " + expected + " | Actual: " + actual);

    }
}
