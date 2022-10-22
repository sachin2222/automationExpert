package Steps2;

import Utllities.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class TagsStepsDef extends Base {
    WebDriver driver;

    @Before
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://rahulshettyacademy.com/angularpractice/");

    }

    @After
    public void teardown() {
        driver.close();
    }

    @Given("test scenario a")
    public void test_scenario_a() {

    }


    @Given("test scenario b")
    public void test_scenario_b() {

    }


    @Given("test scenario c")
    public void test_scenario_c() {

    }


    @Given("test scenario d")
    public void test_scenario_d() {

    }


    @Given("test scenario e")
    public void test_scenario_e() {

    }


    @Given("test scenario f")
    public void test_scenario_f() {

    }


    @Given("test scenario g")
    public void test_scenario_g() {

    }


    @Given("test scenario h")
    public void test_scenario_h() {
        ;
    }


    @Given("test scenario i")
    public void test_scenario_i() {

    }


    @Given("test scenario j")
    public void test_scenario_j() {

    }

}
