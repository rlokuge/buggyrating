/**
* Object component for header banner of the website 
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

public class HeaderBanner {
	
	public WebDriver webDriver;
	
    @FindBy(className = "jumbotron jumbotron-fluid")
    private WebElement headBanner;
    
    @FindBy(css = ".display-4")
    private WebElement headerBannerText;
    
    @FindBy(className = "img-fluid")
    private WebElement headerBannerImage; 

    public HeaderBanner(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}