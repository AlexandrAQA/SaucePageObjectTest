package com.aqa.tests;

import com.aqa.utils.PropertiesLoader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginCrTest extends BaseTest{

    @Parameters({"username","password"})
    @Test
    public void userShouldLoginWithValidCredentials(String username, String password) {
        //loginSteps.loginAsStandardUser();
        loginSteps.login(username, password);
        assertTrue(productsPage.getTitle().isDisplayed(), "User was not logged in");
    }

    // the parameters not for final prod's code
    @Test
    public void passwordShouldBeRequiredForLogin() {
        loginSteps.login("standard_user", "");
        String expected = "Epic sadface: Password is required";
        assertEquals(loginPage.getError(), expected, "The error is incorrect");
    }

    @Test
    public void userNameShouldBeRequiredForLogin() {
        loginSteps.login("", "12345");
        String expected = "Epic sadface: Username is required";
        assertEquals(loginPage.getError(), expected, "The error is incorrect");
    }

    @Test
    public void userShouldNotBeLoggedInBeWithInvalidPassword() {
        loginSteps.login("standard_user", "12345");
        String expected = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(loginPage.getError(), expected, "The error is incorrect");
    }

    @Test
    public void userShouldNotBeLoggedInBeWithInvalidUserName() {
        loginSteps.login("standard_user1", "secret_sauce");
        String expected = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(loginPage.getError(), expected, "The error is incorrect");
    }

    @Test
    public void lockedOutUserShouldNotBeLoggedIn() {
        Properties properties = PropertiesLoader.loadProperties("locked_out_user.properties");
        loginSteps.login(properties.getProperty("username"), properties.getProperty("password"));
        String expected = "Epic sadface: Sorry, this user has been locked out.";
        assertEquals(loginPage.getError(), expected, "The error is incorrect");
    }
}
