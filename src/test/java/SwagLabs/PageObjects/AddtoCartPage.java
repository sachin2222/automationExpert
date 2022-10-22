package SwagLabs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage {



    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement bag_pack;

    @FindBy(id="shopping_cart_container")
    WebElement shopping_cart_container;

    @FindBy(id="first-name")
    WebElement first_name;

    @FindBy(id="last-name")
    WebElement last_name;

    @FindBy(id="postal-code")
    WebElement postal_code;

    @FindBy(id="checkout")
    WebElement checkout;

    @FindBy(id="continue")
    WebElement continue_btn;

    @FindBy(id="finish")
    WebElement finish;

    WebDriver driver;

    public AddtoCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void select_Bag_pack() {
        bag_pack.click();
    }

    public void ClickShopping_cart_container() {
         shopping_cart_container.click();
    }

    public void setFirst_name(String fname) {
        first_name.sendKeys(fname);
    }

    public void setLast_name(String lname) {
        last_name.sendKeys(lname);
    }
    public void setPincode(String pin) {
        postal_code.sendKeys(pin);
    }

    public void Checkout() {
         checkout.click();
    }

    public void Continue() {
        continue_btn.click();
    }

    public void Finish() {
         finish.click();
    }

}
