import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.selcu.Main;

public class TestClass {
    WebDriver driver;
    public static void main(String[] args) {
        TestClass mn = new TestClass();
        mn.initializeBrowser();
        mn.tearDown();

    }
    public void initializeBrowser(){
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            driver.get("https://in.webuy.com/");
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
