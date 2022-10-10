package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;

    public static WebDriver initialiseDriver(String browser){
        if(browser.contains("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\sachi\\IdeaProjects\\untitled1\\Drivers\\chromedriver.exe");
            ChromeOptions options=new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            driver=new ChromeDriver(options);


        }
        if(browser.contains("firefox")){
            System.setProperty("webdriver.gecko.driver","C:\\Users\\sachi\\IdeaProjects\\untitled1\\Drivers\\geckodriver.exe");
            FirefoxOptions options=new FirefoxOptions();
            options.addArguments("start-maximized");
            driver=new FirefoxDriver(options);

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static String takeScreenShot(String testcasename, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "\\Screenshots\\" + testcasename + ".png";
        FileHandler.copy(source, new File(dest));
        return dest;

    }
}
