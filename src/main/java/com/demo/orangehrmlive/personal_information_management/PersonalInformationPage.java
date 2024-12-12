package com.demo.orangehrmlive.personal_information_management;

import com.demo.orangehrmlive.DashboardPage;
import org.openqa.selenium.By;

import static utilities.WaitUtility.explicitWaitUntilVisible;

// Employee List Page
public class PersonalInformationPage extends DashboardPage {
    private By addEmployeeButton = By.xpath("//div[@id='app']//div[@class='orangehrm-header-container']//button[text()=' Add ']");

    public AddEmployeePage clickAddEmployeeButton() {
        explicitWaitUntilVisible(5, addEmployeeButton);
        click(addEmployeeButton);
        return new AddEmployeePage();
    }
}
