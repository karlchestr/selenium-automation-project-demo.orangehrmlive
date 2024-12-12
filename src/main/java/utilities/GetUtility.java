package utilities;

import org.openqa.selenium.By;

public class GetUtility extends Utility {
    public static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public static String getUrl() {
        return driver.getCurrentUrl();
    }

    public static String getAttribute(By locator, String attribute) {
        return driver.findElement(locator).getAttribute(attribute);
    }
}
