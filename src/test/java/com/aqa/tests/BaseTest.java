package com.aqa.tests;

import com.aqa.pages.*;
import com.aqa.steps.LoginSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    ProductsPage productsPage;
    HeaderPage headerPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    LoginSteps loginSteps;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        if (browser.equals("chrome")) {
            //Initialize web driver and create driver instance
            WebDriverManager.chromedriver().setup();
            //created ChromeOptions
            ChromeOptions options = new ChromeOptions();
            //without launching web browser!!!
            //options.addArguments("--headless=new");

            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //Set up driver settings
            driver.manage().window().maximize();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Pages
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        headerPage = new HeaderPage(driver);
        cartPage = new CartPage(driver);

        //Steps
        loginSteps = new LoginSteps(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
