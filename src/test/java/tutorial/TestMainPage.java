package tutorial;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import webelements.PracticePage;

public class TestMainPage extends BaseClass
{
    PracticePage practicePage;

    @Before
    public void setupTest()
    {
        practicePage = new PracticePage(driver);
    }

    @Test
    public void testNavigateToURL()
    {
        // 1. action : navigate to url
        driver.get("https://learn.letskodeit.com/p/practice");
    }

    @Test
    public void testGetCurrentURL()
    {
        // 2. action : Güncel URL alır.
        String currentUrl = driver.getCurrentUrl();
    }

    @Test
    public void testClick()
    {
        // 3. Action : DOM element click işlemi.
        driver.navigate().to("https://apsiyon.com");
        WebElement featuresMenu = driver.findElement(By.cssSelector(".main-navigation [href='/ozellikler']"));
        featuresMenu.click();
    }

    @Test
    public void testSelecBox()
    {
        // 4. Action : Selectbox element seçme
        driver.navigate().to("https://learn.letskodeit.com/p/practice");
        new Select(driver.findElement(By.id("carselect"))).selectByIndex(1);
        new Select(driver.findElement(By.id("carselect"))).selectByValue("honda");
        new Select(driver.findElement(By.id("carselect"))).selectByVisibleText("Honda");
    }

    @Test
    public void testSendKeys()
    {
        // 5. Action : SendKeys
        driver.navigate().to("https://learn.letskodeit.com/p/practice");
        driver.findElement(By.id("name")).sendKeys("Selenium Tutorial");
    }

    @Test
    public void testIsDisplayed()
    {
        // 6. Action : isDisplayed
        driver.navigate().to("https://learn.letskodeit.com/p/practice");
        Boolean elementIsDisplayed = driver.findElement(By.name("filepicker_comm_iframe")).isDisplayed();
        System.out.println(elementIsDisplayed);
    }

    @Test
    public void testClear()
    {
        // 7. Action : Clear
        driver.navigate().to("https://learn.letskodeit.com/p/practice");
        driver.findElement(By.id("name")).sendKeys("Selenium Tutorial");
        driver.findElement(By.id("name")).clear();

    }

    @Test
    public void testGetAttribute()
    {
        // 8 Action : get Attribute
        driver.navigate().to("https://learn.letskodeit.com/p/practice");

        practicePage.hideTextbox.click();
        String displayedTextGetStyle = practicePage.displayedText.getAttribute("style");

        if (displayedTextGetStyle.equals("display: none;"))
        {
            practicePage.showTextBox.click();
            String currentdisplayedTextGetStyle = practicePage.displayedText.getAttribute("style");
            Assert.assertEquals("display: block;", currentdisplayedTextGetStyle);
        }
    }

}
