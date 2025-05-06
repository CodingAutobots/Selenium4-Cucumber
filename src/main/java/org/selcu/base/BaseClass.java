package org.selcu.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.selcu.util.WebEventListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
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
            ChromeOptions chromeOptions = new ChromeOptions();
            String hubURL = "http://localhost:4444/";
            String browserName = prop.getProperty("browser");
            String executionType = prop.getProperty("mode");
            if(browserName.equals("chrome") && executionType.equals("local")) {
                ///ChromeOptions options = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("--incognito");
                //chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
            } else if(browserName.equals("firefox") && executionType.equals("local")){
                driver = new FirefoxDriver();
            }
            else if(executionType.equals("remote")){
                if(browserName.equals("chrome")){
                    chromeOptions.addArguments("start-maximized");
                    chromeOptions.addArguments("--incognito");
                    driver = new RemoteWebDriver(new URL(hubURL),chromeOptions);
                } else if (browserName.equals("firefox")){
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("-headless");
                    driver = new RemoteWebDriver(new URL(hubURL),firefoxOptions);
                }

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
