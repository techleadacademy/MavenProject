package io.techleadacademy.testData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class NewUserInfo {
    public NewUserInfo(){
        createNewUser();
    }
    private static String firstName;
    private static String lastName;
    private static String cellPhoneNum;
    private static String email;
    private static String password;

    Faker faker = new Faker(new Locale("en-US"));

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String userName) {
        this.firstName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhoneNum() {
        return cellPhoneNum;
    }

    public void setCellPhoneNum(String cellPhoneNum) {
        this.cellPhoneNum = cellPhoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void createNewUser(){
        setCellPhoneNum(faker.phoneNumber().cellPhone());
        setLastName(faker.name().lastName());
        setFirstName(faker.name().firstName());
        setPassword(getFirstName() + getLastName() + "123#");
        setEmail(getFirstName()+"."+getLastName()+"@zzz.com");
    }


}

