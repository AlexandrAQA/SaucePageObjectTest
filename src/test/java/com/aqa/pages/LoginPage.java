package com.aqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userNameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "h3[data-test='error']")
    private WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String user, String password) {
        userNameInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.submit();
    }

    public String getErrorFromThePage() {
        return error.getText();
    }

    @Test
    public void loginAsValidUser() {
        login("standard_user", "secret_sauce");

    }
}
