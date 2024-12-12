package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected WebElement find(By locator) {
        // Protect class, so we can use this on subclasses
        return driver.findElement(locator);
    }

    protected void set(By locator, String value) {
        // Clear the field before we set a value
        find(locator).clear();
        find(locator).sendKeys(value);
    }

    protected void click(By locator) {
        find(locator).click();
    }
}