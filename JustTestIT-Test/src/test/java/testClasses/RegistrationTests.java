/**
* Test class for all the registration related tests
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
import pageObjects.RegistrationPage;
import testBase.BaseTestClass;
import testSuites.java.Regression;

@Category(Regression.class)
public class RegistrationTests extends BaseTestClass {

	@Test
	// Verify the successful registration by checking the registration process as
	// well as the login after the registration
	public void testSuccessfulRegistration() {
		HomePage homePage = new HomePage(getDriver());
		homePage.clickRegister();
		RegistrationPage registerPage = new RegistrationPage(getDriver());
		registerPage.fillRegisterForm("test2222200", "test2", "test22", "Password2!");
		registerPage.clickRegister();
		Assert.assertEquals("Registration success message isn't visible", "Registration is successful",
				registerPage.getSuccessMessage());
		homePage.login("test2222200", "Password2!");
		homePage.clickLogout();
	}

	@Test
	// Verify cancel registration by checking users is navigated to homepage after
	// clicking cancel in registration page
	public void testCancelRegistration() {
		HomePage homePage = new HomePage(getDriver());
		homePage.clickRegister();
		RegistrationPage registerPage = new RegistrationPage(getDriver());
		registerPage.fillRegisterForm("t32222", "test2", "test22", "Password2@");
		registerPage.clickCancel();
		Assert.assertTrue("Overall Rating Section in homepage isn't visible",
				homePage.checkOverallRatingSectionVisible());
	}

	@Test
	// Verify that it displays the expected error message if user try to register
	// with existing username
	public void testRegistrationWithExistingUsername() {
		HomePage homePage = new HomePage(getDriver());
		homePage.clickRegister();
		RegistrationPage registerPage = new RegistrationPage(getDriver());
		registerPage.fillRegisterForm("t32222", "test2", "test22", "Password2@");
		registerPage.clickRegister();
		Assert.assertEquals("Existing user error message isn't visible", "UsernameExistsException: User already exists",
				registerPage.getExistingUserError());
	}

}