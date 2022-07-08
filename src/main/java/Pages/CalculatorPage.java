package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;


public class CalculatorPage extends  BasePage{
    public CalculatorPage(AppiumDriver driver) {
        super(driver);
    }
    //elements
    @AndroidFindBy(id = "digit_1")
    MobileElement NO1;
    @AndroidFindBy(id = "digit_2")
    MobileElement NO2;
    @AndroidFindBy(id = "digit_3")
    MobileElement NO3;
    @AndroidFindBy(id = "digit_4")
    MobileElement NO4;
    @AndroidFindBy(id = "digit_5")
    MobileElement NO5;
    @AndroidFindBy(id = "digit_6")
    MobileElement NO6;
    @AndroidFindBy(id = "digit_7")
    MobileElement NO7;
    @AndroidFindBy(id = "digit_8")
    MobileElement NO8;
    @AndroidFindBy(id = "digit_9")
    MobileElement NO9;
    @AndroidFindBy(id = "digit_0")
    MobileElement NO0;
    @AndroidFindBy(accessibility = "equals")
    MobileElement equal;
@AndroidFindBy (accessibility = "plus")
MobileElement plus;
    @AndroidFindBy (accessibility = "multiply")
    MobileElement multiply;
    @AndroidFindBy (id = "result")
    MobileElement result;

    public void sum(){
NO3.click();
plus.click();
NO2.click();
equal.click();
try {
    int res = Integer.parseInt(result.getText().toString());
    Assert.assertTrue(res == (3+2));
}catch (Exception e){
    e.printStackTrace();
}

}
}
