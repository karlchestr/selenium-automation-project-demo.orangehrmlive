package com.demo.orangehrmlive.personal_information_management;

import base.BaseTest;
import com.demo.orangehrmlive.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.MessageUtility.getAssertionNotEqualsMessage;

public class AddEmployeeTest extends BaseTest {

    @Test
    public void testAddEmployee() {
        String firstName = "Juan";
        String middleName = "Luna";
        String lastName = "Dela Cruz";
        String id = "Juan101901";
        var addEmployeePage = dashboardPage.goToPersonalInformation().clickAddEmployeeButton();

        // After adding an employee, the page is directed to the employee page.
        var employeePage = addEmployeePage.addEmployee(firstName, middleName, lastName, id);

        String actualName = employeePage.getExpectedName();
        String expectedName = "Juan Dela Cruz";
        System.out.println("Actual Name: " + actualName);
        System.out.println("Expected Name: " + expectedName);

        Assert.assertEquals(actualName, expectedName,
                getAssertionNotEqualsMessage(actualName, expectedName));
    }
}