import PageObjects.SalesForceCarrierObjects;
import PageObjects.SalesForceJobPageObjects;
import Utilities.Base;
import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SalesForceCarriersTest extends Base {

    WebDriver driver;
    SalesForceCarrierObjects salesforce;
    SalesForceJobPageObjects salesforcejob;

    @BeforeTest(alwaysRun = true)
    public void Launch_Driver() {
        driver = initialiseDriver("chrome");
        salesforce = new SalesForceCarrierObjects(driver);


    }

    @Test(priority = 2 ,groups = {"smoke"})
    public void NavigateURL() {
        driver.get("https://www.salesforce.com/company/careers/");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.salesforce.com/company/careers/");
    }

    @Test(priority = 3 ,groups = {"smoke"})
    public void SearchJobs() {
        salesforce.get_element_searchJob().click();

    }

    @Test(priority = 4)
    public void navigate_to_search_job_window() {
        String parent = driver.getWindowHandle();
        Set<String> windows_id = driver.getWindowHandles();
        System.out.println(windows_id.size());


        Iterator it = windows_id.iterator();
        String id1 = (String) it.next();
        String id2 = (String) it.next();

        driver.switchTo().window(id2);
        System.out.println(driver.getCurrentUrl());

    }

    @Test(priority = 5)
    public void fill_job_form() throws InterruptedException {
        salesforcejob = new SalesForceJobPageObjects(driver);
        salesforcejob.getSearch().sendKeys("TEST ENGINEER");
        salesforcejob.getSearchButton().click();

        Thread.sleep(3000);
        List<WebElement> checkboxList = salesforcejob.getCheckbox_list();
        System.out.println(checkboxList.size() + " :Total Number of check Boxes");

        for (WebElement e : checkboxList) {
            Utils.select_check_box(e,driver,salesforcejob);
        }

    }


    @AfterTest(alwaysRun = true)
    public void exit(){
        driver.quit();
    }


}
