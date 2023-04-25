package com.aqa.tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void productsShouldBeAddedToCart() {
        final String firstSauceLabsFleeceJacket = "Sauce Labs Fleece Jacket";
        final String secondSauceLabsBackpack = "Sauce Labs Backpack";

        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.addToCart(firstSauceLabsFleeceJacket);
        productsPage.addToCart(secondSauceLabsBackpack);
        headerPage.openCart();
        cartPage.removeProductFromCart(secondSauceLabsBackpack);
    }
}
