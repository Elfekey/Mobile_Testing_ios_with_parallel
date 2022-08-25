package Utilities;


import Tests.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenShotsListener.class)
public class ExtentDemo   {
    //  ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
    WebDriver driver;
    @Test(description = "check true of false")
    public void TC001() {
        WebDriverManager.chromedriver().setup();
//        EvidenceAndScreenShots evidenceAndScreenShots = new EvidenceAndScreenShots();
//        System.out.println(evidenceAndScreenShots.fullDirectory+"TC001"+"_"+"Failed");
        driver = new ChromeDriver();
        driver.get("https://www.extentreports.com/docs/versions/5/java/index.html");
//        System.out.println("Hi");
    }
    @Test
    public void testingExtent() {
        WebDriverManager.chromedriver().setup();
//        EvidenceAndScreenShots evidenceAndScreenShots = new EvidenceAndScreenShots();
//        System.out.println(evidenceAndScreenShots.fullDirectory+"TC001"+"_"+"Failed");
        Assert.assertTrue(false);
//    driver= new ChromeDriver();
//    driver.get("https://www.extentreports.com/docs/versions/5/java/index.html");
        System.out.println("Hi");

//    driver.close();
//
//        // will only contain failures
//        ExtentSparkReporter sparkFail = new ExtentSparkReporter("target/SparkFail.html")
//                .filter()
//                .statusFilter()
//                .as(new Status[] { Status.FAIL })
//                .apply();
//// will contain all tests
//        ExtentSparkReporter sparkAll = new ExtentSparkReporter("spark/SparkAll.html");
//        extent.attachReporter(sparkFail, sparkAll);

    }
}
//@AfterTest
//    public void after(){
//    ExtentReports extent = new ExtentReports();
////    ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/TestReport/TestReport.html");
////    extent.attachReporter(spark);
////    extent.createTest("MyFirstTest3")
////            .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
////    extent.flush();
//
////    ExtentSparkReporter sparkFail = new ExtentSparkReporter(System.getProperty("user.dir")+"/FailedTestReport/SparkFail.html")
////            .viewConfigurer()
////            .viewOrder()
////            .as(new ViewName[] {
////                    ViewName.DASHBOARD,
////                    ViewName.TEST,
//////                    ViewName.TAG,
////                    ViewName.AUTHOR,
////                    ViewName.DEVICE,
////                    ViewName.EXCEPTION,
////                    ViewName.LOG
////            })
////            .apply();\
////            //-----------------------
////            .viewConfigurer()
////            .viewOrder()
////            .as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST })
////            .apply();
//    //-----------------------
//    // will only contain failures
////    ExtentSparkReporter sparkFail = new ExtentSparkReporter("./FailedTestReport/SparkFail.html")
////            .filter()
////            .statusFilter()
////            .as(new Status[] { Status.FAIL })
////            .apply();
////    //below the test case name and it's log
////    extent.createTest("TestCaseName").
////            log(Status.FAIL, "This is a logging event for MyFirstTest, and it Failed!");
////
////    //Passed test cases
////    ExtentSparkReporter sparkPass = new ExtentSparkReporter("./PassedTestReport/SparkFail.html")
////            .filter()
////            .statusFilter()
////            .as(new Status[] { Status.PASS })
////            .apply();
////    //below the test case name and it's log
////    extent.createTest("TestCaseName").
////    log(Status.PASS, "This is a logging event for MyFirstTest, and it Passed!");
//
//    //objects from listener
////    ScreenShotsListener screenShotsListener = new ScreenShotsListener();
////// will contain all tests
////    ExtentSparkReporter sparkAll = new ExtentSparkReporter("./AllTestsReport/SparkAll.html");
////    extent.attachReporter(screenShotsListener.sparkFail,screenShotsListener.sparkPass, sparkAll);
////
////    extent.flush();
////}
//    }


