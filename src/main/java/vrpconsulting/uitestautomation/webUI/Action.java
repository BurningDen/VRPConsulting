package vrpconsulting.uitestautomation.webUI;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import vrpconsulting.uitestautomation.factories.DriverFactory;

import java.time.Duration;

public class Action {
    //better to place all this values in properties
    private static final long WAIT_PAGE_LOADED = 30;
    private static final long WAIT_EXPLICIT = 10;

    public static void openURL(String url){
        DriverFactory.getWebBrowserDriver().get(url);
    }


    public static void inputText(By by, String value) {
        waitForElementVisibility(by).sendKeys(value);
    }
    public static void clickElement(By by) {
        waitForElementVisibility(by).click();
    }
    public static void waitForPageLoad() {
        //sleep(1);
        WebDriverWait wait = new WebDriverWait(DriverFactory.getWebBrowserDriver(), Duration.ofSeconds(WAIT_PAGE_LOADED));
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebBrowserDriver();
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");
        if (!jsReady) {
                wait.until(jsLoad);
            }
    }
    public static Boolean verifyElementVisibility(By by, String message) {
        try {
            new WebDriverWait(DriverFactory.getWebBrowserDriver(), Duration.ofSeconds(WAIT_EXPLICIT))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            if (message.isEmpty()) {
                Assert.fail("The element is NOT visible. " + by);
            } else {
                Assert.fail(message + by);
            }
            return false;
        }
    }
    public static WebElement waitForElementVisibility(By by) {
        //without try catch exception handling
        WebDriverWait wait = new WebDriverWait(DriverFactory.getWebBrowserDriver(), Duration.ofSeconds(WAIT_EXPLICIT));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            //scroll to bottom method if needed
    }

    public static void sleep(double millis) {
        try {
            Thread.sleep((long) (millis));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
