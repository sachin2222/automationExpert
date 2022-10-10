package DataProviders;

import org.testng.annotations.DataProvider;

public class GreenKartDataProvider {

    @DataProvider(name="veggiesData")
    public Object[][] getVeggiesData(){
        String veggies[][]={{"Beetroot","5"}};
        return veggies;

    }
}
