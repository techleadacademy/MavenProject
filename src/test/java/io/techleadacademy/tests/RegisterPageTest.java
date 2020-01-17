package io.techleadacademy.tests;

import io.techleadacademy.pages.RegisterPage;
import org.testng.annotations.Test;

public class RegisterPageTest extends RegisterPage {
    @Test
    public void verifyRegisterPageTitle(){
        navigateToRegisterPage();
        registerNewUser();
    }
}
