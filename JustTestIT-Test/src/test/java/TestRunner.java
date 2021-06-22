/**
* Test Runner class
*
* @author  Rumesh Lokuge
* @version 1.0
* @since   2021-06-20
*/

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import testSuites.java.RegressionSuite;

public class TestRunner {

    public static void main(String[] args) {
    	Result result = JUnitCore.runClasses(RegressionSuite.class);
    	for(Failure failure : result.getFailures()) {
    		System.out.println(failure.toString());
    	}
    	System.out.println(result.wasSuccessful());
    }
}