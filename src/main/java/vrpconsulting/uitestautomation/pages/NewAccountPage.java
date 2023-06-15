package vrpconsulting.uitestautomation.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static vrpconsulting.uitestautomation.webUI.Action.*;

public class NewAccountPage extends CommonPage {

    private By titleNewAccount = By.xpath("//h2[text()='New Account']");
    private By inputAccountName = By.xpath("//ancestor::div[@class = 'actionBody']/descendant::input[2]");
    private By inputPhone = By.xpath("//ancestor::div[@class = 'actionBody']/descendant::input[1]");
    private By inputFax = By.xpath("//ancestor::div[@class = 'actionBody']/descendant::input[3]");
    private By inputWebSite = By.xpath("//ancestor::div[@class = 'actionBody']/descendant::input[5]");
    private By buttonSave = By.xpath("//button[@name='SaveEdit' or @title='Save']");
    private By alertDialog = By.xpath("//div[@role='alertdialog']");

    //possible to fill fields from Parameters, jsonData, DateProvider and etc
    public AccountsPage fillRequiredFieldsAndVerify() {
        //all string to parameters
        var accountName = "TestAccountName" + RandomStringUtils.randomNumeric(3);
        var phoneNumber = "+45" + RandomStringUtils.randomNumeric(9);
        var fax = "TestFax" + RandomStringUtils.randomNumeric(3);
        var webSite = "TestWebSite" + RandomStringUtils.randomAlphabetic(3);

        inputText(inputAccountName, accountName);
        inputText(inputPhone, phoneNumber);
        inputText(inputFax, fax);
        inputText(inputWebSite, webSite);
        //Assertion if needed
        waitForElementVisibility(buttonSave).click();
        waitForPageLoad();
        waitForElementVisibility(alertDialog).isDisplayed();
        verifyElementVisibility(By.xpath(String.format("//h1//*[text()='%s']", accountName)), "some message exception");
        return new AccountsPage();
    }

    public AccountsPage updateFieldsAndVerify() {
        //all string to parameters
        var accountName = "TestAccountName" + RandomStringUtils.randomNumeric(3);

        waitForElementVisibility(inputAccountName).clear();
        inputText(inputAccountName, accountName);
        //Assertion if needed
        waitForElementVisibility(buttonSave).click();
        waitForPageLoad();
        waitForElementVisibility(alertDialog).isDisplayed();
        verifyElementVisibility(By.xpath(String.format("//h1//*[text()='%s']", accountName)), "some message exception");
        return new AccountsPage();
    }
}
