package com.aqa.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginDataProviderTest extends BaseTest{

    @DataProvider(name = "invalid users")
    public Object[][] loginData(){
        return new Object[][]{
                {"standard_user","","Epic sadface: Password is required"},
                {"","123456","Epic sadface: Username is required"},
        };
    }

    @Test(dataProvider = "invalid users")
    public void passwordShouldBeRequiredForLogin(String username, String pass, String error) {
        loginSteps.login(username, pass);
        assertEquals(loginPage.getError(), error, "The error is incorrect");
    }

    @Test(dataProvider = "invalid users")
    public void userNameShouldBeRequiredForLogin(String username, String pass, String error) {
        loginSteps.login(username, pass);
        assertEquals(loginPage.getError(), error, "The error is incorrect");
    }
}
