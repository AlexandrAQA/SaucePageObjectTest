package com.aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {
    //By - this is all locators type
    @FindBy(css = ".title")
    @CacheLookup
    private WebElement title;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public WebElement getTitle() {
        return title;
    }

    //The Method takes locator (addToCartButton)
    //then changes %s on our String productName
    public void addToCart(String productName) {
        String addToCartButton = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";
        By fullLocatorForAddToCart = By.xpath(String.format(addToCartButton, productName));
        //find the element and click
        driver.findElement(fullLocatorForAddToCart).click();
    }
}
