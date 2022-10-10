package DataProviders;

import Utilities.XLUtility;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class InsperaDataProvider {

    @DataProvider(name = "insperaLogin")
    public Object[][] logindata() throws IOException {
        String path = "C:\\Users\\sachi\\IdeaProjects\\untitled1\\Excel\\insperalogin.xlsx";
        String sheet = "Login";
        XLUtility xlUtility = new XLUtility(path);
        int rowcount = xlUtility.getRowCount(sheet);
        int cellcount = xlUtility.getCellCount(sheet, 0);
        String login_cred[][] = new String[rowcount][cellcount];

        for (int i = 1; i <=rowcount; i++) {
            for (int j = 0; j < cellcount; j++) {
                login_cred[i - 1][j] = xlUtility.getCellData(sheet, i, j);
            }
        }
        return login_cred;
    }
}
