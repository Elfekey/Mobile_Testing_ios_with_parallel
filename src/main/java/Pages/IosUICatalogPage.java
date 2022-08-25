package Pages;

import Pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.FindBy;

public class IosUICatalogPage  extends BasePage {


    public IosUICatalogPage(AppiumDriver driver) {
        super(driver);
    }

    //elements
    //        driver.findElement(By.xpath("//XCUIElementTypeButton[@label='UIKitCatalog' and @name='UIKitCatalog']")).click();
    @FindBy (xpath = "//XCUIElementTypeButton[@label='UIKitCatalog' and @name='UIKitCatalog']")
    IOSElement  uiCatalogBTN;

    @FindBy  (xpath = "//XCUIElementTypeCell[12]/XCUIElementTypeOther[1]")
    public  IOSElement StacksViewBTN;

    @FindBy  (xpath = "//*[XCUIElementTypeTextField][1]")
    public IOSElement FirstTextBox;
    @FindBy  (xpath = "(//*[@name='stepper increment'])[1]")
    public IOSElement PlustStacksViewBTN;
    @FindBy  (xpath = "//*[XCUIElementTypeTextField][2]")
    public IOSElement SecondTextBox;


    //methods
    public void UiCatalogBtn_Click(){
        uiCatalogBTN.click();
    }

}
