/**
* Page object for Home Page 
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

public class HomePage {
	
	private Header header;
	private Footer footer;
	private HeaderBanner headerBanner;
	public WebDriver webDriver;
	public WrapperMethods wrapperMethods; 
	String overallRatingSectionCss = "div.col-md-4:nth-child(3)"; 
	String overallRatingXpath = "//a[@href='/overall']//img[@class='img-fluid center-block']";

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.footer = new Footer(webDriver);
        this.headerBanner = new HeaderBanner(webDriver);
        this.header = new Header(webDriver);
		this.wrapperMethods = new WrapperMethods();
    }
    
    public void clickLogout() {
    	header.clickLogout();
    }
    
    public boolean checkLogoutVisible() {
    	return header.checkLogoutVisible();
    }
    
    public boolean checkLoginButtonVisible() {
    	return header.checkLoginButtonVisible();
    }
    
    public void login(String username, String password) {
    	header.login(username, password);
    }
    
    public String getLoginError() {

    	return header.getLoginError();
    }
    
    public void clickRegister() {
    	header.clickRegister();
    }
    
    public boolean checkOverallRatingSectionVisible() {
    	try {
			return wrapperMethods.elementAvailable(webDriver, overallRatingSectionCss, SelectorType.CssSelector);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public void clickProfile() {
    	header.clickProfile();
    }
    
    public void clickOverallRatingLink() {
    	try {
			wrapperMethods.clickElement(webDriver, overallRatingXpath, SelectorType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}