package io.techleadacademy.Jan12;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT {

    @DataProvider(name = "dataName")
    public Object[][] testData(){
        Object[][] data = new Object[3][2];
        data[0][0] = 2 + 2;
        data[0][1] = 4;
        data[1][0] = 200 + 50;
        data[1][1] = 250;
        data[2][0] = -300 + 20;
        data[2][1] = 280;
        return data;
    }

    @Test(dataProvider = "dataName")
    public void AdditionTest(int actual, int expected){
//        int actual = 2 + 2;
//        int expected = 4;
        System.out.println("Actual: " + actual + " | Expected: " + expected);
        Assert.assertEquals(actual, expected);
    }


}
