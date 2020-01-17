package io.techleadacademy.pages;

import io.techleadacademy.base.TestBase;
import io.techleadacademy.testData.NewUserInfo;
import io.techleadacademy.tests.HomePageTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends TestBase {
    /**
     * Task Jan - 12
     * //        1. Navigate to phptravels.net/home
     * //        2. Verify page title
     * //        "PHPTRAVELS | Travel Technology Partner"
     * //        3. Crate a new account:
     * //        Click on "My account"
     * //        Click on "Sign Up"
     * //        Fill Out "Register" form
     * //        Click Sumbit
     * //        Verify Sign Up was successfull
     * //                (How? Assert after you click Submit it takes you to profile page)
     * //        4. Verify on "Profile page":
     * //        Title is "My Account"
     * //        Its says "Hi, firstName LastName"
     * //        Today's date
     */
    @FindBy(xpath = "//div[@class='xxx']")
    public WebElement firstName;

    public void navigateToRegisterPage(){
        HomePage homePage = new HomePage();
        homePage.clickSignUp();
    }

    public void registerNewUser(){
        NewUserInfo user = new NewUserInfo();
        firstName.sendKeys(user.getFirstName());
    }
}
