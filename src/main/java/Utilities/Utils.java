package Utilities;

import PageObjects.SalesForceJobPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utils {

    public static void select_check_box(WebElement e, WebDriver driver, SalesForceJobPageObjects salesforcejob) throws InterruptedException {
        String checkboxname = e.getText();
        String job_count = driver.findElement(By.xpath("//div[@title='" + checkboxname + "']/following-sibling::span")).getText();
        System.out.println(checkboxname + " " + job_count.substring(1, job_count.length() - 1));
        e.click();
        Thread.sleep(3000);
        String[] filtered_value = salesforcejob.getResultValue().getText().split(" ");
        System.out.println(filtered_value[0] + " :Filtered Value");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(2000);

            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }

        List<WebElement> elements = salesforcejob.getJob_code();
        System.out.println(elements.size() + " SIZE");

        for (WebElement k : elements) {
            String[] values = k.getText().split(" | ");
            System.out.println(values[0].trim());
        }

        js.executeScript("window.scrollBy(0,-10000)");

        //unselect checkBOx
        driver.findElement(By.cssSelector(".WI3K.WH3K.WLMF")).click();

    }
}
