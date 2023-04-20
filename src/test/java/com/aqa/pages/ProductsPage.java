package com.aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    //By - this is all locators type
    private final By TITLE = By.cssSelector(".title");
    private String addToCartButton =
            "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public WebElement getTitle() {
        return driver.findElement(TITLE);
    }

    //The Method takes locator (addToCartButton)
    //then changes %s on our String productName
    public void addToCart(String productName) {
        By fullLocatorForAddToCart = By.xpath(String.format(addToCartButton, productName));
        //find the element and click
        driver.findElement(fullLocatorForAddToCart).click();
    }
}
