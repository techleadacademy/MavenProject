package io.techleadacademy.util;

import io.techleadacademy.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumUtils extends TestBase {

    public static void sleep(long milliSeconds){
        try{
            Thread.sleep(milliSeconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void waitForClickability(WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForVisibilityOfAll(List<WebElement> list){
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(list));
    }

    public static void waitForVisibilityOfElement(WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void click(WebElement element){
        highlightElement(element);
        waitForClickability(element);
        element.click();
    }

    public static void sendKeys(WebElement element, String input){
        highlightElement(element);
        waitForVisibilityOfElement(element);
        element.sendKeys(input);
    }

    public static String getText(WebElement element){
        waitForVisibilityOfElement(element);
        return element.getText();
    }

    public static void moveIntoView(WebElement element){
        try {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void highlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //moveElementIntoView(element);
        for(int i = 0; i < 2; i++){
            try{
                if (i == 0) {
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 3px solid red; background: yellow");
                }else{
                    sleep(1000);
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }





}
