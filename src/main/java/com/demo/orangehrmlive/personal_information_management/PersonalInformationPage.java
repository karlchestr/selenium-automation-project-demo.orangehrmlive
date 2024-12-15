package com.demo.orangehrmlive.personal_information_management;

import com.demo.orangehrmlive.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.WaitUtility.explicitWaitUntilVisible;

// Employee List Page
public class PersonalInformationPage extends DashboardPage {
    private By addEmployeeButton = By.xpath("//div[@id='app']//div[@class='orangehrm-header-container']//button[text()=' Add ']");
    private By employeeIdField = By.xpath("//div[@id='app']//div[@class='oxd-table-filter-area']//input[@class='oxd-input oxd-input--active']");
    private By searchButton = By.xpath("//div[@id='app']//button[text()=' Search '][1]");
    private By editButton = By.xpath("//div[@id='app']//button[@class='oxd-icon-button oxd-table-cell-action-space'][1]");
    private By deleteButton = By.xpath("//div[@id='app']//button[@class='oxd-icon-button oxd-table-cell-action-space'][2]");
    private By deleteAdminModal = By.xpath("//div[@role='document']");
    private By confirmDeleteButtonModal = By.xpath("//div[@role='document']//button[text()=' Yes, Delete ']");
    private By employeeListTable = By.xpath("//div[@class='orangehrm-container']//div[@role='table']");
    private By employeeIdInList;

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

    public void clickDeleteEmployeeButton(String employeeId) {
        setEmployeeId(employeeId);
        clickSearchEmployee();

        explicitWaitUntilVisible(5, deleteButton);
        click(deleteButton);
    }

    private void clickConfirmDeleteInModal() {
        explicitWaitUntilVisible(5, deleteAdminModal);
        explicitWaitUntilVisible(5,confirmDeleteButtonModal);
        click(confirmDeleteButtonModal);
    }


    public void deleteEmployee(String employeeId) {
        clickDeleteEmployeeButton(employeeId);
        clickConfirmDeleteInModal();
        refresh();
    }

    public boolean isUserNameInAdminList(String employeeId) {
        employeeIdInList = By.xpath("//div[@class='orangehrm-paper-container']//div[text()='"+ employeeId +"']");

        explicitWaitUntilVisible(10, employeeListTable); // Wait for the table to load
        List<WebElement> elementList = driver.findElements(employeeIdInList);
        return !elementList.isEmpty(); // Return false if not existing
    }
}
