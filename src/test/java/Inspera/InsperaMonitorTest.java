package Inspera;

import PageObjects.MonitorPage;
import Utilities.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InsperaMonitorTest extends Base {

    public WebDriver driver;
    public MonitorPage monitorPage;

    @BeforeTest(alwaysRun = true)
    public void MonitorPageSetup() {
        driver = getDriver();
        monitorPage = new MonitorPage(driver);
    }

    @Test(priority = 1, groups = "validlogin")
    public void monitorNavigation() {
        monitorPage.goToMonitor();

    }

    @Test(priority = 2, groups = "validlogin")
    public void search_test_taker(){
        monitorPage.Search_TT_By_ID("Sept_Prac_Test_BC_12363");

    }
    //@Test(priority = 3, groups = "validlogin")
    public void edit_end_time(){
        monitorPage.setCheckbox1();
        monitorPage.clickEditendtime();

    }
    //@Test(priority = 4, groups = "validlogin")
    public void set_hours_minutes_edit_end_time() throws InterruptedException {
        Thread.sleep(2500);
        monitorPage.setEndinCheckbox();
        monitorPage.setHoursOfEndIn("1");
        monitorPage.setMinutesOfEndIn("30");
        Thread.sleep(1500);
        monitorPage.ApplyEditEndtime();

    }
}
