package vrpconsulting.uitestautomation;
import org.springframework.core.annotation.Order;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test(description = "Test case no. 1")
    @Order
    public void createAccountTest() {
        startFromLoginPage().
                LogInApp();
        getAccountsPage()
                .openAndCreateNewAccount()
                .fillRequiredFieldsAndVerify();
    }

    @Test(description = "Test case no. 2")
    public void updateAccountTest() {
        startFromLoginPage().
                LogInApp();
        getAccountsPage()
                .openAndCreateNewAccount()
                .fillRequiredFieldsAndVerify()
                .openEditAccount()
                .updateFieldsAndVerify();
    }
}
