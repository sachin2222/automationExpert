package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesForceNetworkPage {

    @FindBy(id = "first_name")
    WebElement first_name;

    @FindBy(id = "last_name")
    WebElement last_name;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(name = "country-label")
    WebElement country_label;

    @FindBy(xpath = "//div[@id='MyCountryInput_aautocomplete-list']/div[1]")
    WebElement select_country;

    @FindBy(id = "company")
    WebElement company;
    @FindBy(id = "linkedin")
    WebElement linkedin;

    @FindBy(id = "title")
    WebElement title;

    WebDriver driver;

    public SalesForceNetworkPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    public WebElement getFirst_name() {
        first_name.clear();
        return first_name;
    }

    public WebElement getLast_name() {
        last_name.clear();
        return last_name;
    }

    public WebElement getEmail() {
        email.clear();
        return email;
    }

    public WebElement getCity() {
        city.clear();
        return city;
    }

    public WebElement getCountry_label() {
        country_label.clear();
        return country_label;
    }

    public WebElement getSelect_country() {
        return select_country;
    }

    public WebElement getCompany() {
        company.clear();
        return company;
    }

    public WebElement getLinkedin() {
        linkedin.clear();
        return linkedin;
    }

    public WebElement getTitle() {
        title.clear();
        return title;
    }


}
