import DataProviders.NetworkData;
import PageObjects.SalesForceNetworkPage;
import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.Set;



public class JoinOurNetworkTest extends Base {

    WebDriver driver;
    String parent_id;
    String network_page_url;
    SalesForceNetworkPage networkPage;

    @BeforeTest(alwaysRun = true)
    public void setup() {
        driver = initialiseDriver("chrome");
        networkPage = new SalesForceNetworkPage(driver);


    }


    @Test(priority = 1,groups = {"smoke"})
    public void navigateToURL() {
        driver.get("https://www.salesforce.com/company/careers/");
    }

    @Test(priority = 2,groups = {"smoke","sanity"})
    public void navigateToJoinOurNetwork() {
        driver.findElement(By.xpath("//a[contains(@href,'global-careers')]")).click();
        network_page_url = driver.getCurrentUrl();
    }

    @Test(priority = 3,groups = {"smoke"})
    public void test_global_careers_page() {
        Set<String> windows_id = driver.getWindowHandles();

        Iterator<String> it = windows_id.iterator();
        parent_id = it.next();
        String id2 = it.next();

        driver.switchTo().window(id2);
        System.out.println(driver.getCurrentUrl());


    }

    @Test(priority = 4, dataProviderClass = NetworkData.class, dataProvider = "form_data",dependsOnGroups = "smoke")
    public void fill_form(String firstname, String lastname,String email,String city,String country,String linkedin,String title,String company) {
        networkPage.getFirst_name().sendKeys(firstname);
        networkPage.getLast_name().sendKeys(lastname);
        networkPage.getEmail().sendKeys(email);
        networkPage.getCity().sendKeys(city);
        networkPage.getCountry_label().sendKeys(country);
        networkPage.getLinkedin().sendKeys(linkedin);
        networkPage.getTitle().sendKeys(title);
        networkPage.getCompany().sendKeys(company);

        driver.findElement(By.xpath("//div[@id='MyCountryInput_aautocomplete-list']/div[1]")).click();

        WebElement years = driver.findElement(By.id("years"));
        Select select = new Select(years);
        select.selectByValue("10+ years experience");

        WebElement segment = driver.findElement(By.id("segment"));
        Select segment_select = new Select(segment);
        segment_select.selectByValue("Products and Technology");

        driver.findElement(By.id("MrkOptIn")).click();
        driver.findElement(By.id("RmOptIn")).click();
        driver.findElement(By.name("btnSubmit")).click();

        System.out.println(driver.getCurrentUrl());
        String text = driver.findElement(By.xpath("//h1[@style='text-align: center;']")).getText();
        System.out.println(text);

        driver.navigate().back();
    }

    @AfterTest(alwaysRun = true)
    public void exit(){
        driver.quit();
    }


}
