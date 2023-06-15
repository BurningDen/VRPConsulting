package vrpconsulting.uitestautomation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import vrpconsulting.uitestautomation.factories.DriverFactory;
import vrpconsulting.uitestautomation.pages.CommonPage;
import vrpconsulting.uitestautomation.pages.LoginPage;


public class BaseTest extends CommonPage {

    @BeforeMethod(alwaysRun = true)
    public void createDriver() {
        WebDriver driver = DriverFactory.getWebBrowserDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        DriverFactory.quit();
    }
}
