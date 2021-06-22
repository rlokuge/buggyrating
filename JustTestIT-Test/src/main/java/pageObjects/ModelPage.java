/**
* Page object for Model Page 
*
* @author  Rumesh Lokuge
* @version 1.0
* @since   2021-06-20
*/

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basePageObjects.Header;
import basePageObjects.Footer;
import basePageObjects.HeaderBanner;
import utilities.WrapperMethods;
import utilities.SeleniumSelectorType.SelectorType;

@SuppressWarnings("unused")

public class ModelPage {
	
	private Header header;
	private Footer footer;
	private HeaderBanner headerBanner;
	public WebDriver webDriver;
	public WrapperMethods wrapperMethods;
	String numVotesCss = "div.card:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > strong:nth-child(1)"; 
	String commentBoxId = "comment";
	String voteButtonCss = ".btn";
	String successMsgCss = ".card-text";
	String latestCommentCss = ".table > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3)";
	
    public ModelPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.footer = new Footer(webDriver);
        this.headerBanner = new HeaderBanner(webDriver);
        this.header = new Header(webDriver);
        this.wrapperMethods = new WrapperMethods();
    }
    
	public void clickVote() {
		try {
			wrapperMethods.clickElement(webDriver, voteButtonCss, SelectorType.CssSelector);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addComment(String comment) {
		try {
			wrapperMethods.enterTextElement(webDriver, commentBoxId, SelectorType.Id, comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getNumVotes() {
		try {
			return Integer.parseInt(wrapperMethods.getElementText(webDriver, numVotesCss, SelectorType.CssSelector));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public String getSuccessMsg() {
		try {
			return wrapperMethods.getElementText(webDriver, successMsgCss, SelectorType.CssSelector);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getLatestComment() {
		try {
			return wrapperMethods.getElementText(webDriver, latestCommentCss, SelectorType.CssSelector);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void clickLogout() {
		header.clickLogout();		
	}
}