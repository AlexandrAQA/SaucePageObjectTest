package com.aqa.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest{
    public static final String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";

    @Test
    public void checkoutOverviewShouldBeDisplayedAfterCheckout() {
        loginSteps.loginAsDefaultUser();
        productsPage.addToCart(SAUCE_LABS_BACKPACK);
        headerPage.openCart();
        cartPage.checkout();
        checkoutPage.fillInCheckoutInfo("First Name", "Last Name", "Postal Code");
        assertEquals(checkoutOverviewPage.getTitle().getText(), "Checkout: Overview",
                "Checkout overview is not displayed after user clicks on \"Finish\" button");
    }
}
