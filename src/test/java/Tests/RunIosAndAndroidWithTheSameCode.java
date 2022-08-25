package Tests;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import Pages.IosAndAndroidContactOneCodePage;
import Pages.IosTestBuiltInAppContactPage;


public class RunIosAndAndroidWithTheSameCode  extends BaseTest{

	//the test 
	IosAndAndroidContactOneCodePage iscontactPageob;
	@Test
	public void CalcTestWithTheSameCode()throws InterruptedException, MalformedURLException {

		//	//android
		setUpAndContact("9.0");//android calc setup
//		setUpAIosContact_in_Parallel("iPhone 11", "1234", "8300","15.5");
		iscontactPageob = new IosAndAndroidContactOneCodePage(driver);

		iscontactPageob.addContact();
		//        //ios

		//	    iPhone 11 (5174D9B6-A223-425F-AD0A-04011FD50A9D) (Booted) 

		//		 iscontactPageob = new IosAndAndroidContactOneCodePage(driver);
		//		iscontactPageob.addContactIOS();

	}

}
