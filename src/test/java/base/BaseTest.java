package base;

import com.demo.orangehrmlive.DashboardPage;
import com.demo.orangehrmlive.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utilities.Utility.setUpUtilityDriver;

public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    private final String orangeHrmURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private final String usernameCredentials = "Admin";
    private final String passwordCredentials = "admin123";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(orangeHrmURL);

        // Create an instance of Base Page
        basePage = new BasePage();
        basePage.setDriver(driver);

        // Set up the utility after setting the basepage driver
        setUpUtilityDriver();

        // Set the page on homepage
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        dashboardPage = loginPage.loginToApplication(usernameCredentials, passwordCredentials);
    }

    @AfterMethod
    public void takeFailedResultScreenshot(ITestResult testResult) {
        // Interface to use Failure Result and get status method
        // Get the status of method
        if (ITestResult.FAILURE == testResult.getStatus()) {
            // Since TakesScreenshot is an interface, we need to typecast the function
            // and create an object reference
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Performs the screenshot and store it as file
            File source = screenshot.getScreenshotAs(OutputType.FILE);

            // Define a formatter for a valid file name
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

            // Format the current date and time
            String formattedDateTime = LocalDateTime.now().format(formatter);

            // Include the date before the file name, method name, and file type
            File destination = new File(System.getProperty("user.dir")
                    + "/resources/screenshots/("
                    + formattedDateTime + ")"
                    + testResult.getName()
                    + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot located at: " + destination);
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
}
