package org.selcu.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.selcu.util.WebEventListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    WebDriverListener listener;
    public Properties prop;
    public BaseClass(){
        try{
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/org/selcu/config/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initializeBrowser(){
        try {
            String browserName = prop.getProperty("browser");
            if(browserName.equals("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("--incognito");
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            } else if(browserName.equals("firefox")){
                driver = new FirefoxDriver();
            }
            listener= new WebEventListener(driver);
            driver = new EventFiringDecorator<>(listener).decorate(driver);
            driver.get(prop.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("IMPLICIT_WAIT"))));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(prop.getProperty("PAGE_LOAD_TIMEOUT"))));
        } catch(Exception e){
            throw new RuntimeException(e);
        }

    }

    public void tearDown(){
        try {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        } catch (Exception e){
            System.out.println("Failed to close browser session");
        }
    }
}
