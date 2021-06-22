/**
* Support class create wrapper methods for Web Elements functionalities
* These functions make sure Web Elements are handled and conduct operations on them effieciently while handling the expceptions
* These methods adds realiability and robustness to the framework 
*
* @author  Rumesh Lokuge
* @version 1.0
* @since   2021-06-20
*/

package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.SeleniumSelectorType.SelectorType;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class WrapperMethods {

	private final static Logger logger = (Logger) LogManager.getLogger(WrapperMethods.class);

	public void clickElement(WebDriver driver, String selectorValue, SelectorType selectorType) throws Exception {
		try {
			(new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(findElement(selectorValue, selectorType)));
			driver.findElement(findElement(selectorValue, selectorType)).click();
		} catch (StaleElementReferenceException e) {
			driver.findElement(findElement(selectorValue, selectorType)).click();
		} catch (TimeoutException e) {
			logger.info("Element identified by " + findElement(selectorValue, selectorType).toString()
					+ " was not clickable");
		}
	}

	public void enterTextElement(WebDriver driver, String selectorValue, SelectorType selectorType, String value)
			throws Exception {
		try {
			(new WebDriverWait(driver, 10))
					.until(ExpectedConditions.visibilityOfElementLocated(findElement(selectorValue, selectorType)));
			driver.findElement(findElement(selectorValue, selectorType)).sendKeys(value);
		} catch (StaleElementReferenceException e) {
			driver.findElement(findElement(selectorValue, selectorType)).sendKeys(value);
		} catch (TimeoutException e) {
			logger.info("Terxtbox identified by " + findElement(selectorValue, selectorType).toString()
					+ " was not available to enter values");
		}
	}
	
	public void clearTextElement(WebDriver driver, String selectorValue, SelectorType selectorType)
			throws Exception {
		try {
			(new WebDriverWait(driver, 10))
					.until(ExpectedConditions.visibilityOfElementLocated(findElement(selectorValue, selectorType)));
			driver.findElement(findElement(selectorValue, selectorType)).clear();
		} catch (StaleElementReferenceException e) {
			driver.findElement(findElement(selectorValue, selectorType)).clear();
		} catch (TimeoutException e) {
			logger.info("Terxtbox identified by " + findElement(selectorValue, selectorType).toString()
					+ " was not available to clear values");
		}
	}

	public void selectValueDropdown(WebDriver driver, String selectorValue, SelectorType selectorType, String value)
			throws Exception {
		try {
			(new WebDriverWait(driver, 10))
					.until(ExpectedConditions.visibilityOfElementLocated(findElement(selectorValue, selectorType)));
			Select dropdown = new Select(driver.findElement(findElement(selectorValue, selectorType)));
			dropdown.selectByVisibleText(value);
		} catch (StaleElementReferenceException e) {
			Select dropdown = new Select(driver.findElement(findElement(selectorValue, selectorType)));
			dropdown.selectByVisibleText(value);
		} catch (TimeoutException e) {
			logger.info("Dropdpwn identified by " + findElement(selectorValue, selectorType).toString()
					+ " was not available to select given value");
		}
	}

	public String getElementLink(WebDriver driver, String selectorValue, SelectorType selectorType) throws Exception {
		try {
			(new WebDriverWait(driver, 10))
					.until(ExpectedConditions.visibilityOfElementLocated(findElement(selectorValue, selectorType)));
			return driver.findElement(findElement(selectorValue, selectorType)).getAttribute("href");
		} catch (StaleElementReferenceException e) {
			return driver.findElement(findElement(selectorValue, selectorType)).getAttribute("href");
		} catch (TimeoutException e) {
			logger.info("Element identified by " + findElement(selectorValue, selectorType).toString()
					+ " was not available to retrieve link");
		}
		return null;
	}

	public boolean elementAvailable(WebDriver driver, String selectorValue, SelectorType selectorType)
			throws Exception {
		try {
			(new WebDriverWait(driver, 10))
					.until(ExpectedConditions.visibilityOfElementLocated(findElement(selectorValue, selectorType)));
			return driver.findElement(findElement(selectorValue, selectorType)).isDisplayed();
		} catch (StaleElementReferenceException e) {
			return driver.findElement(findElement(selectorValue, selectorType)).isDisplayed();
		} catch (TimeoutException e) {
			logger.info("Element identified by " + findElement(selectorValue, selectorType).toString()
					+ " was not available");
		}
		return false;
	}

	public String getSelectedValueDropdown(WebDriver driver, String selectorValue, SelectorType selectorType)
			throws Exception {
		try {
			(new WebDriverWait(driver, 10))
					.until(ExpectedConditions.visibilityOfElementLocated(findElement(selectorValue, selectorType)));
			Select select = new Select(driver.findElement(findElement(selectorValue, selectorType)));
			return select.getFirstSelectedOption().getText();
		} catch (StaleElementReferenceException e) {
			Select select = new Select(driver.findElement(findElement(selectorValue, selectorType)));
			return select.getFirstSelectedOption().getText();
		} catch (TimeoutException e) {
			logger.info("Dropdpwn identified by " + findElement(selectorValue, selectorType).toString()
					+ " was not available to retrieve selected value");
		}
		return null;
	}

	public String getElementText(WebDriver driver, String selectorValue, SelectorType selectorType) throws Exception {
		try {
			(new WebDriverWait(driver, 10))
					.until(ExpectedConditions.visibilityOfElementLocated(findElement(selectorValue, selectorType)));
			return driver.findElement(findElement(selectorValue, selectorType)).getText();
		} catch (StaleElementReferenceException e) {
			return driver.findElement(findElement(selectorValue, selectorType)).getText();
		} catch (TimeoutException e) {
			logger.info("Element identified by " + findElement(selectorValue, selectorType).toString()
					+ " was not available to get text");
		}
		return null;
	}

	public String getExistingValueTextbox(WebDriver driver, String selectorValue, SelectorType selectorType)
			throws Exception {
		try {
			(new WebDriverWait(driver, 10))
					.until(ExpectedConditions.visibilityOfElementLocated(findElement(selectorValue, selectorType)));
			return driver.findElement(findElement(selectorValue, selectorType)).getAttribute("value");
		} catch (StaleElementReferenceException e) {
			return driver.findElement(findElement(selectorValue, selectorType)).getAttribute("value");
		} catch (TimeoutException e) {
			logger.info("Textbox identified by " + findElement(selectorValue, selectorType).toString()
					+ " was not available to get existing value");
		}
		return null;
	}

	private static By findElement(String selectorValue, SelectorType selectorType) throws Exception {
		if (!(selectorValue == null || selectorValue.length() == 0)) {
			switch (selectorType) {
			case Id:
				return By.id(selectorValue);
			case Xpath:
				return By.xpath(selectorValue);
			case TagName:
				return By.tagName(selectorValue);
			case CssSelector:
				return By.cssSelector(selectorValue);
			case ClassName:
				return By.className(selectorValue);
			case LinkText:
				return By.linkText(selectorValue);
			case PartialLinkText:
				return By.partialLinkText(selectorValue);
			default:
				break;
			}
		} else {
			throw new Exception("Selector value cannot be null or empty.");
		}
		return null;
	}
}