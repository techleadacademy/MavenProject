package io.techleadacademy.pages;

import io.techleadacademy.util.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(){
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='https://www.phptravels.net/']/img")
    public WebElement logo;

    @FindBy(xpath = "(//a[@id='dropdownCurrency'])[2]")
    public WebElement myAccount_Btn;

    @FindBy(xpath = "//a[text()='Sign Up']")
    public WebElement signUp_Btn;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement logIn_Btn;

    public void rand(){
       logo.sendKeys();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickMyAccountBtn(){
        myAccount_Btn.click();
    }

    public void clickSignUp(){
        clickMyAccountBtn();
        signUp_Btn.click();
    }
}
