import org.selcu.base.BaseClass;
import org.selcu.pageobjects.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;

    @Test
    public void validateLogin(){
        initializeBrowser();
        loginPage = new LoginPage(driver);
        loginPage.standardUserLogin();
        tearDown();
    }







}
