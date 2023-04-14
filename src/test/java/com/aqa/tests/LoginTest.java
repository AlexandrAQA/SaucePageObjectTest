package com.aqa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void userShouldLoginWithValidCredentials() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        WebElement titleProducts = driver.findElement(By.cssSelector(".title"));
        Assert.assertTrue(titleProducts.isDisplayed(), "User was not logged in");
    }

    @Test
    public void passwordShouldBeCorrectForLogin() {
        loginPage.open();
        loginPage.login("standard_user", " ");
        Assert.assertEquals(loginPage.getErrorFromThePage(),
                errorTextWhenPswIncorrect, "the error message is incorrect");
    }

    @Test
    public void passwordShouldBeRequiredForLogin() {
        loginPage.open();
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorFromThePage(),
                errorTextWhenPswIsEmpty, "the error message is incorrect");
    }
    @Test
    public void loginShouldBeRequiredForLogin() {
        loginPage.open();
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorFromThePage(),
                errorTextWhenLoginIsEmpty, "the error message is incorrect");
    }
}
