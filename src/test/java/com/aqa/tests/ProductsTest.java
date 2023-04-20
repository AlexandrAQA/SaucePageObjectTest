package com.aqa.tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void productsShouldBeAddedToCart() {
        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.addToCart("Sauce Labs Fleece Jacket");

    }
}
