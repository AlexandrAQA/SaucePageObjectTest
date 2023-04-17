package com.aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    //By - this is all locators type
   private final By TITLE = By.cssSelector(".title");
   WebDriver driver;

    public ProductsPage( WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTitle(){
       return driver.findElement(TITLE);
   }
}
