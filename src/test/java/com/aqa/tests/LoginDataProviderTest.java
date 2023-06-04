package com.aqa.tests;

import com.aqa.utils.PropertiesLoader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class LoginDataProviderTest extends BaseTest{

    @DataProvider(name = "invalid users")
    public Object[][] loginData(){
        Properties properties = PropertiesLoader.loadProperties("locked_out_user.properties");
        return new Object[][]{
                {"standard_user","","Epic sadface: Password is required"},
                {"","123456","Epic sadface: Username is required"},
                {"standard_user","invalid_psw","Epic sadface: Username and password do not match any user in this service"},
                {"invalid_user","secret_sauce","Epic sadface: Username and password do not match any user in this service"},
                {properties.getProperty("username"),properties.getProperty("password"),
                        "Epic sadface: Sorry, this user has been locked out."},
        };
    }

    @Test(dataProvider = "invalid users")
    public void passwordShouldBeRequiredForLogin(String username, String pass, String error) {
        loginSteps.login(username, pass);
        assertEquals(loginPage.getError(), error, "The error is incorrect");
    }
}
