package SwagLabs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement login_button;

    public LoginPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String user_name) {
        username.sendKeys(user_name);

    }

    public void setPassword(String pwd) {
        password.sendKeys(pwd);

    }

    public void clickLogin_button() {
        login_button.click();
    }

}
