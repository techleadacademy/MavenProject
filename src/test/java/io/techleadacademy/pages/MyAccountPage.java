package io.techleadacademy.pages;

import io.techleadacademy.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {
    public MyAccountPage(){
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[@class='text-align-left']")
    public WebElement greetingTitle;

    @FindBy(xpath = "//span[@class='h4']")
    public WebElement dateOfGreetingSection;


}
