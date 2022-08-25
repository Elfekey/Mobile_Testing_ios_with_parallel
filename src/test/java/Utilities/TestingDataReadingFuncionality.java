package Utilities;


import org.testng.annotations.Test;

public class TestingDataReadingFuncionality {
@Test
public void T(){
    ReadExcelData o = new ReadExcelData("TestData");
   // System.out.println(System.getProperty("user.dir"));
    String result=o.GetDataByFirstRowDataNameOnly("Passowrd1");
    System.out.println(result);
    result=o.GetDataByFirstRowDataNameOnly("Passowrd2");
    System.out.println(result);
    result=o.GetDataByFirstRowDataNameOnly("User1");
    System.out.println(result);
    result=o.GetDataByFirstRowDataNameOnly("User2");
    System.out.println(result);
    result=o.GetDataByFirstRowDataNameOnly("Date");
    System.out.println(result);
//---------------------
    ReadExcelData o2 = new ReadExcelData("TestData","Sheet 1");
    result=o2.GetDataByFirstRowDataNameOnly("UserTset");
    System.out.println(result);
   result= o2.GetDataByFirstRowDataNameOnly("PasswordTest");
    System.out.println(result);
    result= o2.getDataFromExcellByeRowNameAndColumnName("PasswordTest", "V3");
    System.out.println(result);



}
    public static void main(String[] args) {

        ReadExcelData o1 = new ReadExcelData("HelloWorld");//with only fileName
        String dataresult = o1.GetDataByFirstRowDataNameOnly("Passowrd2");
        System.out.println(dataresult);

        dataresult= o1.GetDataByFirstRowDataNameOnly("Passowrd2");
        System.out.println(dataresult);

        dataresult= o1.GetDataByFirstRowDataNameOnly("User1");
        System.out.println(dataresult);

        dataresult= o1.GetDataByFirstRowDataNameOnly("User3");
        System.out.println(dataresult);
        System.out.println("--------------------------------------------");
        dataresult=o1.getDataFromExcellByeRowNameAndColumnName("Passowrd1", "V2");
        System.out.println(dataresult);

        dataresult=o1.getDataFromExcellByeRowNameAndColumnName("Passowrd2", "V2");
        System.out.println(dataresult);

        dataresult=o1.getDataFromExcellByeRowNameAndColumnName("User1", "V2");
        System.out.println(dataresult);

        dataresult=o1.getDataFromExcellByeRowNameAndColumnName("User3", "V2");
        System.out.println(dataresult);
        System.out.println("--------------------------------------------");

        ReadExcelData o2 = new ReadExcelData("HelloWorld", "Sheet1");

        dataresult=o2.GetDataByFirstRowDataNameOnly("Child");
        System.out.println(dataresult);

        dataresult=o2.GetDataByFirstRowDataNameOnly("Dad");
        System.out.println(dataresult);

        dataresult=o2.getDataFromExcellByeRowNameAndColumnName("Child", "V2");
        System.out.println(dataresult);

        dataresult=o2.getDataFromExcellByeRowNameAndColumnName("Dad", "V2");
        System.out.println(dataresult);
        dataresult=o2.getDataFromExcellByeRowNameAndColumnName("Dad", "V1");
        System.out.println(dataresult);
    }
}