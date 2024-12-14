package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ClearTextUtility extends Utility {
    public static void clearTextUsingSendKeys(WebElement element) {
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

}
