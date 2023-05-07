package com.aqa.pages;

import com.aqa.utils.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Properties;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    @CacheLookup
    private WebElement userNameInput;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
    }

    public void login(String user, String password) {
        userNameInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.submit();
    }

    public String getErrorFromThePage() {
        return error.getText();
    }


    public void loginAsValidUser() {
        login("standard_user", "secret_sauce");

    }

    public void loginAsStandardUser() {
        Properties properties = PropertiesLoader.loadProperties();
        userNameInput.sendKeys(properties.getProperty("username"));
        passwordInput.sendKeys(properties.getProperty("password"));
        loginButton.submit();
    }

    public void loginAsDefaultUser() {
        Properties properties = PropertiesLoader.loadProperties();
        userNameInput.sendKeys(properties.getProperty("username"));
        passwordInput.sendKeys(properties.getProperty("password"));
        loginButton.submit();
    }
}
