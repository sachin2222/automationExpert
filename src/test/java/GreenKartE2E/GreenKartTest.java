package GreenKartE2E;

import DataProviders.GreenKartDataProvider;
import Utilities.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GreenKartTest extends Base {
    WebDriver driver;
    int allprice;

    @BeforeSuite
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @Test(dataProvider = "veggiesData", dataProviderClass = GreenKartDataProvider.class, priority = 1)
    public void addtoCart(String veggieName, String quantity) throws IOException {

        List<WebElement> vegetables = driver.findElements(By.cssSelector(".product-name"));
        for (int i = 0; i < vegetables.size(); i++) {

            if (vegetables.get(i).getText().contains(veggieName)) {
                File source = vegetables.get(i).findElement(By.xpath(".//preceding-sibling::div")).getScreenshotAs(OutputType.FILE);
                String dest = System.getProperty("user.dir") + "\\Screenshots\\" + veggieName + ".png";
                FileHandler.copy(source, new File(dest));

                int j = 1;
                while (j < Integer.parseInt(quantity)) {
                    vegetables.get(i).findElement(By.xpath(".//parent::div/div[2]/a[2]")).click();
                    j++;
                }
                vegetables.get(i).findElement(By.xpath(".//parent::div/div[3]/button")).click();
            }

        }


    }

    @Test(priority = 2)
    public void checkout() {
        driver.findElement(By.cssSelector(".cart-icon img")).click();
        driver.findElement(By.xpath("//div[@class='action-block']/button[1]")).click();

    }

    @Test(priority = 3)
    public void addPromoCode() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("SACHIN500");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        Thread.sleep(2500);
    }

    @Test(priority = 4)
    public void placeOrder() {
        driver.findElement(By.xpath("//div[@class='promoWrapper']/following-sibling::button")).click();

    }

    @Test(priority = 5)
    public void selectCountry() throws InterruptedException {
        WebElement selectCountry = driver.findElement(By.tagName("select"));
        Select select = new Select(selectCountry);
        select.selectByVisibleText("Algeria");

    }

    @Test(priority = 6)
    public void Proceed() throws InterruptedException {
        driver.findElement(By.cssSelector(".chkAgree")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//div[@class='wrapperTwo']/button")).click();

    }

}
