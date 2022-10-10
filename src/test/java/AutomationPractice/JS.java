package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JS extends Base {

    @Test
    public void test1(){
        driver=initialiseDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        //Window scrolling by JavaScript Executor
        //js.executeScript("window.scrollBy(0,500)");

        js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.id("mousehover")));

        ///Window scrolling by JavaScript Executor inside webtable
       //js.executeScript("document.querySelector('tableFixHead').scrollBy(0,100)");
        //js.executeScript("document.querySelector('.tableFixHead').scrollTop=100");



        //send keys using JS executor
        //js.executeScript("arguments[0].value='sachin'",driver.findElement(By.name("enter-name")));

        //click on alert button
        //js.executeScript("arguments[0].click()",driver.findElement(By.id("alertbtn")));
        //driver.switchTo().alert().accept();

        //Enable checkbox
       // js.executeScript("arguments[0].click()",driver.findElement(By.id("checkBoxOption2")));

        //Display own alert
        //js.executeScript("window.alert('Hello world')");



    }
}
