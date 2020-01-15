package io.techleadacademy.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        initialize("chrome");
    }

    @AfterMethod
    public void tearDown(){
        closeDriver();
    }

    public static void initialize(String browser){
        if (driver != null )
            return;
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Invalid browser type");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("https://phptravels.net/home");
    }

    public static void closeDriver(){
        if (driver != null){
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver(){
        if (driver!=null)
            driver.quit();
        driver = null;
    }



}
