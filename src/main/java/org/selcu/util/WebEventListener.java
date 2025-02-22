package org.selcu.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selcu.base.BaseClass;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;
import java.util.List;

public class WebEventListener extends BaseClass implements WebDriverListener {

    public WebEventListener(WebDriver driver) {
        this.driver = driver;
    }

    public void afterMaximize(WebDriver.Window window) {
        System.out.println("Maximized browser window");
    }
    public void afterGet(WebDriver driver, String url) {
        System.out.println("Fetched URL: "+url);
    }

    public void afterGetTitle(WebDriver driver, String result) {
        System.out.println("Retrieved title from the webpage: "+result);
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("Found element with locator: "+locator.toString());
    }
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        System.out.println("Found list of elements with locator: "+locator.toString());
    }

    public void afterClick(WebElement element) {
        System.out.println("Clicked on element: "+element.toString());
    }

    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("After Sending Keys"+ Arrays.toString(keysToSend) +" on element: "+element.toString());
    }

    public void afterClose(WebDriver driver) {
        System.out.println("Browser closed successfully!!");
    }

    public void afterQuit(WebDriver driver) {
        System.out.println("Browser quit successful!!");
    }


}
