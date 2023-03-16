package common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * https://testng.org/doc/documentation-main.html#rerunning
 */
public class Retry implements IRetryAnalyzer {
    int counter = 0;
    int retryLimit = 3;

    @Override
    public boolean retry(ITestResult result) {
        if(counter < retryLimit) {
            counter ++;
            return true;
        }
        return false;
    }
}
