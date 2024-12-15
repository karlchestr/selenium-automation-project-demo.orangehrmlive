package com.demo.orangehrmlive.personal_information_management;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserAdminTest extends BaseTest {
    @Test
    public void testDeleteUserAdmin() {
        var adminPage = dashboardPage.goToAdmin();
        String expectedToDeleteUsername = "test_username";

        adminPage.deleteUserAdmin(expectedToDeleteUsername);
        boolean userNameInAdminList = adminPage.isUserNameInAdminList(expectedToDeleteUsername);

        // Assert false if the deleted username is not existing in the admin list
        Assert.assertFalse(userNameInAdminList, "userNameInAdminList: " + userNameInAdminList);
    }
}
