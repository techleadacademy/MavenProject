package io.techleadacademy.old;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestingTestNG {

    @Test
    public void testTwoNums(){
        int actualNum = 9;
        int expectedNum = 8;
        Assert.assertEquals(actualNum,expectedNum);
    }

}
