package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPage {
    WebDriver driver;

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="pass")
    WebElement Password;

    @FindBy(id="loginbutton")
    WebElement submit;

    public FbLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public WebElement getEmail() {
        email.clear();
        return email;
    }

    public WebElement getPassword() {
        Password.clear();
        return Password;
    }

    public WebElement getSubmit() {
        return submit;
    }




}
