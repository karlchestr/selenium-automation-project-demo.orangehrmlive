package com.demo.orangehrmlive.personal_information_management;

import com.demo.orangehrmlive.DashboardPage;
import org.openqa.selenium.By;

import static utilities.WaitUtility.explicitWaitUntilVisible;

// Employee List Page
public class PersonalInformationPage extends DashboardPage {
    private By addEmployeeButton = By.xpath("//div[@id='app']//div[@class='orangehrm-header-container']//button[text()=' Add ']");
    private By employeeIdField = By.xpath("//div[@id='app']//div[@class='oxd-table-filter-area']//input[@class='oxd-input oxd-input--active']");
    private By searchButton = By.xpath("//div[@id='app']//button[text()=' Search '][1]");
    private By editButton = By.xpath("//div[@id='app']//button[@class='oxd-icon-button oxd-table-cell-action-space'][1]");

    public AddEmployeePage clickAddEmployeeButton() {
        explicitWaitUntilVisible(5, addEmployeeButton);
        click(addEmployeeButton);
        return new AddEmployeePage();
    }

    public void setEmployeeId(String employeeId) {
        explicitWaitUntilVisible(5, employeeIdField);
        set(employeeIdField, employeeId);
    }

    public void clickSearchEmployee() {
        explicitWaitUntilVisible(5, searchButton);
        click(searchButton);
    }

    public EmployeePage clickEditButton(String employeeId) {
        explicitWaitUntilVisible(5, editButton);
        click(editButton);
        return new EmployeePage();
    }
}
