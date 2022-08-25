package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class IosAndAndroidContactOneCodePage  extends BasePage{

	public IosAndAndroidContactOneCodePage(AppiumDriver driver) {
		super(driver);
	}

	//
	//
	//	//elements
	//	//add button
	@AndroidFindBy(id = "com.android.contacts:id/floating_action_button_container")
	@iOSXCUITFindBy (accessibility =  "Add")
	MobileElement AddBtn;
	


	@AndroidFindBy(xpath =  "//*[@text='First name']")
	@iOSXCUITFindBy (accessibility ="First name")
	MobileElement FirstName;

	@AndroidFindBy(xpath =  "//*[@text='Last name']")
	@iOSXCUITFindBy (accessibility ="Last name")
	MobileElement LastName;

	@AndroidFindBy(id = "com.android.contacts:id/editor_menu_save_button")
	@iOSXCUITFindBy (accessibility ="Done")
	MobileElement SaveBtn;


	@AndroidFindBy (id = "com.android.contacts:id/left_button")
	MobileElement CancelAddAccount;


	public void addContact(){

		AddBtn.click();
//
//		boolean x = CancelAddAccount.findElements(By.id("com.android.contacts:id/left_button")).size()>0;
//		if (x) {
//			CancelAddAccount.click();
//		}
		FirstName.sendKeys("Hussam");
		LastName.sendKeys("ELfekey");
		SaveBtn.click();


	}

//
//	//Elements
//	//to search for element in ios device we can use iosxcuitfindry
//	@iOSXCUITFindBy (accessibility ="Add")
//	IOSElement addContactBTN;
//
//
//	//ios
//	@iOSXCUITFindBy (accessibility =  "Add")
//	IOSElement AddBtnIOS;
//
//	@iOSXCUITFindBy (accessibility ="First name")
//	IOSElement FirstNameIOS;
//
//	@iOSXCUITFindBy (accessibility ="Last name")
//	IOSElement LastNameIOS;
//
//	@iOSXCUITFindBy (accessibility ="Done")
////	IOSElement SaveBtnIOS;
//
//	public void addContactIOS(){
//
//		AddBtnIOS.click();
//		FirstNameIOS.sendKeys("Hussam");
//		LastNameIOS.sendKeys("ELfekey");
//		SaveBtnIOS.click();
//
//
//	}
}
