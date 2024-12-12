package com.demo.orangehrmlive.personal_information_management;

import org.openqa.selenium.By;

import static utilities.GetUtility.getText;
import static utilities.WaitUtility.explicitWaitUntilTextVisible;
import static utilities.WaitUtility.explicitWaitUntilVisible;

public class EmployeePage extends AddEmployeePage {
    private By nameHeader = By.xpath("//div[@id='app']//h6[@class='oxd-text oxd-text--h6 --strong']");

    public String getExpectedName() {
        explicitWaitUntilVisible(10, nameHeader);
        explicitWaitUntilTextVisible(10, nameHeader);
        return getText(nameHeader);
    }

}
