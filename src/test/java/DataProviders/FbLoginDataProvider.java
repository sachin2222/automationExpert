package DataProviders;

import Utilities.XLUtility;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class FbLoginDataProvider {

    @DataProvider(name = "FbloginData")
    public Object[][] getLoginData() throws IOException {
        String path = "C:\\Users\\sachi\\IdeaProjects\\untitled1\\Excel\\DDT.xlsx";
        String sheetName = "TEST";
        XLUtility xlUtility = new XLUtility(path);
        int rowscount = xlUtility.getRowCount(sheetName);
        int colscount = xlUtility.getCellCount(sheetName, 0);
        String loginData[][] = new String[rowscount][colscount];

        for (int i = 1; i <=rowscount; i++) {

            for (int j = 0; j < colscount; j++) {
                loginData[i - 1][j] = xlUtility.getCellData(sheetName, i, j);
            }
        }

        return loginData;
    }
}
