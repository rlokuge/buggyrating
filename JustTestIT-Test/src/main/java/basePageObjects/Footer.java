/**
* Object component for footer 
*
* @author  Rumesh Lokuge
* @version 1.0
* @since   2021-06-20
*/
package basePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer {
	
	public WebDriver webDriver;
	
    @FindBy(className = "footer")
    private WebElement footer;
    
    @FindBy(xpath = "//p[contains(text(),'© 2016 Buggy Software, Inc.')]")
    private WebElement copyWriteStatement;
    
    @FindBy(xpath = "//img[@src='/img/FB-f-Logo__blue_29.png']")
    private WebElement facebookLink; 
    
    @FindBy(xpath = "//img[@src='/img/twitter.png']")
    private WebElement twitterLink;

    public Footer(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}