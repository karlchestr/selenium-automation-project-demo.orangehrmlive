package utilities;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class Utility {
    public static WebDriver driver;

    public static void setUpUtilityDriver() {
        driver = BasePage.driver;
    }

    // Utility class to assist different class that has the same function
}
