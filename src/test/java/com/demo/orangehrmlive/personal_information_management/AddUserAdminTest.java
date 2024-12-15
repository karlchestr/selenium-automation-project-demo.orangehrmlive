package com.demo.orangehrmlive.personal_information_management;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.MessageUtility.getAssertionNotEqualsMessage;

public class AddUserAdminTest extends BaseTest {
    @Test
    public void testAddUserAsAdmin() throws InterruptedException {
        var addAdminPage = dashboardPage.goToAdmin().clickAddAdmin();
        String expectedUsername = "test_username";
        String actualUserName = "";

        addAdminPage.selectUserRole("Admin");
        addAdminPage.selectStatus("Enabled");
        addAdminPage.setEmployeeNameField("Juan Luna Dela Cruz");
        addAdminPage.setUsernameField(expectedUsername);
        addAdminPage.setPasswordField("password-2022K");
        addAdminPage.setConfirmPasswordField("password-2022K");

        var adminPage = addAdminPage.clickSaveButton(); // Goes back to admin page after successfully saving
        actualUserName = adminPage.getUsernameInAdminList(expectedUsername);

        Assert.assertEquals(actualUserName, expectedUsername,
                getAssertionNotEqualsMessage(actualUserName, expectedUsername));

    }
}
