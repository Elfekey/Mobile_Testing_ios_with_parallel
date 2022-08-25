package Utilities;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class TestNGDataProvider {
    /* we can use it As Below
    *below the name of the data provider and then the name and the path of it's class from the package.classname.class
* here we need to put the data provider name and the data provider class with it's package.classname.class
import Utilities.*;
    @Test(priority = 1,dataProvider = "DB",dataProviderClass =RunWithDifferentData.DP.class)
    public void testWithData(String UserName,String Password) {
        System.out.println("userName Value : "+UserName+"AND Password Value :"+Password);
    }*/
    //Data Provider for user name and password with single and different data fot some test cases
    @DataProvider(name = "Credintials")
    public Object[][] TestCasesDataCredintials(Method methodname){
        switch (methodname.getName()) {
            case "TC001":
            case "tc001":
                return new Object [][] {{"Hussam Elfekey","123456"}};//,
//            {"Mohamed Ahmed","1234567891"}
            case "TC002":
            case "tc002":
                //here the test Case will run 2 times with different credintials
                return new Object [][] {{"Liqaa Ahmed",64515615},
                        {"Mohamed Ahmed",1234567891}};
            default:
                return new Object [][] {{"THIS TEST CASE METHOD NAME NOT EXIST Ya 7osss"}};
        }
    }}

