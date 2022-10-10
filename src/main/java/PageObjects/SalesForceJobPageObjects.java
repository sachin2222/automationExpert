package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SalesForceJobPageObjects {

    WebDriver driver;


    @FindBy(css = "[data-automation-id='textInputBox']")
    WebElement search;

    @FindBy(css = "span[title='Search']")
    WebElement searchButton;

    @FindBy(css = ".WILO")
    WebElement resultValue;

    @FindBy(css = "[data-automation-id='compositeSubHeaderOne']")
    List<WebElement> job_code;

    @FindBy(css = "[title='© 2022 Workday, Inc. All rights reserved.']")
    WebElement title;

    @FindBy(css = ".WGNF")
    List<WebElement> checkbox_list;

    @FindBy(css = "[data-automation-id='logo']")
    WebElement logo;
    @FindBy(xpath = "//div[@title='Products and Technology']/following-sibling::span")
    WebElement checkBox_job_count;


    public SalesForceJobPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public WebElement getSearch() {
        return search;
    }
    public WebElement getLogo() {
        return logo;
    }
    public WebElement getCheckBox_job_count() {
        return checkBox_job_count;
    }


    public WebElement getSearchButton() {
        return searchButton;

    }

    public WebElement getResultValue() {
        return resultValue;

    }

    public WebElement getTitle() {
        return title;

    }

    public List<WebElement> getJob_code() {
        return job_code;

    }

    public List<WebElement> getCheckbox_list() {
        return checkbox_list;
    }
}
