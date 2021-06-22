/**
* Page object for Registration Page 
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

public class RegistrationPage {

	private Header header;
	private Footer footer;
	private HeaderBanner headerBanner;
	public WebDriver webDriver;
	public WrapperMethods wrapperMethods;
	String usernameId = "username";
	String firstNameId = "firstName";
	String lastNameId = "lastName";
	String passwordId = "password";
	String confirmPasswordId = "confirmPassword";
	String registerXpath = "//button[contains(text(),'Register')]";
	String cancelXpath = "//a[@class='btn']";
	String existingUserErrorXpath = "//div[@class='result alert alert-danger']";
	String successMessageCss = ".result";
	String passwordMismatchErrorCss = "div.form-group:nth-child(5) > div:nth-child(3)";

	public RegistrationPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		this.footer = new Footer(webDriver);
		this.headerBanner = new HeaderBanner(webDriver);
		this.header = new Header(webDriver);
		this.wrapperMethods = new WrapperMethods();
	}

	public void fillRegisterForm(String username, String firstName, String lastName, String password) {
		try {
			wrapperMethods.clearTextElement(webDriver, usernameId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, usernameId, SelectorType.Id, username);
			wrapperMethods.clearTextElement(webDriver, firstNameId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, firstNameId, SelectorType.Id, firstName);
			wrapperMethods.clearTextElement(webDriver, lastNameId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, lastNameId, SelectorType.Id, lastName);
			wrapperMethods.clearTextElement(webDriver, passwordId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, passwordId, SelectorType.Id, password);
			wrapperMethods.clearTextElement(webDriver, confirmPasswordId, SelectorType.Id);
			wrapperMethods.enterTextElement(webDriver, confirmPasswordId, SelectorType.Id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickRegister() {
		try {
			wrapperMethods.clickElement(webDriver, registerXpath, SelectorType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickCancel() {
		try {
			wrapperMethods.clickElement(webDriver, cancelXpath, SelectorType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getExistingUserError() {
		try {
			return wrapperMethods.getElementText(webDriver, existingUserErrorXpath, SelectorType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPasswordMismatchError() {
		try {
			return wrapperMethods.getElementText(webDriver, passwordMismatchErrorCss, SelectorType.CssSelector);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getSuccessMessage() {
		try {
			return wrapperMethods.getElementText(webDriver, successMessageCss, SelectorType.CssSelector);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void clickLogout() {
		header.clickLogout();
	}

	public boolean checkLoginButtonVisible() {
		return header.checkLoginButtonVisible();
	}

	public void login(String username, String password) {
		header.login(username, password);
	}
}