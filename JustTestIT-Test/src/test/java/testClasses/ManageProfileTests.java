/**
* Test class for all the tests related to update profile and update password
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
import pageObjects.ProfilePage;
import testBase.BaseTestClass;
import testSuites.java.Regression;

@Category(Regression.class)
public class ManageProfileTests extends BaseTestClass {

	@Test
	// Verify the process of process of updating the basic details and checks
	// whether details actually updated after the update process
	public void testUpdateBasicInfo() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("test1111", "Password1!");
		homePage.clickProfile();
		ProfilePage profilePage = new ProfilePage(getDriver());
		profilePage.fillBasicDetails("test1", "test2");
		profilePage.clickSave();
		Assert.assertEquals("Update profile success message isn't visible", "The profile has been saved successful",
				profilePage.getSuccessMessage());

		profilePage.clickLogout();
		profilePage.login("test1111", "Password1!");
		Assert.assertEquals("First name isn't updated", "test1", profilePage.getFirstName());
		Assert.assertEquals("First name isn't updated", "test2", profilePage.getLastName());
		homePage.clickLogout();
	}

	@Test

	// Verify the process of process of updating the Aditional info and checks
	// whether details actually updated after the update process
	public void testUpdateAdditionalInfo() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("test1111", "Password1!");
		homePage.clickProfile();
		ProfilePage profilePage = new ProfilePage(getDriver());
		profilePage.fillAdditionalInfo("Male", "31", "2, Queen St, Auckland", "12345456", "Movies", "English");
		;
		profilePage.clickSave();
		Assert.assertEquals("Update profile success message isn't visible", "The profile has been saved successful",
				profilePage.getSuccessMessage());

		profilePage.clickLogout();
		profilePage.login("test1111", "Password1!");
		Assert.assertEquals("Gender isn't updated", "Male", profilePage.getGender());
		Assert.assertEquals("Age isn't updated", "31", profilePage.getAge());
		Assert.assertEquals("Address isn't updated", "2, Queen St, Auckland", profilePage.getAddress());
		Assert.assertEquals("Phone isn't updated", "12345456", profilePage.getPhone());
		Assert.assertEquals("Hobby isn't updated", "Movies", profilePage.getHobby());
		Assert.assertEquals("Language isn't updated", "English", profilePage.getLanguage());
		homePage.clickLogout();
	}

	@Test
	// Verify that the cancel update function navigetes user to Home page
	public void testCancelUpdateProfile() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("test1111", "Password1!");
		homePage.clickProfile();
		ProfilePage profilePage = new ProfilePage(getDriver());
		profilePage.fillBasicDetails("test1", "test2");
		profilePage.clickCancel();
		Assert.assertTrue("Overall Rating Section in homepage isn't visible",
				homePage.checkOverallRatingSectionVisible());
		homePage.clickLogout();
	}

	@Test
	// Verify the update password functionality and checks whether user can login
	// with updated password
	public void testUpdatePassword() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("test1111", "Password2!");
		homePage.clickProfile();
		ProfilePage profilePage = new ProfilePage(getDriver());
		profilePage.fillUpdatePasswordForm("Password2!", "Password1!");
		;
		profilePage.clickSave();
		Assert.assertEquals("Update profile success message isn't visible", "The profile has been saved successful",
				profilePage.getSuccessMessage());
		profilePage.clickLogout();

		profilePage.login("test1111", "Password1!");
		Assert.assertTrue("Logout button isn't visible", profilePage.checkLogoutVisible());
		profilePage.clickLogout();
	}

	@Test
	// Verify whether its generates the expected error message of user enter
	// incorrect current password during the Update Password process
	public void testIncorrectCurrentPasswordMessage() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("test1111", "Password1!");
		homePage.clickProfile();
		ProfilePage profilePage = new ProfilePage(getDriver());
		profilePage.fillUpdatePasswordForm("Password5!", "Password3!");
		;
		profilePage.clickSave();
		Assert.assertEquals("Incorrect current password message isn't visible",
				"NotAuthorizedException: Incorrect username or password.", profilePage.getPasswordError());
		profilePage.clickLogout();
	}

	@Test
	// Verify whether its generates the expected error message of user enter invalid
	// new password during the Update Password process
	public void testInvalidNewPasswordMessage() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("test1111", "Password1!");
		homePage.clickProfile();
		ProfilePage profilePage = new ProfilePage(getDriver());
		profilePage.fillUpdatePasswordForm("Password1!", "Pass");
		;
		profilePage.clickSave();
		Assert.assertEquals("Invalid new password message isn't visible",
				"InvalidParameter: 1 validation error(s) found. - minimum field size of 6, ChangePasswordInput.ProposedPassword.",
				profilePage.getPasswordError());
		profilePage.clickLogout();
	}
}