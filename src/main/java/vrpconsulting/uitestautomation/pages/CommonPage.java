package vrpconsulting.uitestautomation.pages;

import org.openqa.selenium.By;

public class CommonPage {

    //possible to use PageFactory but for test task was created simple way

    protected By navigationPanel = By.xpath("//span[@role='navigation' and @aria-label='Global Header']");
    protected By contextBarPanel = By.xpath("//div[@class = 'slds-context-bar']");
    private LoginPage loginPage;
    private HomePage homePage;
    private AccountsPage accountsPage;
    private NewAccountPage newAccountPage;

    protected LoginPage startFromLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    protected HomePage startFromHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    protected AccountsPage getAccountsPage() {
        if (accountsPage == null) {
            accountsPage = new AccountsPage();
        }
        return accountsPage;
    }
}
