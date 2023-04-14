package com.aqa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{



    @Test
    public void userShouldLoginWithValidCredentials(){
        loginPage.login("standard_user", "secret_sauce");
        WebElement titleProducts = driver.findElement(By.cssSelector(".title"));
        Assert.assertTrue(titleProducts.isDisplayed(), "User was not logged in");
    }
    @Test
    public void passwordShouldBeCorrectForLogin(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys(" ");
        driver.findElement(By.id("login-button")).submit();
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals(errorMessage.getText(), errorTextWhenPswIncorrect,"the error message is incorrect" );
    }
    @Test
    public void passwordShouldBeRequiredForLogin(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).submit();
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals(errorMessage.getText(), errorTextWhenPswIsEmpty,"the error message is incorrect" );
    }
}
