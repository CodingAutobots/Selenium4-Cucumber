import org.selcu.base.BaseClass;
import org.selcu.pageobjects.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        initializeBrowser();
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void validateTitle(){
        loginPage.validateTitle();
    }

    @Test(priority = 2)
    public void validateLogin(){
        loginPage.standardUserLogin();
    }

    @AfterMethod
    public void tear(){
        tearDown();
    }


}
