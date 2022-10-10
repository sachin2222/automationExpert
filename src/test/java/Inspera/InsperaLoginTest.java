package Inspera;

import DataProviders.InsperaDataProvider;
import PageObjects.insperaloginpage;
import Utilities.Base;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InsperaLoginTest extends Base {

    public WebDriver driver;
    insperaloginpage loginpage;
    Logger logger;

    @BeforeTest(alwaysRun = true)
    public void setup() {
        logger = LogManager.getLogger(InsperaLoginTest.class);
        DOMConfigurator.configure("log4j.xml");

        driver = initialiseDriver("chrome");
        logger.info("intilised webdriver");
        loginpage = new insperaloginpage(driver);


    }

    @Test(priority = 1,groups = {"login","validlogin"})
    public void baseURLNavigation() {
        String url = "https://ieltsmodernisation.inspera.com/admin";
        logger.info("BaseURLNavigation");
        driver.get(url);
        String actual_url = driver.getCurrentUrl();
        Assert.assertEquals(url, actual_url);
    }

    @Test(priority = 2, dataProviderClass = InsperaDataProvider.class, dataProvider = "insperaLogin")
    public void loginTest(String username, String password, String expected) throws InterruptedException {
        loginpage.setUsername(username);
        loginpage.setPassword(password);
        loginpage.submit();
        String homePageURL = "https://ieltsmodernisation.inspera.com/admin#home";
        Thread.sleep(2500);

        if (expected.equals("Valid")) {
            String actualURL = driver.getCurrentUrl();
            if (actualURL.equals(homePageURL)) {
                //logout
                loginpage.ClickOnSettingbtn();
                loginpage.Logout();

                Assert.assertTrue(true);
            } else
                Assert.fail();
        }

        if (expected.equals("Invalid")) {
            String actualURL = driver.getCurrentUrl();
            if (actualURL.equals(homePageURL)) {
                //logout
                loginpage.ClickOnSettingbtn();
                loginpage.Logout();
                Assert.fail();
            } else
                Assert.assertTrue(true);
        }
    }

    @Test(priority = 3,groups = {"login","validlogin"})
    public void validLogin(){
        loginpage.setUsername("sachin_user");
        loginpage.setPassword("Testing@123");
        loginpage.submit();
    }
}
