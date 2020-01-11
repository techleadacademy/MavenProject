package io.techleadacademy;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenPractice {

    public static void main(String[] args) {
        TestData test = new TestData();
        System.out.println(test.getRandomFirstName());
        System.out.println(test.getRandomLastName());
        System.out.println(test.getRandomPhoneNum());
        System.out.println(test.getRandomAddress());

        
    }

}
