package org.selcu.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.selcu.util.WebEventListener;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    WebDriverListener listener;

    public void initializeBrowser(){
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            listener= new WebEventListener(driver);
            driver = new EventFiringDecorator<>(listener).decorate(driver);
            driver.get("https://www.saucedemo.com");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("Page Title: " + driver.getTitle());
        } catch(Exception e){
            System.out.println("Browser not invoked");
        }

    }

    public void tearDown(){
        try {
            driver.close();
        } catch (Exception e){
            System.out.println("Failed to close browser session");
        }
    }
}
