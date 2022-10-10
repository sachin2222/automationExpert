
import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;

public class DbConnection extends Base {

    @BeforeSuite
    public void setup(){
        driver=initialiseDriver("chrome");
        driver.get("https://en-gb.facebook.com/login/");
    }

    @Test
    public void test1() throws SQLException {
        String host = "localhost";
        String port = "3306";
        String url = "jdbc:mysql://" + host + ":" + port + "/QA_DB1";

        Connection connection = DriverManager.getConnection(url, "sachin_user", "test");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from Fb_login_Details where id=1;");

        while(rs.next()){
            driver.findElement(By.name("email")).sendKeys(rs.getString("Email_id"));
            driver.findElement(By.name("pass")).sendKeys(rs.getString("password"));
            driver.findElement(By.name("login")).click();

        }


    }
}
