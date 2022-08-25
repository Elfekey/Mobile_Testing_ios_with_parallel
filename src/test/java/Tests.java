
//the packages i'll use to get objects from it
import Pages.*;
import Tests.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Utilities.*;

import java.net.MalformedURLException;


@Listeners(ScreenShotsListener.class)
public class Tests  extends BaseTest {

   // @BeforeTest
    public  void before() throws MalformedURLException {
//        setUp();
     // setUp2("9.0");
      //
 //       IOS_Setup("15.5","iPhone 11");
        IOS_Setup("15.5","H-Elfekey");

    }
@Test(priority = 1,retryAnalyzer = RerunFailedTests.class)
public void ClickONAppBTN(){
    ApiDemosPage apiDemosPage = new ApiDemosPage(driver);

    apiDemosPage.click_App_Button();
//    Assert.assertTrue(false);
}

    @Test(priority = 2)
public void CalculatorTest(){
    CalculatorPage calculatorPage= new CalculatorPage(driver);
    calculatorPage.sum();
}
    @Test(priority = 3)
    public void IOS_click_App_Button() throws InterruptedException {
IOS_Setup("15.5", "iPhone 11");
//        IosUICatalogPage iosUICatalogPage= new IosUICatalogPage(driver);
//iosUICatalogPage.UiCatalogBtn_Click();
//        Thread.sleep(3000);
    }
    @Test(priority = 4)
    public void IOS_click_AddContact_Button() throws InterruptedException, MalformedURLException {
        IOS_Setup_BuiltInAppContatcs("15.5", "iPhone 11");
        IosTestBuiltInAppContactPage iosTestBuiltInAppContactPage = new IosTestBuiltInAppContactPage(driver);
        iosTestBuiltInAppContactPage.AddContactBTN_Click();
        Thread.sleep(3000);
    }


    @Test(priority = 6,retryAnalyzer = RerunFailedTests.class)//analyzer is to rerun if the test failed
public void Run_in_parallel_firstDevice() throws MalformedURLException {
        setUp_ios_RealDevice_in_Parallel("H-Elfekey", "4723", "8100","00008020-0001350A21E9002E","15.5");
        setUp_ios_RealDevice_in_Parallel("hussam's iPhone", "4724", "8200","00008030-00126560222B402E","15.5");
    }
    @Test(priority = 5,description = "Testing on real device",
            retryAnalyzer =RerunFailedTests.class,
                    dataProvider = "Credintials",dataProviderClass = TestNGDataProvider.class)
  //  public void RealDevice_tests(String User,String Password) throws MalformedURLException {//these two strings for data provider
    public void TC001(String user,String password) throws MalformedURLException {//these two strings for data provider we don't have to use the comming values to run the test case
        setUp_ios_RealDevice("Hussam’s iPhone","00008030-00126560222B402E");
        Assert.assertTrue(false);

//        Assert.assertTrue(false);//to try rerun failed test cases

        //object from page
        IosUICatalogPage oiosUICatalogPage = new IosUICatalogPage(driver);
        oiosUICatalogPage.StacksViewBTN.click();
        oiosUICatalogPage.PlustStacksViewBTN.click();
        //if i'll use data provider test  COmment from HERE
        //object from read data from excel sheet
//        ReadExcelData oReadData = new ReadExcelData("TestData");
//oiosUICatalogPage.FirstTextBox.sendKeys(oReadData.GetDataByFirstRowDataNameOnly("User1"));
//oiosUICatalogPage.SecondTextBox.sendKeys(oReadData.GetDataByFirstRowDataNameOnly("Date"));
//        oiosUICatalogPage.FirstTextBox.clear();
//        oiosUICatalogPage.SecondTextBox.clear();
//        oiosUICatalogPage.FirstTextBox.sendKeys(oReadData.getDataFromExcellByeRowNameAndColumnName("User1", "Data2"));
//        oiosUICatalogPage.SecondTextBox.sendKeys(oReadData.getDataFromExcellByeRowNameAndColumnName("Passowrd1","Data2" ));
//        To HERE
        System.out.println("------TestNG Data Provider----------");
        oiosUICatalogPage.FirstTextBox.sendKeys(user);
        oiosUICatalogPage.SecondTextBox.sendKeys(password);
//
    }


  //  @AfterTest
    public void after(){
        tearDown();
    }
}
