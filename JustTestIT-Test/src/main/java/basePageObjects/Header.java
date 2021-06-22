/**
* Object component for header of the website 
*
* @author  Rumesh Lokuge
* @version 1.0
* @since   2021-06-20
*/

package basePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.WrapperMethods;
import utilities.SeleniumSelectorType.SelectorType;

public class Header {
	
	public WebDriver webDriver;
	public WrapperMethods wrapperMethods; 
    String usernameCss = "input.form-control:nth-child(1)";
    String passwordCss = "input.form-control-sm:nth-child(2)";
    String loginXpath = "//button[@type='submit']";
    String logoutXpath = "//a[contains(text(),'Logout')]";
    String errorXpath = "//span[@class='label label-warning']"; 
    String registerText = "Register";
    String profileXpath = "//a[contains(text(),'Profile')]";
    
    public Header(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wrapperMethods = new WrapperMethods();
        PageFactory.initElements(webDriver, this);
    }
    
    public void clickLogout() {
    	try {
			wrapperMethods.clickElement(webDriver, logoutXpath, SelectorType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
      
    public boolean checkLogoutVisible() {
    	try {
			return wrapperMethods.elementAvailable(webDriver, logoutXpath, SelectorType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public boolean checkLoginButtonVisible() {
    	try {
			return wrapperMethods.elementAvailable(webDriver, loginXpath, SelectorType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public void login(String username, String password) {
    	try {
    		wrapperMethods.clearTextElement(webDriver, usernameCss, SelectorType.CssSelector);
			wrapperMethods.enterTextElement(webDriver, usernameCss, SelectorType.CssSelector, username);
			wrapperMethods.clearTextElement(webDriver, passwordCss, SelectorType.CssSelector);
	    	wrapperMethods.enterTextElement(webDriver, passwordCss, SelectorType.CssSelector, password);
	    	wrapperMethods.clickElement(webDriver, loginXpath, SelectorType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public String getLoginError() {
    	try {
			return wrapperMethods.getElementText(webDriver, errorXpath, SelectorType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public void clickRegister() {
    	try {
			wrapperMethods.clickElement(webDriver, registerText, SelectorType.LinkText);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void clickProfile() {
    	try {
			wrapperMethods.clickElement(webDriver, profileXpath, SelectorType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}