package vrpconsulting.uitestautomation.pages;

import org.openqa.selenium.By;

import static vrpconsulting.uitestautomation.constants.Constants.*;
import static vrpconsulting.uitestautomation.webUI.Action.*;
public class LoginPage extends CommonPage{

    private By appLogo = By.xpath("//img[@id='logo']");
    private By userName = By.xpath("//input[@id='username']");
    private By password = By.xpath("//input[@id='password']");
    private By logInButton = By.xpath("//input[@id='Login']");

    public void openLoginPage(){
        openURL(URL);
        waitForPageLoad();
        verifyElementVisibility(appLogo, "error message");
    }
    public void LogInApp(){
        openLoginPage();
        inputText(userName, USER);
        inputText(password, PASSWORD);
        clickElement(logInButton);
        waitForPageLoad();
        waitForElementVisibility(navigationPanel);
        verifyElementVisibility(contextBarPanel, "error message");
    }

    //it is simple realization of setText not universal methods without explicit waiters for elements
    //    public void setLogin(String user) {
    //        DriverFactory.getWebBrowserDriver().findElement(user).sendKeys(user.getLogin());
    //

}
