package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility extends Utility {
    public static void scrollToElementJS(By locator) {
        // Find the element
        WebElement element = driver.findElement(locator);

        // Set the driver to execute a js script to scroll to an element
        String jsScript = "arguments[0].scrollIntoView()";
        ((JavascriptExecutor)driver).executeScript(jsScript, element);
    }

    public static void clickJs(By locator) {
        WebElement element = driver.findElement(locator);

        // Another way to use javascript executor
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void sendKeysJS(String key, By locator) {
        WebElement element = driver.findElement(locator);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('value', '" + key +"')", element);
    }
}
