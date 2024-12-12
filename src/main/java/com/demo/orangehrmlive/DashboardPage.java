package com.demo.orangehrmlive;

import base.BasePage;
import org.openqa.selenium.By;

import static utilities.GetUtility.getText;
import static utilities.WaitUtility.explicitWaitUntilVisible;

public class DashboardPage extends BasePage {
    private By dashBoardHeader = By.xpath("//div[@id='app']//h6[text()='Dashboard']");

    public String getDashboardHeader() {
        explicitWaitUntilVisible(5, dashBoardHeader);
        return getText(dashBoardHeader);
    }
}
