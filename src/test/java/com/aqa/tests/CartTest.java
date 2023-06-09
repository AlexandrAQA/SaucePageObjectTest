package com.aqa.tests;

import com.aqa.utils.retry.RetryAnalyzer;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void continueShoppingShouldReturnUserOnProductsPage() {
        loginSteps.loginAsDefaultUser();
        headerPage.openCart();
        cartPage.continueShopping();
        assertTrue(productsPage.getTitle().isDisplayed(),
                "The continue shopping button does not redirect to the product page");
    }

    @Test
    public void checkoutShouldOpenCheckoutPage() {
        loginSteps.loginAsDefaultUser();
        headerPage.openCart();
        cartPage.checkout();
        assertEquals(checkoutPage.getTitle().getText(),
                "Checkout: Your Information", "The checkout button does not open checkout page");
    }
}
