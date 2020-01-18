package io.techleadacademy.pages;

import io.techleadacademy.base.TestBase;
import io.techleadacademy.util.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends TestBase {
    public BasePage(){
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "anyname")
    public WebElement anyelement;


    public String getTitle(){
        SeleniumUtils.waitForPageToLoad();
        return driver.getTitle();
    }



}
