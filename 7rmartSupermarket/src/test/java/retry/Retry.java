package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 2; // retry failed testcase 2 times

	public boolean retry(ITestResult result) {
		// retry is an inbuilt method in IRetryAnalyzer interface
		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}
}
