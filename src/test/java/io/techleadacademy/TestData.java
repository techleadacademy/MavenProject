package io.techleadacademy;

import com.github.javafaker.Faker;

public class TestData {
    /*
    using Faker class
    1. create a method which will return a random First name - getRandomFirstName
    2. create a method which will return a random last name - getRandomLastName
    3. create a method which will return a random phone number - getRandomPhoneNum
    4. create a method which will return a random address - getRandomAddress
            Ex: 10090 Main Street, Fairfax, VA, 22031

     */
    Faker data = new Faker();

    public String getRandomFirstName(){
        return data.name().firstName();
    }
    public String getRandomLastName(){
        return data.name().lastName();
    }
    public String getRandomPhoneNum(){
        String num = data.phoneNumber().cellPhone();
        return  num;
    }
    public String getRandomAddress(){
        return  data.address().fullAddress();
    }

}
