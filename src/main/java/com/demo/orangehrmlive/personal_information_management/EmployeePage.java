package com.demo.orangehrmlive.personal_information_management;

import org.openqa.selenium.By;

import static utilities.ClearTextUtility.clearTextUsingSendKeys;
import static utilities.GetUtility.getText;
import static utilities.JavaScriptUtility.sendKeysJS;
import static utilities.WaitUtility.*;

public class EmployeePage extends AddEmployeePage {
    private By nameHeader = By.xpath("//div[@id='app']//h6[@class='oxd-text oxd-text--h6 --strong']");
    private By editFirstName = By.name("firstName");
    private By editMiddleName = By.name("middleName");
    private By editLastName = By.name("lastName");
    private By saveButton = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit']");

    public String getExpectedName() {
        explicitWaitUntilVisible(10, nameHeader);
        explicitWaitUntilTextVisible(10, nameHeader);
        return getText(nameHeader);
    }

    public void setEditFirstName(String firstName) {
        explicitWaitUntilVisible(5, editFirstName);
        click(editFirstName);
        clearTextUsingSendKeys(find(editFirstName));
        set(editFirstName, firstName);
    }

    public void setEditMiddleName(String middleName) {
        explicitWaitUntilVisible(5, editMiddleName);
        clearTextUsingSendKeys(find(editMiddleName));
        set(editMiddleName, middleName);
    }

    public void setEditLastName(String lastName) {
        explicitWaitUntilVisible(5, editLastName);
        clearTextUsingSendKeys(find(editLastName));
        set(editLastName, lastName);
    }

    public void clickSaveButton() {
        click(saveButton);
        refresh();
    }
}
