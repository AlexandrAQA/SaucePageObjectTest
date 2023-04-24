package com.aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    //Sauce Labs Backpack
    String removeButton = "//div[text()='%s']//ancestor::div[@class='cart_item']//button";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void removeProductFromCart(String productName) {
        By fullLocator = By.xpath(String.format(removeButton, productName));
        //find the element and click
        driver.findElement(fullLocator).click();
    }
}
