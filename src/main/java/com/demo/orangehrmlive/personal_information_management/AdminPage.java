package com.demo.orangehrmlive.personal_information_management;

import com.demo.orangehrmlive.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.explicitWaitUntilVisible;
import static utilities.GetUtility.getText;

public class AdminPage extends DashboardPage {
    private By addButton = By.xpath("//div[@id='app']//div[@class='orangehrm-header-container']//button[text()=' Add ']");
    private By usernameInList;
    private By deleteAdminButton;
    private By adminListTable = By.xpath("//div[@class='orangehrm-container']//div[@role='table']");
    private By deleteAdminModal = By.xpath("//div[@role='document']");
    private By confirmDeleteButtonModal = By.xpath("//div[@role='document']//button[text()=' Yes, Delete ']");

    public AddAdminPage clickAddAdmin() {
        explicitWaitUntilVisible(3,addButton);
        click(addButton);
        return new AddAdminPage();
    }

    public String getUsernameInAdminList(String username) {
        usernameInList = By.xpath("//div[@class='orangehrm-paper-container']//div[text()='"+username+"']");

        explicitWaitUntilVisible(10, adminListTable); // Wait for the table to load
        explicitWaitUntilVisible(5, usernameInList); // Wait for the target cell to load
        scrollToElementJS(usernameInList);
        return getText(usernameInList);
    }

    private void clickDeleteButton(String username) {
        deleteAdminButton = By.xpath("//div[@role='row' and .//div[text()='"+ username +"']]//button[i[contains(@class, 'bi-trash')]]");

        explicitWaitUntilVisible(5, adminListTable);
        explicitWaitUntilVisible(5, deleteAdminButton);
        scrollToElementJS(deleteAdminButton);
        click(deleteAdminButton);
    }

    private void clickConfirmDeleteInModal() {
        explicitWaitUntilVisible(5, deleteAdminModal);
        explicitWaitUntilVisible(5,confirmDeleteButtonModal);
        click(confirmDeleteButtonModal);
    }

    public void deleteUserAdmin(String username){
        clickDeleteButton(username);
        clickConfirmDeleteInModal();
        refresh();
    }

    public boolean isUserNameInAdminList(String username) {
        usernameInList = By.xpath("//div[@class='orangehrm-paper-container']//div[text()='"+username+"']");

        explicitWaitUntilVisible(10, adminListTable); // Wait for the table to load
        List<WebElement> elementList = driver.findElements(usernameInList);
        return !elementList.isEmpty(); // Return false if not existing
    }
}
