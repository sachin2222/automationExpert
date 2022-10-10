package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonitorPage {

    WebDriver driver;

    @FindBy(css = "#main_nav_monitoring")
    WebElement monitor;

    @FindBy(xpath = "//input[@placeholder='Search candidates']")
    WebElement search_tt;



    @FindBy(css="#check122138448_120006459")
    WebElement checkbox1;

    @FindBy(xpath = "//span[contains(@data-reactid,'manually_0.0.1')]")
    WebElement editendtime;

    @FindBy(xpath = "//label[@class='optionLabel endIn selected']/input")
    WebElement endinCheckbox;

    @FindBy(xpath = "//div[@id='c122']/input[1]")
    WebElement hoursOfEndIn;


    @FindBy(xpath = "//div[@id='c122']/input[2]")
    WebElement minutesOfEndIn;

    @FindBy(xpath = "//span[@data-reactid='.6.1.3.h.0.0.2.1:$state-button-1.0']")
    WebElement apply_btn_edit_end_time;


    public void Search_TT_By_ID(String tt_id) {
        search_tt.sendKeys(tt_id);
    }

    public void setCheckbox1() {
        checkbox1.click();
    }

    public void clickEditendtime() {
        editendtime.click();
    }
    public void setEndinCheckbox() {
        endinCheckbox.click();

    }
    public void setHoursOfEndIn(String hours) {
        hoursOfEndIn.sendKeys(hours);

    }

    public void setMinutesOfEndIn(String minutes) {
        minutesOfEndIn.sendKeys(minutes);
    }

    public void ApplyEditEndtime() {
        apply_btn_edit_end_time.click();
    }

    public MonitorPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void goToMonitor(){
        monitor.click();
    }
}
