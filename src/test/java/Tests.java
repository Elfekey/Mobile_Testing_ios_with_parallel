
//the packages i'll use to get objects from it
import Pages.*;
import Tests.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utilities.*;

import java.net.MalformedURLException;



public class Tests  extends BaseTest {
   // @BeforeTest
    public  void before() throws MalformedURLException {
//        setUp();
     // setUp2("9.0");
      //
 //       IOS_Setup("15.5","iPhone 11");
        IOS_Setup("15.5","H-Elfekey");

    }
@Test(priority = 1)
public void ClickONAppBTN(){
    ApiDemosPage apiDemosPage = new ApiDemosPage(driver);
    apiDemosPage.click_App_Button();
}

    @Test(priority = 2)
public void CalculatorTest(){
    CalculatorPage calculatorPage= new CalculatorPage(driver);
    calculatorPage.sum();
}
    @Test(priority = 3)
    public void IOS_click_App_Button() throws InterruptedException {
        IosUICatalogPage iosUICatalogPage= new IosUICatalogPage(driver);
iosUICatalogPage.UiCatalogBtn_Click();
        Thread.sleep(3000);
    }
    @Test(priority = 4)
    public void IOS_click_AddContact_Button() throws InterruptedException {
        IOS_Setup_BuiltInAppContatcs("15.5", "iPhone 11");
        IosTestBuiltInAppContactPage iosTestBuiltInAppContactPage = new IosTestBuiltInAppContactPage(driver);
        iosTestBuiltInAppContactPage.AddContactBTN_Click();
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void RealDevice_tests() throws MalformedURLException {
        setUp_ios_RealDevice();
    }
    @Test(priority = 6,retryAnalyzer = RerunFailedTests.class)//analyzer is to rerun if the test failed
public void Run_in_parallel_firstDevice() throws MalformedURLException {
        setUp_ios_RealDevice_in_Parallel("H-Elfekey", "4723", "8100","00008020-0001350A21E9002E","15.5");
        setUp_ios_RealDevice_in_Parallel("hussam's iPhone", "4724", "8200","00008030-00126560222B402E","15.5");

    }



  //  @AfterTest
    public void after(){
        tearDown();
    }
}
