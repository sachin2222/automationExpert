package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesForceCarrierObjects {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(@href,'?d=cta-nav')]")
    WebElement searchjobs;

    public SalesForceCarrierObjects(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public WebElement get_element_searchJob(){
        return searchjobs;
    }


}
