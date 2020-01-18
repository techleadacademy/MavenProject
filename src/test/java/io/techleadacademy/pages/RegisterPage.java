package io.techleadacademy.pages;

import io.techleadacademy.testData.NewUserInfo;
import io.techleadacademy.tests.HomePageTest;
import io.techleadacademy.util.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.reporters.jq.Main;

public class RegisterPage extends BasePage {
    public RegisterPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    NewUserInfo user = new NewUserInfo();
    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='confirmpassword']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signUp_Btn;




    public void navigateToRegisterPage(){
        HomePage homePage = new HomePage();
        homePage.clickSignUp();
    }

    public void registerNewUser() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.clickSignUp();
        Thread.sleep(2000);
        SeleniumUtils.sendKeys(firstName, user.getFirstName());
        SeleniumUtils.sendKeys(lastName, user.getLastName());
        SeleniumUtils.sendKeys(phone, user.getCellPhoneNum());
        SeleniumUtils.sendKeys(email, user.getEmail());
        SeleniumUtils.sendKeys(password, user.getPassword());
        SeleniumUtils.sendKeys(confirmPassword, user.getPassword());

        clickSignUp();
    }

    public void clickSignUp(){
        SeleniumUtils.click(signUp_Btn);
    }

    public String getTilte(){
        return driver.getTitle();
    }




}
