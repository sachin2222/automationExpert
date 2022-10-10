package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUpload extends Base {
    WebDriver driver;
    @BeforeTest(alwaysRun = true)
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/upload");

    }
    //File Upload by send keys
    @Test
    public void test1() throws AWTException, InterruptedException {
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\sachi\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver.findElement(By.id("file-submit")).click();


    }
}
