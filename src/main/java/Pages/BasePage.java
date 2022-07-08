package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.util.Assert;

public class BasePage {
    public  static AppiumDriver driver ;
//    @FindBys({
//            @FindBy(class="custom-control-check-box"),
//            @FindBy(id="game-chk-box")
//    })
//    WebElement chkBox;

    public BasePage(AppiumDriver driver){
    this.driver= driver;
//        PageFactory.initElements(driver, this);

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    //methods

}
