package com.demo.orangehrmlive;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogoutButton() {
        dashboardPage.clickUserDropDown();

        var logoutPage = dashboardPage.clickLogoutButton();
        String actualUrl = logoutPage.getCurrentUrl();
        String expectedUrl = orangeHrmURL;

        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
