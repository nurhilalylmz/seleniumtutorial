package webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePage
{
    public PracticePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    public WebElement nameInput;

    @FindBy(id = "hide-textbox")
    public WebElement hideTextbox;

    @FindBy(id = "displayed-text")
    public WebElement displayedText;

    @FindBy(id = "show-textbox")
    public WebElement showTextBox;


}
