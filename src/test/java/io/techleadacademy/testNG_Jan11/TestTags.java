package io.techleadacademy.testNG_Jan11;

import io.techleadacademy.SeleniumWaits;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;


public class TestTags {

    @Test(description = "Adding positive numbers")
    public void add1(Method method){
        int actual = 6;
        Assert.assertTrue(actual == 6);
        Test test = method.getAnnotation(Test.class);
        System.out.println(test.description());
    }

    @Test(description = "Testing negative numbers")
    public void add2(){
        int actual = -5;
        Assert.assertTrue(actual == -10+5);
    }
    @Test(priority = -1, groups = {"smoke test", "regression"})
    public void subtract1(){
        int actual = 3;
        Assert.assertEquals(actual, 6-3);
    }

    @Test(priority = -2)
    public void subtract2(){
        int actual = -2;
        Assert.assertEquals(actual, -1-1);
    }

    @Test(groups = {"smoke test"})
    public void multiply(){

    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divide1(){
        Assert.assertEquals(4/0, 0);
    }

    @Test(expectedExceptions = {NoSuchElementException.class, ArithmeticException.class,
            ElementNotVisibleException.class, ElementNotInteractableException.class})
    public void divide2(){
        Assert.assertEquals(4/0, 0);
    }

    @Test(enabled = false)
    public void signUpTest(){
        String invalidPassword = "  ";
        String validPassword = "123456";
        Assert.assertTrue(invalidPassword.equals(validPassword));
    }

    @Test(invocationCount = 10)
    public void logInPerformanceTest1(){
        System.out.println("Checking log in time");
    }

    @Test(invocationCount = 2, invocationTimeOut = 3000, groups = {"regression"})
    public void logInPerformanceTest2(){
        System.out.println("Checking log in time");
        new SeleniumWaits().sleep(1000);
    }

    @Test(invocationCount = 3, skipFailedInvocations = true)
    public void logInPerformanceTest3(){
        //Assert.fail();
    }

    @Test(timeOut = 4000)
    public void methodTimeOut(){
        Assert.assertTrue(true);
    }

    @Parameters({"username", "password"})
    @Test
    public void testUserName1(@Optional("AAA") String username, @Optional("55") String password){
        Reporter.log("Testing log in functionality using valid credentials");
        String actual = "AAA";
        String expected = username;
        Assert.assertEquals(actual, expected);

    }



}
