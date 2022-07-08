package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;

public class IosTestBuiltInAppContactPage extends  BasePage{

    public IosTestBuiltInAppContactPage(AppiumDriver driver) {
        super(driver);
    }

    //Elements
    //to search for element in ios device we can use iosxcuitfindry
    @iOSXCUITFindBy (accessibility ="Add")
    IOSElement addContactBTN;

    //Methods
    public void AddContactBTN_Click(){
        addContactBTN.click();
    }

}
