package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.io.FileUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import Tests.BaseTest;

public class EvidenceAndScreenShots  extends BaseTest {


    //We must extend base test to use the driver !!!

    //----------------------------ScreenShots methods for ITestlistener----------------------------
	/* to use this class and it's methods you should provide the below line above class name where you run your tests
	@Listeners(ScreenShotsListener.class)
	 */
    //to set screenshots folder name and it's path for example D:/screenshots/.
    //or we can type "." then folder name to create it in the project directory
    //the below will create the folder in the project directory
    //you have just to provide the location and foldername
    protected String screenshotsFolderNameAndPath = "./screenshots/";//you have just to provide the location and foldername
    protected String fullDirectory = System.getProperty("user.dir") + "/" + screenshotsFolderNameAndPath + "/";//i have to add ###test name and "/"##
    protected static String currentDateAndTime;
    /**
     * Takes screenshot of whole page and uses the current date/time as the file name
     */

    //

    /**
     * LAST SHAPE
     * Take screenshot of whole page and uses the current date/time as the file name
     * also provide screenshots for each test case in seperate folders with test case name
     * ## to use it in listener class As Below :
     * takeFullScreenshot(result.getName(),result.getName(),result.getMethod().getDescription(), status);//status PAssed/Failed/Skipped Ect...
     */
    public void takeFullScreenshot(String testCaseNameOnlyToCreateFolderForIt, String screenShotName, String testcaseDescripion, String status) {
        //taking the screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            // add the folder path and screenshot name
            // i added the screen shot status with the path to make folder fo each run of each test case run
            //the first part untill "/" is for the folder path after that is the screenshot name
            FileUtils.copyFile(file, new File(screenshotsFolderNameAndPath + testCaseNameOnlyToCreateFolderForIt + "_" + status + "/" + screenShotName + "_" + testcaseDescripion + "_" + status + GetCurrenDateAndTime() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * LAST SHAPE
     * Takes screenshot of single element in the page and uses the current date/time as the file name
     * also provide screenshots for each test case in seperate folders with test case name
     * *## to use it in listener class As Below :
     * takeScreenshotForElement(By.xpath("//*[@name='q']"),result.getName(),result.getName()+result.getMethod().getDescription(),"##Failed or passed or Skipped Accordingly###");
     * String status = "Passed";
     */
    //the locator ,screen shot name and full screenshot name  should be passed to the method
    //this method for single element for each test case seperate folder
    public void takeScreenshotForSingleElement(By locator, String testCaseNameOnlyToCreateFolderForIt, String ScreenShotName, String status) {
        WebElement element = driver.findElement(locator);
        File file = element.getScreenshotAs(OutputType.FILE);
        try {
            //to get the date and it's format in the name of the screenshot
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss-SSS");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
            LocalDateTime dateTime = LocalDateTime.now();

            //to name the screenshot
            // here we are providing the test case name from the reslts.getName() to add folder with the test name inside the test results
            // "./"  << is to open and join folder
            //the first part untill "/" is for the folder path after that is the screenshot name

            FileUtils.copyFile(file, new File(screenshotsFolderNameAndPath + testCaseNameOnlyToCreateFolderForIt + "_" + status + "/" + ScreenShotName + status + GetCurrenDateAndTime() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Creating a method to get current date and time to use it in naming
    public String GetCurrenDateAndTime() {
        //		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss-SSS");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        LocalDateTime dateTime = LocalDateTime.now();
        currentDateAndTime = dateTime.format(formatter);//test
        return currentDateAndTime;
    }

    //---------------------------------------saving the images to word file--------------------------

    /*
     * Last shape
     *    to take all screen shots from a folder to word file
     *    to use it As Below :
    saveAllScreenShotsIntoWordDocument(result.getName(),result.getMethod().getDescription(),status);  //status passed/failed/skiped ect....
     * */
    //i added the status to take images from every
    public void saveAllScreenShotsIntoWordDocument(String itestListenerDOTgetName, String testcaseDescription, String status) {
        try {
            // Create the docx object
            // Step 1: Creating a blank document
            XWPFDocument document = new XWPFDocument();
            // Step 2: Creating a Paragraph using
            // createParagraph() method
            XWPFParagraph paragraph
                    = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            // Step 3: Creating a File output stream of word
            // document at the required location
            //the below location must be declared before ,,,i did it when i take the screenshots
            FileOutputStream fos = new FileOutputStream(
                    new File(screenshotsFolderNameAndPath + itestListenerDOTgetName + "_" + testcaseDescription + "_" + status + "_" + GetCurrenDateAndTime() + ".docx"));//right place with right test name

            // Get the source folder and list of files (includes images and
            // sub-folders)   where we get the images
            File imagesSrcFilePath = new File(fullDirectory + itestListenerDOTgetName + "_" + status);

            //array of files to get the list of items inside the src folder path
            File[] list = imagesSrcFilePath.listFiles();

            //printing the number of found items
            System.out.println("Source folder item list " + list.length);

            // Iterate through the files in the source folder
            for (int images = 0; images < list.length; images++) {
                if (list[images].isFile()) {
                    System.out.println("Found File name - " + list[images].getName());

                    // Create fis for image
                    FileInputStream fis = new FileInputStream(list[images].getPath());

                    // adding the image type & images width and height
                    int imageType = XWPFDocument.PICTURE_TYPE_PNG;
                    int width = 300;
                    int height = 350;

                    // adding the found images using the fis
                    run.addPicture(fis, imageType,
                            list[images].getPath(), Units.toEMU(width), Units.toEMU(height));
                    fis.close();
                } else if (list[images].isDirectory()) {
                    System.out.println("Directory - " + list[images].getName());
                    // If directory do nothing
                    // A recursive logic can be implemented to handle the files
                    // inside folders in source folder
                }
            }
            document.write(fos);
            fos.close();
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //------------------------------------OLD Sngle image take to word--------------
    /*to use it in implements ITestListener as below :
     *
     * 	saveSingleScreenshotToWrodDocument(result.getName());
     * NOT TOO good to use
     * */
    public void saveSingleScreenshotToWrodDocument(String testName_resultDOTgetName, String status) {
        try {
            // Step 1: Creating a blank document
            XWPFDocument document = new XWPFDocument();

            // Step 2: Creating a Paragraph using
            // createParagraph() method
            XWPFParagraph paragraph
                    = document.createParagraph();
            XWPFRun run = paragraph.createRun();

            // Step 3: Creating a File output stream of word
            // document at the required location
            FileOutputStream fos = new FileOutputStream(
                    new File(screenshotsFolderNameAndPath + testName_resultDOTgetName + "_" + status + "_" + GetCurrenDateAndTime() + ".docx"));//right place with right test name

            // Step 4: Creating a file input stream of image by
            // specifying its path
            //getting the folder path dynamically
            File image = new File(fullDirectory + testName_resultDOTgetName + "/" + "image.png");
            System.out.println(screenshotsFolderNameAndPath + testName_resultDOTgetName);
            FileInputStream imageData
                    = new FileInputStream(image);
            // Step 5: Retrieving the image file name and image
            // type
            //        int imageType = XWPFDocument.PICTURE_TYPE_JPEG;
            int imageType = XWPFDocument.PICTURE_TYPE_PNG;
            String imageFileName = image.getName();
            // Step 6: Setting the width and height of the image
            // in pixels.
            int width = 300;
            int height = 350;
            // Step 7: Adding the picture using the addPicture()
            // method and writing into the document
            run.addPicture(imageData, imageType, imageFileName,
                    Units.toEMU(width),
                    Units.toEMU(height));
            document.write(fos);
            // Step 8: Closing the connections
            fos.close();
            document.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void SaveScreenShotsToExtentReport(String testName) {
        /**
         * we'll need the below dependency
         <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
         <dependency>
         <groupId>com.aventstack</groupId>
         <artifactId>extentreports</artifactId>
         <version>5.0.9</version>
         </dependency>
         */

    }
}
