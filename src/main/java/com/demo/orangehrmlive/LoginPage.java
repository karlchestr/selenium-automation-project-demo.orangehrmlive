package com.demo.orangehrmlive;

import base.BasePage;
import org.openqa.selenium.By;

import static utilities.GetUtility.getText;
import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.explicitWaitUntilTextVisible;
import static utilities.WaitUtility.explicitWaitUntilVisible;

public class LoginPage extends BasePage {
    private By usernameField = By.xpath("//div[@id='app']//input[@name='username']");
    private By passwordField = By.xpath("//div[@id='app']//input[@name='password']");
    private By loginButton = By.xpath("//div[@id='app']//button[@type='submit']");
    private By errorMessageField = By.xpath("//div[@id='app']//p[text()='Invalid credentials']");

    public DashboardPage loginToApplication(String username, String password) {
        explicitWaitUntilVisible(5, usernameField);
        scrollToElementJS(usernameField);
        set(usernameField, username);
        set(passwordField, password);
        click(loginButton);
        return new DashboardPage();
    }

    public String getLoginErrorMessage() {
        explicitWaitUntilVisible(5, errorMessageField);
        explicitWaitUntilTextVisible(5, errorMessageField);
        return getText(errorMessageField);
    }
}
