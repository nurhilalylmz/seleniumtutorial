package webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApsiyonHomePage
{
    public ApsiyonHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#intercom-container .intercom-launcher")
    public WebElement intercomLauncher;

    @FindBy(css =  "i#intercom-container > div > iframe.intercom-launcher-frame.intercom-launcher-frame-shadow")
    public WebElement mainPageIFrame;

    @FindBy(name = "intercom-frame")
    public WebElement intercomFrame;

}
