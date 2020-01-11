package io.techleadacademy.old;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.techleadacademy.SeleniumWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class OrangeNewsEdit {
    WebDriver driver;

    @Test
    public void projectDay(){
        //SET UP
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        SeleniumWaits method = new SeleniumWaits();

        //NAVIGATING TO PAGE AND VERIFYING TITLE
        String expectedTitle = "OrangeHRM";
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
        Assert.assertEquals(driver.getTitle(), expectedTitle);

        //LOG IN AS CERTAIN ROLE (ADMIN)
        WebElement logIn_Btn = driver.findElement(By.id("loginAsButtonGroup"));
        logIn_Btn.click();
        //Existing users are: "ESS User", "1st Level Supervisor", "System Administrator", "Administrator
        WebElement userRole = logIn_Btn.findElement(By.xpath(".//*[.='Administrator']"));

        method.waitForClickability(driver, userRole);
        userRole.click();

        //CLICKING OPTIONS IN MENU BAR
        WebElement menuContent = driver.findElement(By.id("menu-content"));
        WebElement adminButton = menuContent.findElement(By.id("menu_admin_viewAdminModule"));
        method.waitForClickability(driver, adminButton);
        adminButton.click();
        WebElement announcements = menuContent.findElement(By.id("menu_news_Announcements"));
        announcements.click();
        WebElement news = menuContent.findElement(By.id("menu_news_viewNewsList"));
        news.click();

        //SWITCHING TO IFRAME
        String mainFrame = "noncoreIframe";
        driver.switchTo().frame(mainFrame);

        List<WebElement> allRows = driver.findElements(By.className("dataRaw"));
        method.waitForVisibilityOfAll(driver, allRows);
        System.out.println(allRows.size());

        //Storing in map
        Map<String, List<String>> map = new HashMap<>();

//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        for (WebElement element: allRows){
//            String key = element.findElement(By.xpath(".//td[2]")).getText();
//            List<String> ls = new ArrayList<>();
//            ls.add(element.findElement(By.xpath(".//td[3]")).getText());
//            ls.add(element.findElement(By.xpath(".//td[6]")).getText());
//            if(element.findElement(By.xpath(".//td[7]//i")).getAttribute("class").contains("disabled")){
//                ls.add("Attachment - NO");
//            }else{
//                ls.add("Attachment - YES");
//            }
//            map.put(key, ls);
//        }
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        for (String key: map.keySet()){
//            System.out.print(key);
//            for (String s: map.get(key)){
//                System.out.print(" | " + s);
//            }
//            System.out.print("\n");
//        }

        WebElement addNews = driver.findElement(By.id("list_item_add"));
        method.waitForClickability(driver, addNews);
        addNews.click();

        method.sleep(3000);
        WebElement inputTopic = driver.findElement(By.id("news_topic"));
        method.waitForVisibility(driver, inputTopic);
        String input_topic_text = "Congratulations AA";
        inputTopic.sendKeys(input_topic_text);

        //Switch to inner iframe
        driver.switchTo().frame("news_description_ifr");

        //Getting current date with based on required format
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = formatter.format(date);
        String input_desc_text = "Promotion was awarded to AA on " + currentDate;

        WebElement inputDesc = driver.findElement(By.id("tinymce"));
        inputDesc.sendKeys(input_desc_text);

        driver.switchTo().parentFrame();
        WebElement nextBtn = driver.findElement(By.id("nextBtn"));
        nextBtn.click();

        WebElement publishToAll_btn = driver.findElement(By.xpath("//label[@for='news_publish_all']"));
        method.waitForClickability(driver, publishToAll_btn);
        publishToAll_btn.click();

        WebElement publish_Btn = driver.findElement(By.xpath("//button[@btn-type='publish']"));
        publish_Btn.click();

        allRows = driver.findElements(By.className("dataRaw"));
        method.waitForVisibilityOfAll(driver, allRows);
        System.out.println(allRows.size());
        int count = 0;
        for(WebElement element: allRows){
            if(element.findElement(By.xpath(".//td[2]")).getText().equals(input_topic_text))
                count++;
        }
        System.out.println(count);
        Assert.assertTrue(count > 0);

        //Log out
        WebElement userOptions = driver.findElement(By.id("account-job"));
        userOptions.click();
        WebElement logOut_btn = driver.findElement(By.id("logoutLink"));
        logOut_btn.click();

        //LOG IN AS CERTAIN ROLE (ADMIN)
        logIn_Btn = driver.findElement(By.id("loginAsButtonGroup"));
        method.waitForClickability(driver, logIn_Btn);
        logIn_Btn.click();
        //Existing users are: "ESS User", "1st Level Supervisor", "System Administrator", "Administrator
        userRole = logIn_Btn.findElement(By.xpath(".//*[.='ESS User']"));

        method.waitForClickability(driver, userRole);
        userRole.click();

        WebElement newsTable = driver.findElement(By.id("newsOnDashboard"));
        method.waitForVisibility(driver, newsTable);

        List<WebElement> newsDataRows = newsTable.findElements(By.xpath(".//a[@class='truncate topic left-space']"));

        for (WebElement element: newsDataRows){
            WebElement topic_desc = element.findElement(By.xpath(".//ancestor::li//div[@class='truncate left-align']"));
            Assert.assertEquals(element.getText(), input_topic_text);
            System.out.println(element.getText());
            Assert.assertEquals(topic_desc.getText(), input_desc_text);
            System.out.println(topic_desc.getText());
        }





    }

}
