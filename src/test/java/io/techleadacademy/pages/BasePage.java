package io.techleadacademy.pages;

import io.techleadacademy.base.TestBase;
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





}
