/**
* Page object for Profile Page 
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

public class ProfilePage {
	
	private Header header;
	private Footer footer;
	private HeaderBanner headerBanner;
	public WebDriver webDriver;
	public WrapperMethods wrapperMethods;
	String firstNameId = "firstName";
	String lastNameId = "lastName";
	String genderId = "gender";
	String ageId = "age";
	String addressId = "address";
	String phoneId = "phone";
	String hobbyId = "hobby";
	String curPasswordId = "currentPassword";
	String newPasswordId = "newPassword";
	String newConfirmPasswordId = "newPasswordConfirmation"; 
	String languageId = "language"; 
	String saveBtnCss = "button.btn";
	String cancelCss = "a.btn";
	String successMessageXpath = "//div[@class='result alert alert-success hidden-md-down']";
	String passwordErrorCss = "div.result:nth-child(2)";
	       
    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.footer = new Footer(webDriver);
        this.headerBanner = new HeaderBanner(webDriver);
        this.header = new Header(webDriver);
        this.wrapperMethods = new WrapperMethods();
    }
    
	public void fillBasicDetails(String firstName, String lastName) {
		try {
			wrapperMethods.clearTextElement(webDriver, firstNameId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, firstNameId, SelectorType.Id, firstName);
			wrapperMethods.clearTextElement(webDriver, lastNameId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, lastNameId, SelectorType.Id, lastName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fillAdditionalInfo(String gender, String age, String address, String phone, String hobby, String language) {
		try {
			wrapperMethods.clearTextElement(webDriver, genderId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, genderId, SelectorType.Id, gender);
			wrapperMethods.clearTextElement(webDriver, ageId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, ageId, SelectorType.Id, age);
			wrapperMethods.clearTextElement(webDriver, addressId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, addressId, SelectorType.Id, address);
			wrapperMethods.clearTextElement(webDriver, phoneId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, phoneId, SelectorType.Id, phone);
			wrapperMethods.selectValueDropdown(webDriver, hobbyId, SelectorType.Id, hobby);
			wrapperMethods.selectValueDropdown(webDriver, languageId, SelectorType.Id, language);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fillUpdatePasswordForm(String curPassword, String newPassword) {
		try {
			wrapperMethods.clearTextElement(webDriver, curPasswordId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, curPasswordId, SelectorType.Id, curPassword);
			wrapperMethods.clearTextElement(webDriver, newPasswordId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, newPasswordId, SelectorType.Id, newPassword);
			wrapperMethods.clearTextElement(webDriver, newConfirmPasswordId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, newConfirmPasswordId, SelectorType.Id, newPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickSave() {
		try {
			wrapperMethods.clickElement(webDriver, saveBtnCss, SelectorType.CssSelector);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickCancel() {
		try {
			wrapperMethods.clickElement(webDriver, cancelCss, SelectorType.CssSelector);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getSuccessMessage() {
		try {
			return wrapperMethods.getElementText(webDriver, successMessageXpath, SelectorType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPasswordError() {
		try {
			return wrapperMethods.getElementText(webDriver, passwordErrorCss, SelectorType.CssSelector);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    public String getFirstName() {
    	try {
			return wrapperMethods.getExistingValueTextbox(webDriver, firstNameId, SelectorType.Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }    
    
    public String getLastName() {
    	try {
			return wrapperMethods.getExistingValueTextbox(webDriver, lastNameId, SelectorType.Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }    
    
    
    public String getGender() {
    	try {
			return wrapperMethods.getExistingValueTextbox(webDriver, genderId, SelectorType.Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    } 
    
    public String getAge() {
    	try {
			return wrapperMethods.getExistingValueTextbox(webDriver, ageId, SelectorType.Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public String getAddress() {
    	try {
			return wrapperMethods.getExistingValueTextbox(webDriver, addressId, SelectorType.Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public String getPhone() {
    	try {
			return wrapperMethods.getExistingValueTextbox(webDriver, phoneId, SelectorType.Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public String getHobby() {
    	try {
			return wrapperMethods.getSelectedValueDropdown(webDriver, hobbyId, SelectorType.Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public String getLanguage() {
    	try {
			return wrapperMethods.getSelectedValueDropdown(webDriver, languageId, SelectorType.Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public void clickLogout() {
    	header.clickLogout();
    }
        
    public void login(String username, String password) {
    	header.login(username, password);
    }
    
    public boolean checkLogoutVisible() {
    	return header.checkLogoutVisible();
    }
}