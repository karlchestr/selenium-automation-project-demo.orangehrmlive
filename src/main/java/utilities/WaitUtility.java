package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility extends Utility {
    public static void explicitWaitUntilVisible(int seconds, By locator) {
        // WebDriverWait ignores not found exception, until a condition is met
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void explicitWaitUntilTextVisible(int seconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = driver.findElement(locator);
        wait.until(d -> !d.findElement(locator).getText().isEmpty());
    }

    public static void explicitWaitUntilClickable(int seconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
