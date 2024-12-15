package com.demo.orangehrmlive.personal_information_management;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteEmployeeTest extends BaseTest {
    @Test
    public void testDeleteEmployee() {
        String employeeIdToDelete = "Juan101901";
        var pimPage = dashboardPage.goToPersonalInformation();
        pimPage.deleteEmployee(employeeIdToDelete);

        boolean userIdInEmployeeList = pimPage.isUserNameInAdminList(employeeIdToDelete);
        Assert.assertFalse(userIdInEmployeeList, "userIdInEmployeeList: " + userIdInEmployeeList);
        System.out.println("userIdInEmployeeList: " + employeeIdToDelete + "status: " + userIdInEmployeeList);
    }
}