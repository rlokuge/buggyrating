/**
* Test class for all the voting realted tests
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
import pageObjects.ModelPage;
import pageObjects.OverallRatingPage;
import testBase.BaseTestClass;
import testSuites.java.Regression;

@Category(Regression.class)
public class VotingTests extends BaseTestClass {

	@Test
	// This verifies the successful volting for a model by checking the success
	// message, updated number of votes and new added comment
	public void testSuccessfulVoting() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("test222220", "Password2!");
		homePage.clickOverallRatingLink();
		OverallRatingPage overallRatingPage = new OverallRatingPage(getDriver());
		overallRatingPage.clickFirstModel();
		ModelPage modelPage = new ModelPage(getDriver());
		int getCurrentVotes = modelPage.getNumVotes();
		modelPage.addComment("ABC");
		modelPage.clickVote();
		Assert.assertEquals("Voting success message isn't visible", "Thank you for your vote!",
				modelPage.getSuccessMsg());
		Assert.assertEquals("Number of votes for the model isn't updated", getCurrentVotes + 1,
				modelPage.getNumVotes());
		Assert.assertEquals("Comment from the voting isn't added to the page", "ABC", modelPage.getLatestComment());
		modelPage.clickLogout();
	}

	@Test
	// This verifies the successful volting for a model by checking the success
	// message and updated number of votes
	public void testSuccessfulVotingWithoutComment() {
		HomePage homePage = new HomePage(getDriver());
		homePage.login("test2222200", "Password2!");
		homePage.clickOverallRatingLink();
		OverallRatingPage overallRatingPage = new OverallRatingPage(getDriver());
		overallRatingPage.clickFirstModel();
		ModelPage modelPage = new ModelPage(getDriver());
		int getCurrentVotes = modelPage.getNumVotes();
		modelPage.clickVote();
		Assert.assertEquals("Voting success message isn't visible", "Thank you for your vote!",
				modelPage.getSuccessMsg());
		Assert.assertEquals("Number of votes for the model isn't updated", getCurrentVotes + 1,
				modelPage.getNumVotes());
		modelPage.clickLogout();
	}
}