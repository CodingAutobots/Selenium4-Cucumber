package org.selcu.pageobjects;

import org.selcu.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class LoginPage extends BaseClass {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); ;
    SoftAssert softAssert = new SoftAssert();

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="user-name")
    WebElement usernameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(id="login-button")
    WebElement loginBtn;

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement productPageTitle;



    public void validateTitle(){
        try{
            softAssert.assertEquals(driver.getTitle(),"Swag Labs");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void standardUserLogin(){
        try {
            usernameField.sendKeys(prop.getProperty("username"));
            passwordField.sendKeys(prop.getProperty("password"));
            loginBtn.click();
            wait.until(ExpectedConditions.visibilityOf(productPageTitle));
            softAssert.assertEquals(productPageTitle.getText(), "Products");
            softAssert.assertAll("standardUserLogin");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}
