package vrpconsulting.uitestautomation;
import org.testng.annotations.Test;
import vrpconsulting.uitestautomation.factories.DriverFactory;

public class LoginTest extends BaseTest {


    @Test()
    public void login() {
        startAppFromLoginPage()
                .LogInApp()
;
    }
}
