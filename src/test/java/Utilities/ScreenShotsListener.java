package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenShotsListener extends EvidenceAndScreenShots implements ITestListener {
   static ExtentReports extent = new ExtentReports();
    ExtentSparkReporter sparkAll = new ExtentSparkReporter("./AllTestsReport/SparkAll.html");;

    static ExtentSparkReporter sparkPass;
    static ExtentSparkReporter sparkFail;
    @Override
    public void onTestSuccess(ITestResult result) {
        String status = "Passed";
        takeFullScreenshot(result.getName(),result.getName(),result.getMethod().getDescription(), status);//status PAssed/Failed/Skipped Ect...
        saveAllScreenShotsIntoWordDocument(result.getName(),result.getMethod().getDescription(),status);  //status passed/failed/skiped ect....

//-----------trying extent report------------
//         sparkPass = new ExtentSparkReporter("./PassedTestReport/PassedReport.html")
//                .filter()
//                .statusFilter()
//                .as(new Status[] { Status.PASS })
//                .apply();
//        //below the test case name and it's log
//        extent.createTest(result.getName()).
//                log(Status.PASS, "This is a logging event for MyFirstTest, and it Passed!");
//        //
//
//        extent.attachReporter(sparkPass,sparkAll);
//        extent.flush();

    }

    @Override
    public void onTestFailure(ITestResult result) {
        String status = "Failed";
        takeFullScreenshot(result.getName(),result.getName(),result.getMethod().getDescription(), status);//status PAssed/Failed/Skipped Ect...
        saveAllScreenShotsIntoWordDocument(result.getName(),result.getMethod().getDescription(),status);  //status passed/failed/skiped ect....
        //in the before test initialize the below two lines
//-----------trying extent report------------
        // will only contain failures
//        sparkFail = new ExtentSparkReporter("./FailedTestReport/SparkFail.html")
//                .filter()
//                .statusFilter()
//                .as(new Status[] { Status.FAIL })
//                .apply();
//        //below the test case name and it's log
//        extent.createTest(result.getName()).
//                log(Status.FAIL, "This is a logging event for MyFirstTest, and it Failed!");
//        extent.setSystemInfo("OS", "type");
//        extent.attachReporter(sparkFail,sparkAll);
//
//  ExtentTest extenttest = extent.createTest(result.getName());
////ScreenShots
//// reference image saved to disk
//        extenttest.fail(MediaEntityBuilder.createScreenCaptureFromPath(fullDirectory+result.getName()+"_"+status+"/"+"img.png").build());
//// base64
////        test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
//
//        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String status = "Skipped";
        takeFullScreenshot(result.getName(),result.getName(),result.getMethod().getDescription(), status);//status PAssed/Failed/Skipped Ect...
        saveAllScreenShotsIntoWordDocument(result.getName(),result.getMethod().getDescription(),status);  //status passed/failed/skiped ect....

    }
}
