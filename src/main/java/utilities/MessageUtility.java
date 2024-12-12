package utilities;

public class MessageUtility extends Utility {
    public static String getAssertionNotEqualsMessage(String actual, String expected) {
        return String.format("Assertion failed: Expected value '%s' does not match actual value '%s'.", expected, actual);
    }
}
