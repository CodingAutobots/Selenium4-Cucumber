package tests;

import org.selcu.base.BaseClass;
import org.selcu.pageobjects.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp(){
        initializeBrowser();
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void validateTitle(){
        softAssert.assertEquals(loginPage.validateTitle(),"Swag Labs");
    }

    @Test(priority = 2)
    public void validateLogin(){
        softAssert.assertEquals(loginPage.standardUserLogin(), "Products");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tear(){
        tearDown();
    }
}
