package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;

public class ApiDemosPage  extends  BasePage{
    @AndroidFindBy (accessibility = "App")
    @CacheLookup
    AndroidElement AppBTN;

    public ApiDemosPage(AppiumDriver driver) {
        super(driver);
    }

    //elements
//            driver.findElementByAccessibilityId("App").click();

    public void click_App_Button() {
        // code
        AppBTN.click();
        System.out.println("The system Directory is : "+System.getProperty("user.dir"));
    }
}
