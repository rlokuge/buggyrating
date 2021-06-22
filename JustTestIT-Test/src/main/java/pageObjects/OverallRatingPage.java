/**
* Page object for Overall Rating Page 
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

public class OverallRatingPage {
	
	private Header header;
	private Footer footer;
	private HeaderBanner headerBanner;
	public WebDriver webDriver;
	public WrapperMethods wrapperMethods;
	String firstModelLinkCss = ".cars > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3) > a:nth-child(1)";
	
    public OverallRatingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.footer = new Footer(webDriver);
        this.headerBanner = new HeaderBanner(webDriver);
        this.header = new Header(webDriver);
        this.wrapperMethods = new WrapperMethods();
    }
    
	public void clickFirstModel() {
		try {
			wrapperMethods.clickElement(webDriver, firstModelLinkCss, SelectorType.CssSelector);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}