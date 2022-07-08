package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public  static AppiumDriver driver;
    public WebDriverWait wait ;


    public void setUp(String version) throws MalformedURLException {
       // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        try {
        //   wait= new WebDriverWait(driver, 15);
        DesiredCapabilities caps = new DesiredCapabilities();
//             caps.setCapability("appium:platformName", "Android");
//        caps.setCapability("appium:automationName","UiAutomator2");
//                caps.setCapability("appium:platformVersion","11");
//                caps.setCapability("appium:deviceName","AndImulator");
//                caps.setCapability("appium:app","/Users/h-elfekey/IdeaProjects/Mobile_testing/apps/ApiDemos-debug.apk");
        //Bth ways are working with android the above or the below
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", version);
        caps.setCapability("deviceName", "AndImulator");
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setUp2(String version) throws MalformedURLException {
        // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        try {
            //   wait= new WebDriverWait(driver, 15);
            DesiredCapabilities caps = new DesiredCapabilities();
//             caps.setCapability("appium:platformName", "Android");
//        caps.setCapability("appium:automationName","UiAutomator2");
//                caps.setCapability("appium:platformVersion","11");
//                caps.setCapability("appium:deviceName","AndImulator");
//                caps.setCapability("appium:app","/Users/h-elfekey/IdeaProjects/Mobile_testing/apps/ApiDemos-debug.apk");
            //Bth ways are working with android the above or the below
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("platformVersion", version);
            caps.setCapability("deviceName", "AndImulator");
            caps.setCapability("appium:appPackage", "com.android.calculator2");
            caps.setCapability("appium:appActivity", ".Calculator");
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void IOS_Setup(String version,String deviceName){
        //5174D9B6-A223-425F-AD0A-04011FD50A9D
        try {
            //   wait= new WebDriverWait(driver, 15);
            DesiredCapabilities caps = new DesiredCapabilities();
//             caps.setCapability("appium:platformName", "Android");
//        caps.setCapability("appium:automationName","UiAutomator2");
//                caps.setCapability("appium:platformVersion","11");
//                caps.setCapability("appium:deviceName","AndImulator");
//                caps.setCapability("appium:app","/Users/h-elfekey/IdeaProjects/Mobile_testing/apps/ApiDemos-debug.apk");
            //Bth ways are working with android the above or the below
            caps.setCapability("platformName", "iOS");
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("platformVersion", version);
            caps.setCapability("deviceName", deviceName);//uicatalog
            caps.setCapability("udid","00008020-0001350A21E9002E");//test
            caps.setCapability("app", System.getProperty("user.dir") + "/apps/UIKitCatalog.app");
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void IOS_Setup_BuiltInAppContatcs(String version,String deviceName){
        //5174D9B6-A223-425F-AD0A-04011FD50A9D
        try {
            //   wait= new WebDriverWait(driver, 15);
            DesiredCapabilities caps = new DesiredCapabilities();
//             caps.setCapability("appium:platformName", "Android");
//        caps.setCapability("appium:automationName","UiAutomator2");
//                caps.setCapability("appium:platformVersion","11");
//                caps.setCapability("appium:deviceName","AndImulator");
//                caps.setCapability("appium:app","/Users/h-elfekey/IdeaProjects/Mobile_testing/apps/ApiDemos-debug.apk");
            //Bth ways are working with android the above or the below
            caps.setCapability("platformName", "iOS");
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("platformVersion", version);
            caps.setCapability("deviceName", deviceName);//uicatalog
            caps.setCapability("bundleId", "com.apple.MobileAddressBook");
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setUp_ios_RealDevice() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "15.5");
        caps.setCapability("deviceName", "Hussam’s iPhone");
        caps.setCapability("udid","00008030-00126560222B402E");
        caps.setCapability("xcodeOrgId", "liqaa.ahmed2016@gmail.com");
        caps.setCapability("xcodeSigningId","iPhone Developer");
        caps.setCapability("useNewWDA","true");
        caps.setCapability("app", "/Users/h-elfekey/IdeaProjects/Mobile_testing/apps/UIKitCatalog.zip");
        //derivedDataPath
    caps.setCapability("derivedDataPath", "/Users/h-elfekey/Library/Developer/Xcode/DerivedData/WebDriverAgent-ciegwgvxzxdrqthilmrmczmqvrgu");
        //trying thisIOSDriver
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    public void tearDown() {
        try{
        if (driver != null) {
            driver.quit();
        }  }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void checkElementAndClickIT(AndroidElement element){
        try {
            element.isDisplayed();
            element.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setUp_ios_RealDevice_in_Parallel(String deviceName,String appiumPortNumber,String wdaLocalPort,String udid,String deviceVersion) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", deviceVersion);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("udid",udid);
        caps.setCapability("xcodeOrgId", "liqaa.ahmed2016@gmail.com");
        caps.setCapability("xcodeSigningId","iPhone Developer");
        caps.setCapability("useNewWDA","true");
        caps.setCapability("app", "/Users/h-elfekey/IdeaProjects/Mobile_testing/apps/UIKitCatalog.zip");
        caps.setCapability("wdaLocalPort", wdaLocalPort);//it's very important to be different too 8100 /8200 ect....
        //derivedDataPath
        caps.setCapability("derivedDataPath", "/Users/h-elfekey/Library/Developer/Xcode/DerivedData/WebDriverAgent-ciegwgvxzxdrqthilmrmczmqvrgu");
        //trying thisIOSDriver
        driver = new IOSDriver(new URL("http://localhost:"+appiumPortNumber+"/wd/hub"), caps);
    }
    }

