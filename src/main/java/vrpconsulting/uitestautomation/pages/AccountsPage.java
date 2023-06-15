package vrpconsulting.uitestautomation.pages;
import org.openqa.selenium.By;

import static vrpconsulting.uitestautomation.webUI.Action.*;

public class AccountsPage extends CommonPage {

    //private By accountsTitle = By.xpath("//span[@class = 'slds-truncate' and text() = 'Accounts']");
    private By accountsTitle = By.xpath("//one-app-nav-bar-item-root[@data-id = 'Account']");
    private By titleAccounts = By.xpath("//div[@class = 'slds-grid']");
    private By buttonNew = By.xpath("//a[@class = 'forceActionLink' and @title = 'New']");
    private By buttonEdit = By.xpath("//button[@name = 'Edit']");

    public NewAccountPage openAndCreateNewAccount() {
        verifyElementVisibility(accountsTitle, "some error message");
        clickElement(accountsTitle);
        waitForPageLoad();
        verifyElementVisibility(titleAccounts, "some error message");
        clickElement(buttonNew);
        waitForPageLoad();
        return new NewAccountPage();
    }
    public NewAccountPage openEditAccount() {
        waitForPageLoad();
        clickElement(buttonEdit);
        waitForPageLoad();
        return new NewAccountPage();
    }
}
