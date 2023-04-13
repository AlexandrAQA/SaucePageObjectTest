package com.aqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void userShouldLoginWithValidCredentials(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).submit();
        WebElement titleProducts = driver.findElement(By.cssSelector(".title"));
        Assert.assertTrue(titleProducts.isDisplayed(), "User was not logged in");
    }
}
