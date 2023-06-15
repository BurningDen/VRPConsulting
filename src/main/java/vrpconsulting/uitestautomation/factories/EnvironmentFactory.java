package vrpconsulting.uitestautomation.factories;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import vrpconsulting.uitestautomation.constants.Constants;

import java.net.MalformedURLException;
import java.net.URL;

public class EnvironmentFactory {
    public WebDriver createInstance() {
        //value from properties here in real testframework
        var environment = Constants.ENVIRONMENT.toUpperCase();
        WebDriver webdriver = null;

        switch (environment) {
            case "LOCAL":
                webdriver = BrowserFactory.valueOf(Constants.BROWSER.toUpperCase()).createDriver();
                break;
            case "REMOTE":
                //Example for remote start on Cloud
                //webdriver = some logic for creation of remote environment for testing
                break;
            default:
                throw new IllegalStateException("....some test framework problems");
        }
        return webdriver;
    }

    public AndroidDriver createAndroidInstance() {
        AndroidDriver androidDriver;
        //set required configurations for DesiredCapabilities and etc
        DesiredCapabilities capabilities = new DesiredCapabilities();
        URL appiumServerUrl = null;
        try {
            appiumServerUrl = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        androidDriver = new AndroidDriver(appiumServerUrl, capabilities);
        return androidDriver;
    }
}
