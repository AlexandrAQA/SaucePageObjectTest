package com.aqa.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTest extends BaseTest {

    @Test
    public void productsShouldBeAddedToCart() {
        String firstSauceLabsFleeceJacket = "Sauce Labs Fleece Jacket";
        String secondSauceLabsBackpack = "Sauce Labs Backpack";

        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.addToCart(firstSauceLabsFleeceJacket);
        productsPage.addToCart(secondSauceLabsBackpack);
        headerPage.openCart();
        cartPage.removeProductFromCart(secondSauceLabsBackpack);
        List<WebElement> allProductsInCartAfterRemove = cartPage.getAllProductsInCart();

        Assert.assertEquals(allProductsInCartAfterRemove.size(),
                1, "There is only 1 product in the cart after removing");
    }
}
