/**
* This class creates Regression testsuite
*
* @author  Rumesh Lokuge
* @version 1.0
* @since   2021-06-20
*/

package testSuites.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import testClasses.LoginTests;
import testClasses.ManageProfileTests;
import testClasses.RegistrationTests;
import testClasses.VotingTests;

import org.junit.experimental.categories.Categories;

@RunWith(Categories.class)
@Categories.IncludeCategory(Regression.class)
@SuiteClasses({LoginTests.class, RegistrationTests.class, VotingTests.class, ManageProfileTests.class})

public class RegressionSuite {

}