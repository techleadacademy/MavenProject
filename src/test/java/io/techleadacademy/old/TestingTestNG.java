package io.techleadacademy.old;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class TestingTestNG {

    @Test
    public void testTwoNums(){
        int actualNum = 9;
        int expectedNum = 9;
        Assert.assertEquals(actualNum,expectedNum);
        Reporter.log("Testing additions of two positive numbers");
    }

}
