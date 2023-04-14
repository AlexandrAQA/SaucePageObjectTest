package com.aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

   private By userNameInput = By.id("user-name");
   private By passwordInput  = By.id("password");
   private By loginButton  = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void login(String user, String password){
        driver.findElement(userNameInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).submit();

    }
}
