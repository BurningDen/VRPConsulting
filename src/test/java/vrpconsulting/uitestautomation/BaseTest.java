package org.vrpconsulting.testautomation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.vrpconsulting.testautomation.driverInitialization.DriverBuilder;


public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void createDriver() {
        WebDriver driver = DriverBuilder.getWebBrowserDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        DriverBuilder.quit();
    }
}
