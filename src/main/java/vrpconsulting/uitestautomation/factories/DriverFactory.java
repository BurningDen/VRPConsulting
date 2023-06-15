package vrpconsulting.uitestautomation.driverInitialization;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class Driver {

    //in case if our application will test on another platforms (android for example)
    private static final ThreadLocal<AndroidDriver> ANDROID_DRIVER = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> CHROME_DRIVER = new ThreadLocal<>();

    //singleton
    public static WebDriver getWebBrowserDriver() {
        if (Objects.isNull(CHROME_DRIVER.get())) {
            CHROME_DRIVER.set(new EnvironmentFactory().createInstance());
        }
        return CHROME_DRIVER.get();
    }

    public static AndroidDriver getAndroidDriver() {
        if (Objects.isNull(ANDROID_DRIVER.get())) {
            ANDROID_DRIVER.set(new EnvironmentFactory().createAndroidInstance());
        }
        return ANDROID_DRIVER.get();
    }

    public static void quit() {
        if (getWebBrowserDriver() != null) getWebBrowserDriver().quit();
    }
}
