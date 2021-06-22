/**
* Test class for all the login tests
*
* @author  Rumesh Lokuge
* @version 1.0
* @since   2021-06-20
*/
package testClasses;

import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;
import pageObjects.HomePage;
import testBase.BaseTestClass;
import testSuites.java.Regression;

@Category(Regression.class)
public class LoginTests extends BaseTestClass {

	@Test
	// Verify whether user can successfully login and logout
	public void testSuccessfulLogin() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("test1111", "Password1!");
		Assert.assertTrue("Logout button isn't visible", homePage.checkLogoutVisible());
		homePage.clickLogout();
		Assert.assertTrue("Login button isn't visible", homePage.checkLoginButtonVisible());
	}

	@Test
	// Verify that the user is unable to login with invalid credentials and displays
	// expected error message
	public void testLoginInvalidCredentials() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("user", "9999");
		Assert.assertEquals("Login error isn't visible", "Invalid username/password", homePage.getLoginError());
	}

	// Verify whether it display expected error message if user tries to login
	// without any credentials
	@Test
	public void testLoginWithNoCredentials() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("", "");
		Assert.assertTrue("Login button isn't visible", homePage.checkLoginButtonVisible());
	}

	@Test
	// Verify user is unable to login without entering valid username
	public void testLoginWithNoUsername() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("", "Password1!");
		Assert.assertTrue("Login button isn't visible", homePage.checkLoginButtonVisible());
	}

	@Test
	// Verify user is unable to login without entering valid password
	public void testLoginWithNoPassword() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("test1111", "");
		Assert.assertTrue("Login button isn't visible", homePage.checkLoginButtonVisible());
	}
}