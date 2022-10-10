package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class insperaloginpage {

    WebDriver driver;

    @FindBy(id = "userName")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary login-btn']")
    WebElement submit;



    @FindBy(xpath = "//div[@class='ia-settings-menu grading-settings']")
    WebElement settingbtn;

    @FindBy(css = ".logout-link")
    WebElement logout;

    public insperaloginpage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    public void setUsername(String userName) {
        username.clear();
        username.sendKeys(userName);

    }

    public void setPassword(String pwd) {
        password.clear();
        password.sendKeys(pwd);

    }

    public void submit() {
        submit.click();
    }


    public void ClickOnSettingbtn() {
        settingbtn.click();
    }

    public void Logout() {
        logout.click();
    }
}
