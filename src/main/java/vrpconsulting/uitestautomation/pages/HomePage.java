package vrpconsulting.uitestautomation.pages;

import org.openqa.selenium.By;
import static vrpconsulting.uitestautomation.webUI.Action.*;

public class HomePage extends CommonPage{

    private By titleHome = By.xpath("//a[@title='Home']");
    private By reportsEclairChart = By.xpath("//*[@id='brandBand_2']//div[@class = 'eclair-component-chart']");

    public void openHomePage(){
        openURL("homePageURL open application if user have already logged in");
        waitForPageLoad();
        waitForElementVisibility(titleHome);
        verifyElementVisibility(reportsEclairChart, "some error message");
    }
}
