package com.demo.orangehrmlive;

import base.BasePage;
import com.demo.orangehrmlive.personal_information_management.AdminPage;
import com.demo.orangehrmlive.personal_information_management.PersonalInformationPage;
import org.openqa.selenium.By;

import static utilities.GetUtility.getText;
import static utilities.WaitUtility.explicitWaitUntilVisible;

public class DashboardPage extends BasePage {
    private By dashBoardHeader = By.xpath("//div[@id='app']//h6[text()='Dashboard']");
    private By pimItem = By.xpath("//div[@id='app']//span[text()='PIM']");
    private By userDropdown = By.xpath("//div[@id='app']//span[@class='oxd-userdropdown-tab']");
    private By logoutButton = By.xpath("//div[@id='app']//ul[@class='oxd-dropdown-menu']//a[text()='Logout']");
    private By adminItem = By.xpath("//div[@id='app']//span[text()='Admin']");

    public String getDashboardHeader() {
        explicitWaitUntilVisible(5, dashBoardHeader);
        return getText(dashBoardHeader);
    }

    public PersonalInformationPage goToPersonalInformation() {
        explicitWaitUntilVisible(5, pimItem);
        click(pimItem);
        return new PersonalInformationPage();
    }

    public void clickUserDropDown() {
        explicitWaitUntilVisible(3,userDropdown);
        click(userDropdown);
    }

    public LoginPage clickLogoutButton() {
        explicitWaitUntilVisible(3, logoutButton);
        click(logoutButton);
        return new LoginPage();
    }

    public AdminPage goToAdmin() {
        explicitWaitUntilVisible(3, adminItem);
        click(adminItem);
        return new AdminPage();
    }
}
