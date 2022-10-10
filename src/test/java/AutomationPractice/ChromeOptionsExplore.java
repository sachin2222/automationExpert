package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeOptionsExplore {

    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sachi\\IdeaProjects\\untitled1\\Drivers\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");;
       // options.setAcceptInsecureCerts(true);
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
    }
}
