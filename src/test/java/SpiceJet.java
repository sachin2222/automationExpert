import Utilities.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SpiceJet extends Base {
    WebDriver driver;
    @BeforeTest(alwaysRun = true)
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://www.spicejet.com/");

    }

    @Test
    public void test1(){
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj']/div[2]/div[2]")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/input[1]")).click();
        List<WebElement> fromCity=driver.findElements(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79']"));
        System.out.println(fromCity.size()+" is the Total from Cities");
        for(WebElement city:fromCity){
            if(city.getText().contains("Chennai")){
                city.click();
                break;
            }

        }

        List<WebElement> toCity=driver.findElements(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79']"));
        System.out.println(toCity.size()+" is the Total TO Cities");
        for(WebElement city:toCity){
            if(city.getText().contains("Agra")){
                city.click();
                break;
            }

        }

        List<WebElement> months=driver.findElements(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));
        System.out.println(months.size()+" Months");
        for(WebElement month:months){
            System.out.println(month.getText());
        }

    }

    public static class ITestFbListener implements ITestListener {


        static Logger ILOg;
        ExtentReports extentReports;
        ExtentTest test;
        ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();


        public static void getLog(Logger log) {
            ILOg = log;
        }

        @Override
        public void onStart(ITestContext iTestContext) {

            String path = System.getProperty("user.dir") + "\\Reports\\index.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("Web Automation Report");

            extentReports = new ExtentReports();
            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Tester", "sachin sharma");

        }

        @Override
        public void onTestStart(ITestResult iTestResult) {
            test = extentReports.createTest(iTestResult.getMethod().getMethodName());
            extentTest.set(test);
            ILOg.info(iTestResult.getName() + ":STARTED");


        }

        @Override
        public void onTestSuccess(ITestResult iTestResult) {
            extentTest.get().log(Status.PASS, "Test Passed");
            ILOg.info(iTestResult.getName() + ": PASSED");


        }

        @Override
        public void onTestFailure(ITestResult iTestResult) {
            extentTest.get().log(Status.FAIL, "Test case Failed");
            extentTest.get().fail(iTestResult.getThrowable());

            ILOg.error(iTestResult.getName() + ": FAILED");
            ILOg.error(" Priority of " + iTestResult.getMethod().getMethodName() + " Test Method is " + iTestResult.getMethod().getPriority());
            String exception = iTestResult.getThrowable().getMessage();
            if (exception != null) {
                ILOg.error(exception);
            }

            try {
                WebDriver driver = (WebDriver) iTestResult.getTestClass().getRealClass().getDeclaredField("driver").get(iTestResult.getInstance());
                extentTest.get().addScreenCaptureFromPath(takeScreenShot(iTestResult.getMethod().getMethodName(), driver),iTestResult.getMethod().getMethodName());

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        @Override
        public void onTestSkipped(ITestResult iTestResult) {
            extentTest.get().log(Status.SKIP,"Test Case Skipped");
            ILOg.error(iTestResult.getName() + ": SKIPPED");

        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

        }


        @Override
        public void onFinish(ITestContext iTestContext) {
            extentReports.flush();

        }
    }
}
