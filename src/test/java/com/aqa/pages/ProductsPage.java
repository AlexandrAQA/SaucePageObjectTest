package com.aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{
    //By - this is all locators type
   private final By TITLE = By.cssSelector(".title");
   private final By item =
            By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item']//button");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTitle(){
       return driver.findElement(TITLE);
   }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }
}
