package com.demo.orangehrmlive.personal_information_management;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static utilities.WaitUtility.explicitWaitUntilVisible;

public class AddEmployeePage extends PersonalInformationPage {
    private By idField = By.xpath("//div[@id='app']//div[@class='orangehrm-card-container']//input[@class='oxd-input oxd-input--active']");
    private By firstNameField = By.xpath("//div[@id='app']//input[@name='firstName']");
    private By middleNameField = By.xpath("//div[@id='app']//input[@name='middleName']");
    private By lastNameField = By.xpath("//div[@id='app']//input[@name='lastName']");
    private By saveButton = By.xpath("//div[@id='app']//button[text()=' Save ']");

    private void setId(String id) {
        // Just to make sure the id field is cleared because .clear function doesn't work
        WebElement textField = find(idField);
        textField.sendKeys(Keys.CONTROL + "a");
        textField.sendKeys(Keys.DELETE);
        textField.sendKeys(id);
    }

    private void setFirstName(String firstName) {
        set(firstNameField,firstName);
    }

    private void setMiddleName(String middleName) {
        set(middleNameField, middleName);
    }

    private void setLastName(String lastName) {
        set(lastNameField, lastName);
    }

    private void clickSaveButton() {
        click(saveButton);
    }

    public EmployeePage addEmployee(String firstName, String middleName, String lastName, String id) {
        explicitWaitUntilVisible(10, firstNameField); // Just to make sure the first element is loaded in the page
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setId(id);
        clickSaveButton();
        // After adding an employee, the app is redirected to the employee's page
        return new EmployeePage();
    }
}