package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class RerunFailedTests implements IRetryAnalyzer{
//We use this class to rerun the failed test cases
    //@Test(retryAnalyzer = RerunFailedTests.class)//analyzer is to rerun if the test failed
    //we have to use the above  to use it in any test
        private int retryCount = 0;
        private static final int maxRetryCount = 4;
        @Override
        public boolean retry(ITestResult result) {
            if (retryCount < maxRetryCount) {
                retryCount++;
                return true;
            }
            return false;
        }
    }


