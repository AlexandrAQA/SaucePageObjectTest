package com.aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage{

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a")
    @CacheLookup
    private WebElement cartLink;


    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void openCart(){
        cartLink.click();
    }
}
