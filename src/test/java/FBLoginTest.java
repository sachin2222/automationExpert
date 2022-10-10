import DataProviders.FbLoginDataProvider;

import PageObjects.FbLoginPage;
import Utilities.Base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


public class FBLoginTest extends Base {
    public WebDriver driver;
    public FbLoginPage fbLoginPage;
    public Logger logger;

    @BeforeTest
    public void navigateToFBLoginPage() {

        logger = LogManager.getLogger(FBLoginTest.class);
        DOMConfigurator.configure("log4J.xml");

        driver = initialiseDriver("chrome");
        logger.info("Initialised web-driver");

        fbLoginPage = new FbLoginPage(driver);

        FbITestListener.getLog(logger);
    }

    @Test(dataProviderClass = FbLoginDataProvider.class, dataProvider = "FbloginData")
    public void loginTest(String email, String pwd, String exp) throws InterruptedException {
        driver.get("https://www.facebook.com/login/");
        logger.info("Navigating to Base URL");
        fbLoginPage.getEmail().sendKeys(email);
        fbLoginPage.getPassword().sendKeys(pwd);
        fbLoginPage.getSubmit().click();
        Thread.sleep(1500);
        String exp_title = "Facebook";
        String actual_title = driver.getTitle();
        if (exp.equals("Valid")) {

            if (exp_title.equals(actual_title)) {
                Assert.assertTrue(true);
                logger.info("Login Successfully with Valid credentials");

                driver.findElement(By.cssSelector("svg[aria-label='Your profile']")).click();
                driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
                logger.info("Logout successfully");

            } else{
                Assert.assertTrue(false);
                logger.error("Invalid credentials");

            }


        } else if (exp.equals("Invalid")) {
            if (exp_title.equals(actual_title)) {
                Assert.assertTrue(false);
                logger.error("Login Successfully with Invalid Credentials");
                driver.findElement(By.cssSelector("svg[aria-label='Your profile']")).click();
                driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
                logger.error("Logout successfully");

            } else {
                Assert.assertTrue(true);
                logger.info("Login is not successful  with Invalid Credentials");
            }


        }


    }

}
