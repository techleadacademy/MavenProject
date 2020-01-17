package io.techleadacademy.tests;

import io.techleadacademy.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends HomePage {

    @Test
    public void verifyHomeTitle(){
        String actual = driver.getTitle();
        Assert.assertEquals(actual, "PHPTRAVELS | Travel Technology Partner");
    }





}
