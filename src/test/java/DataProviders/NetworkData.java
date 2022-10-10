package DataProviders;

import org.testng.annotations.DataProvider;

public class NetworkData {

    @DataProvider
    public Object[][] form_data(){
        String form[][]={{"sachin","sharma","sachin.sharma@bc.com","New Delhi","india","TEST12345","TEST","HCL"},
                {"ankur","gupta","ankur.gupta@gmail.com","UP","america","AM7654","Machine learning","TCS"}};

        return form;

    }
}
