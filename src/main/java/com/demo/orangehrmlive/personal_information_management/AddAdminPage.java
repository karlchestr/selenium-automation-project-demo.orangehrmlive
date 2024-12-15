package com.demo.orangehrmlive.personal_information_management;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.explicitWaitUntilVisible;

public class AddAdminPage extends AdminPage {
    private By employeeNameField = By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[@placeholder='Type for hints...']");
    private By usernameField = By.xpath("//label[text()='Username']/following::div/input");
    private By passwordField = By.xpath("//label[text()='Password']/following::div/input");
    private By confirmPasswordField = By.xpath("//label[text()='Confirm Password']/following::div/input");
    private By userRoleDropdown = By.xpath("//label[text()='User Role']/following::div[@class='oxd-select-text-input']");
    private By statusDropdown = By.xpath("//label[text()='Status']/following::div[@class='oxd-select-text-input']");
    private By saveButton = By.xpath("//button[@type='submit' and text()=' Save ']");
    private By employeeNameAutoCompleteDiv = By.xpath("//div[@role='listbox']");

    public void selectUserRole(String userRole) {
        explicitWaitUntilVisible(3, userRoleDropdown);
        scrollToElementJS(userRoleDropdown);
        click(userRoleDropdown);

        String currentValue = "";
        while (!currentValue.equalsIgnoreCase(userRole)) {
            find(userRoleDropdown).sendKeys(Keys.ARROW_DOWN);
            currentValue = find(userRoleDropdown).getText();
            System.out.println(currentValue);

            if (currentValue.equalsIgnoreCase(userRole)) {
                find(userRoleDropdown).sendKeys(Keys.ENTER);
            }
        }
    }

    public void selectStatus(String status) {
        explicitWaitUntilVisible(3, statusDropdown);
        click(statusDropdown);

        String currentValue = "";
        while (!currentValue.equalsIgnoreCase(status)) {
            find(statusDropdown).sendKeys(Keys.ARROW_DOWN);
            currentValue = find(statusDropdown).getText();
            System.out.println(currentValue);

            if (currentValue.equalsIgnoreCase(status)) {
                find(statusDropdown).sendKeys(Keys.ENTER);
            }
        }
    }

    public void setEmployeeNameField(String name) {
        explicitWaitUntilVisible(3, employeeNameField);
        set(employeeNameField, name);
        // Wait until the autocomplete dropdown appears
        explicitWaitUntilVisible(5, employeeNameAutoCompleteDiv);
        String selectName = find(employeeNameAutoCompleteDiv).getText();

        while (!selectName.equalsIgnoreCase(name)) {
            selectName = find(employeeNameAutoCompleteDiv).getText();

            if (selectName.equalsIgnoreCase(name)) {
                find(employeeNameField).sendKeys(Keys.ARROW_DOWN);
                find(employeeNameField).sendKeys(Keys.ENTER);
            }
        }
    }

    public void setUsernameField(String username) {
        explicitWaitUntilVisible(3, usernameField);
        set(usernameField, username);
    }

    public void setPasswordField(String password) {
        explicitWaitUntilVisible(3, passwordField);
        set(passwordField, password);
    }

    public void setConfirmPasswordField(String confirmPassword) {
        explicitWaitUntilVisible(3, confirmPasswordField);
        set(confirmPasswordField, confirmPassword);
    }

    public AdminPage clickSaveButton(){
        click(saveButton);
        return new AdminPage();
    }
}
