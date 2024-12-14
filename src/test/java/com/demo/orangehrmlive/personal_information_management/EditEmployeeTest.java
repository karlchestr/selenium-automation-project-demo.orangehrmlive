package com.demo.orangehrmlive.personal_information_management;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.MessageUtility.getAssertionNotEqualsMessage;

public class EditEmployeeTest extends BaseTest {
    @Test
    public void testEditEmployee() throws InterruptedException {
        String firstName = "Shinji";
        String middleName = "II";
        String lastName = "Hirako";
        String employeeId = "Juan101901";
        var editEmployeePage = dashboardPage.goToPersonalInformation();

        editEmployeePage.setEmployeeId(employeeId);
        editEmployeePage.clickSearchEmployee();
        var employeePage = editEmployeePage.clickEditButton(employeeId);

        employeePage.setEditFirstName(firstName);
        employeePage.setEditMiddleName(middleName);
        employeePage.setEditLastName(lastName);
        employeePage.clickSaveButton();

        String actualNewName = employeePage.getExpectedName();
        String expectedNewName = firstName +" "+ lastName;

        Assert.assertEquals(actualNewName, expectedNewName,
                getAssertionNotEqualsMessage(actualNewName, expectedNewName));
    }
}
