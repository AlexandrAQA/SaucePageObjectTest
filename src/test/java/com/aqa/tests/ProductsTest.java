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
        //we can use CollectionUtils.size(allProductsInCartAfterRemove) by org.apache.commons.collections4.CollectionUtils;
        // instead of Assert.assertEquals(allProductsInCartAfterRemove.size()

        Assert.assertEquals(allProductsInCartAfterRemove.size(),
                1, "There is only 1 product in the cart after removing");
        Assert.assertEquals(allProductsInCartAfterRemove.get(0).getText(),
                firstSauceLabsFleeceJacket, "\"Sauce Labs Fleece Jacket\"" +
                        " is in the cart after removing another one");
    }
}
