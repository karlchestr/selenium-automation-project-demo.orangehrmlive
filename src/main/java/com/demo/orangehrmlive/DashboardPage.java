package com.demo.orangehrmlive;

import base.BasePage;
import com.demo.orangehrmlive.personal_information_management.PersonalInformationPage;
import org.openqa.selenium.By;

import static utilities.GetUtility.getText;
import static utilities.WaitUtility.explicitWaitUntilVisible;

public class DashboardPage extends BasePage {
    private By dashBoardHeader = By.xpath("//div[@id='app']//h6[text()='Dashboard']");
    private By pimItem = By.xpath("//div[@id='app']//span[text()='PIM']");

    public String getDashboardHeader() {
        explicitWaitUntilVisible(5, dashBoardHeader);
        return getText(dashBoardHeader);
    }

    public PersonalInformationPage goToPersonalInformation() {
        explicitWaitUntilVisible(5, pimItem);
        click(pimItem);
        return new PersonalInformationPage();
    }


}
