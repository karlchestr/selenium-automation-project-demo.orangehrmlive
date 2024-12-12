package com.demo.orangehrmlive;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static utilities.MessageUtility.getAssertionNotEqualsMessage;
import static utilities.Utility.setUpUtilityDriver;

public class LoginTest {
    private WebDriver driver;
    private BasePage basePage;
    private LoginPage loginPage;
    private String loginURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(loginURL);

        // Create an instance of Base Page
        basePage = new BasePage();
        basePage.setDriver(driver);

        // Set up the utility after setting the basepage driver
        setUpUtilityDriver();

        loginPage = new LoginPage();
    }

    @Test
    // Separate class for just testing the login function
    public void testLoginFunction() {
        var loginPageSite = loginPage.loginToApplication("Admin", "admin123");
        String actualHeaderText = loginPageSite.getDashboardHeader();
        String expectedHeaderText = "Dashboard";

        Assert.assertEquals(actualHeaderText, expectedHeaderText,
                getAssertionNotEqualsMessage(actualHeaderText, expectedHeaderText));
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
}